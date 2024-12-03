package services;

public interface EditBusDetails {

    default void editBusDetails(lib.BusDetails newBusDetails, lib.BusDetails oldBusDetails, lib.AgentDetails agent) throws Exception {
//        services.SQLConnector x = new services.SQLConnector();
//
//        try {
//            new services.Api().loginAgent(agent.mobile, agent.otp);
//        } catch (Exception err) {
//            throw new Exception("Invalid credentials!");
//        }
//
//        java.sql.ResultSet isExisting = x.conn
//                .createStatement()
//                .executeQuery("SELECT * FROM users WHERE user_id = '" + userDetails.user_id + "';");
//
//        if (!isExisting.next()) {
//            throw new Exception("User " + userDetails.user_id + " doesn't exist");
//        }
//
//        x.conn
//                .createStatement()
//                .executeUpdate("UPDATE users SET "
//                        + "mobile = '" + userDetails.mobile + "', "
//                        + "first_name = '" + userDetails.first_name + "', "
//                        + "last_name = '" + userDetails.last_name + "', "
//                        + "gender = '" + userDetails.gender + "', "
//                        + "email = '" + userDetails.email + "', "
//                        + "dob = '" + userDetails.dob + "'"
//                        + "WHERE user_id = '" + userDetails.user_id + "'"
//                        + ";"
//                );
//
//        x.conn.close();
    }
}
