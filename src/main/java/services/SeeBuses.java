package services;

import java.sql.*;
import java.util.ArrayList;
import lib.AgentDetails;
import lib.BusDetails;
import lib.ScheduleDetails;
import lib.StopDetails;

public interface SeeBuses {

    default BusDetails[] seeBuses(AgentDetails agent) throws Exception {
        // Authenticate the agent
        try {
            new services.Api().loginAgent(agent.mobile, agent.otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        services.SQLConnector x = new services.SQLConnector();
        ArrayList<BusDetails> bds = new ArrayList<>();
        String query = "SELECT * FROM buses WHERE agent = ?";

        try (PreparedStatement pstmt = x.conn.prepareStatement(query)) {
            pstmt.setString(1, agent.id);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String busNumber = rs.getString("number");

                    // Fetch schedule details
                    ScheduleDetails schedule = fetchScheduleDetails(busNumber, x);

                    // Fetch stop details
                    StopDetails[] stops = fetchStopDetails(schedule.scheduleId, x);
                    int interimStops = stops.length - 2; // Assuming first and last stops are not interim

                    bds.add(new BusDetails(
                            rs.getString("name"),
                            busNumber,
                            rs.getString("standing_fare"),
                            rs.getString("sitting_fare"),
                            schedule,
                            stops,
                            interimStops,
                            rs.getString("agent")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error fetching bus details.");
        } finally {
            x.conn.close();
        }

        return bds.toArray(new BusDetails[0]);
    }

    default ScheduleDetails fetchScheduleDetails(String busNumber, services.SQLConnector x) throws SQLException {
        String scheduleQuery = "SELECT * FROM schedules WHERE bus_number = ?";
        try (PreparedStatement pstmt = x.conn.prepareStatement(scheduleQuery)) {
            pstmt.setString(1, busNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new ScheduleDetails(
                            rs.getString("schedule_id"),
                            rs.getString("days"),
                            rs.getString("bus_number")
                    );
                } else {
                    throw new SQLException("No schedule found for bus number: " + busNumber);
                }
            }
        }
    }

    default StopDetails[] fetchStopDetails(String scheduleId, services.SQLConnector x) throws SQLException {
        String stopQuery = "SELECT * FROM stops WHERE schedule_id = ? ORDER BY stop_sequence";
        ArrayList<StopDetails> stopsList = new ArrayList<>();
        try (PreparedStatement pstmt = x.conn.prepareStatement(stopQuery)) {
            pstmt.setString(1, scheduleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    stopsList.add(new StopDetails(
                            rs.getString("schedule_id"),
                            rs.getString("stop_name"),
                            rs.getInt("stop_sequence"),
                            rs.getString("arrival")
                    ));
                }
            }
        }
        return stopsList.toArray(new StopDetails[0]);
    }
}
