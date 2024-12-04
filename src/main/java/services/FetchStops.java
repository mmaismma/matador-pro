package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lib.StopDetails;

interface FetchStops {

    default StopDetails[] fetchAllStops() throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        ArrayList<StopDetails> stopList = new ArrayList<>();

        String query = "SELECT DISTINCT * FROM stops";

        try (Statement stmt = x.conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                StopDetails stop = new StopDetails(
                        rs.getString("schedule_id"),
                        rs.getString("stop_name"),
                        rs.getInt("stop_sequence"),
                        rs.getString("arrival")
                );

                stopList.add(stop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error fetching stop details.");
        } finally {
            x.conn.close();
        }

        return stopList.toArray(new StopDetails[0]);
    }

}
