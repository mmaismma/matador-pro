package services;

public class Login {

    static boolean login(String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        try {
            java.sql.ResultSet r = x.conn.createStatement()
                    .executeQuery("SELECT * FROM users where mobile = '"
                            + mobile + "' AND otp ='" + otp + "';");
            if (r.next()) {
                return true;
            }

            x.conn.close();
        } catch (java.sql.SQLException err) {
            throw new Exception(err);
        }

        return false;
    }
}
