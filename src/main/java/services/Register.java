package services;

class Register {

    static boolean register(lib.UserDetails userDetails) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        try {
            java.sql.ResultSet existingMobile = x.conn
                    .createStatement()
                    .executeQuery("SELECT * FROM users WHERE mobile = '" + userDetails.mobile + "';");

            if (existingMobile.next()) {
                throw new Exception("Mobile number " + userDetails.mobile + " already in use");
            }

            java.sql.ResultSet existingEmail = x.conn
                    .createStatement()
                    .executeQuery("SELECT * FROM users WHERE email = '" + userDetails.email + "';");

            if (existingEmail.next()) {
                throw new Exception("Email " + userDetails.email + " already in use");
            }

            String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            java.util.Random random = new java.util.Random();
            StringBuilder sb = new StringBuilder(6);
            for (int i = 0; i < 6; i++) {
                sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            }

            userDetails.user_id = sb.toString();

            x.conn
                    .createStatement()
                    .executeUpdate("INSERT INTO users VALUES ("
                            + "'" + userDetails.mobile + "', "
                            + "'" + userDetails.first_name + "', "
                            + "'" + userDetails.last_name + "', "
                            + "'" + userDetails.gender + "', "
                            + "'" + userDetails.email + "', "
                            + "'" + userDetails.dob + "', "
                            + "'" + userDetails.otp + "', "
                            + "'" + userDetails.user_id + "'"
                            + ");"
                    );

            // Close the connection
            x.conn.close();
        } catch (java.sql.SQLException err) {
            System.out.print(err);
            throw new Exception("Failed to register user: " + err);
        }
        return true;
    }
}
