package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lib.BusDetails;
import lib.ScheduleDetails;
import lib.StopDetails;

interface SearchBuses {

    default public BusDetails[] searchBuses(String source, String dest, String day) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        ArrayList<BusDetails> busList = new ArrayList<>();
        String query = "SELECT b.name, b.number, b.agent, b.standing_fare, b.sitting_fare, "
                + "s.schedule_id, s.days, s.bus_number, "
                + "s1.stop_name AS source_name, s1.stop_sequence AS source_seq, s1.arrival AS source_arrival, "
                + "s2.stop_name AS dest_name, s2.stop_sequence AS dest_seq, s2.arrival AS dest_arrival "
                + "FROM buses b "
                + "JOIN schedules s ON b.number = s.bus_number "
                + "JOIN stops s1 ON s.schedule_id = s1.schedule_id "
                + "JOIN stops s2 ON s1.schedule_id = s2.schedule_id "
                + "WHERE s1.stop_name = ? "
                + "AND s2.stop_name = ? "
                + "AND s1.stop_sequence < s2.stop_sequence "
                + "AND s.days LIKE ?";
        try (PreparedStatement pstmt = x.conn.prepareStatement(query)) {
            pstmt.setString(1, source);
            pstmt.setString(2, dest);
            pstmt.setString(3, "%" + "" + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String busName = rs.getString("name");
                    String busNumber = rs.getString("number");
                    String agent = rs.getString("agent");
                    String standingFare = rs.getString("standing_fare");
                    String sittingFare = rs.getString("sitting_fare");
                    ScheduleDetails schedule = new ScheduleDetails(rs.getString("schedule_id"), rs.getString("days"), rs.getString("bus_number"));
                    StopDetails[] stops = new StopDetails[2];
                    stops[0] = new StopDetails(rs.getString("schedule_id"), rs.getString("source_name"), rs.getInt("source_seq"), rs.getString("source_arrival"));
                    stops[1] = new StopDetails(rs.getString("schedule_id"), rs.getString("dest_name"), rs.getInt("dest_seq"), rs.getString("dest_arrival"));
                    BusDetails bus = new BusDetails(busName, busNumber, standingFare, sittingFare, schedule, stops, stops[1].stopSeq - stops[0].stopSeq, agent);
                    busList.add(bus);
                }
            }
        }
        x.conn.close();
        return busList.toArray(new BusDetails[0]);
    }

}
