package services;

public class GetUserDetails {

    static lib.UserDetails getUserDetails(String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();
        try {
            if (!services.Api.login(mobile, otp)) {
                throw new Exception("Invalid credentials!");
            }

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
