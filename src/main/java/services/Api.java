package services;

public class Api implements Login, Register, EditProfile {

    public static boolean register(lib.UserDetails userDetails) throws Exception {
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

    public static boolean login(String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        try {
            java.sql.ResultSet r = x.conn.createStatement()
                    .executeQuery("SELECT * FROM users where mobile = '"
                            + mobile + "' and otp ='" + otp + "';");
            if (r.next()) {
                return true;
            }

            x.conn.close();
        } catch (java.sql.SQLException err) {
            throw new Exception(err);
        }

        return false;
    }

    public static boolean editProfile(lib.UserDetails userDetails) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        try {
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

            // Close the connection
            x.conn.close();
        } catch (java.sql.SQLException err) {
            System.out.print(err);
            throw new Exception("Failed to register user: " + err);
        }
        return true;
    }

    ;

    public static lib.UserDetails getUserDetails(String mobile) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        try {
            java.sql.ResultSet r = x.conn
                    .createStatement()
                    .executeQuery("SELECT * FROM users WHERE mobile = '" + mobile + "';");

            while (r.next()) {
                return new lib.UserDetails(
                        r.getString("mobile"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("gender"),
                        r.getString("email"),
                        r.getString("dob"),
                        r.getString("otp"),
                        r.getString("user_id")
                );
            }

            x.conn.close();
        } catch (java.sql.SQLException err) {
            System.out.print(err);
            throw new Exception("Failed to register user: " + err);
        }

        return new lib.UserDetails();
    }
}
