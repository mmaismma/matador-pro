package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import lib.BusDetails;
import lib.UserDetails;

public interface BookTicket {

    default void bookTicket(UserDetails userDetails, BusDetails busDetails, String seatType) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        try {
            new services.Api().loginUser(userDetails.mobile, userDetails.otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        String query = "INSERT INTO bookings (user_id, bus_number, schedule_id, stop_from, stop_to, seat_type, fare) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = x.conn.prepareStatement(query)) {
            pstmt.setString(1, userDetails.id);
            pstmt.setString(2, busDetails.number);
            pstmt.setString(3, busDetails.schedule.scheduleId);
            pstmt.setString(4, busDetails.stops[0].stopName);
            pstmt.setString(5, busDetails.stops[1].stopName);
            pstmt.setString(6, seatType);
            pstmt.setString(7, seatType.equals("standing") ? busDetails.standingFare : busDetails.sittingFare);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ticket successfully booked!");
            } else {
                System.out.println("Failed to book ticket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("An error occurred while booking the ticket.");
        } finally {
            x.conn.close();
        }
    }
}
