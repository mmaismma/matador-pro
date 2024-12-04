package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lib.TicketDetails;

public interface GetTickets {

    default TicketDetails[] getTicketsByUserId(String userId) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        ArrayList<TicketDetails> ticketList = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_id = ?";
        try (PreparedStatement pstmt = x.conn.prepareStatement(query)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TicketDetails ticket = new TicketDetails(
                            rs.getString("booking_id"),
                            rs.getString("user_id"),
                            rs.getString("bus_number"),
                            rs.getString("schedule_id"),
                            rs.getString("stop_from"),
                            rs.getString("stop_to"),
                            rs.getString("booking_time"),
                            rs.getString("seat_type"),
                            rs.getString("fare")
                    );
                    ticketList.add(ticket);
                }
            }
        } finally {
            x.conn.close();
        }
        return ticketList.toArray(new TicketDetails[0]);
    }
}
