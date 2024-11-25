package services;

class EditProfile {

    static boolean editProfile(lib.UserDetails userDetails, String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        try {
            if (!services.Api.login(mobile, otp)) {
                throw new Exception("Invalid credentials!");
            }

            java.sql.ResultSet isExisting = x.conn
                    .createStatement()
                    .executeQuery("SELECT * FROM users WHERE user_id = '" + userDetails.user_id + "';");

            if (!isExisting.next()) {
                throw new Exception("User " + userDetails.user_id + " doesn't exist");
            }

            x.conn
                    .createStatement()
                    .executeUpdate("UPDATE users SET "
                            + "mobile = '" + userDetails.mobile + "', "
                            + "first_name = '" + userDetails.first_name + "', "
                            + "last_name = '" + userDetails.last_name + "', "
                            + "gender = '" + userDetails.gender + "', "
                            + "email = '" + userDetails.email + "', "
                            + "dob = '" + userDetails.dob + "'"
                            + "WHERE user_id = '" + userDetails.user_id + "'"
                            + ";"
                    );

            x.conn.close();
        } catch (java.sql.SQLException err) {
            System.out.print(err);
            throw new Exception("Failed to register user: " + err);
        }
        return true;
    }
}
