package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lib.TicketDetails;

public interface GetTickets {

    default TicketDetails[] getTicketsByUserId(String userId) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        ArrayList<TicketDetails> ticketList = new ArrayList<>();
        String query = "SELECT * FROM tickets WHERE user_id = ?";
        try (PreparedStatement pstmt = x.conn.prepareStatement(query)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TicketDetails ticket = new TicketDetails(
                            rs.getString("ticket_id"),
                            rs.getString("user_id"),
                            rs.getString("user_name"),
                            rs.getString("bus_number"),
                            rs.getString("bus_name"),
                            rs.getString("schedule_id"),
                            rs.getString("from_stop"),
                            rs.getString("to_stop"),
                            rs.getString("departure_time"),
                            rs.getString("arrival_time"),
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
