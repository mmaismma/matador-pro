package services;

interface EditProfile {

    default void editProfile(lib.UserDetails userDetails, String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        try {
            new services.Api().loginUser(mobile, otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        java.sql.ResultSet exists = x.conn
                .createStatement()
                .executeQuery("SELECT * FROM users WHERE user_id = '" + userDetails.id + "';");

        if (!exists.next()) {
            throw new Exception("User " + userDetails.id + " doesn't exist");
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
                        + "WHERE user_id = '" + userDetails.id + "'"
                        + ";"
                );

        x.conn.close();
    }
}
