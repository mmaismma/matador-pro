package services;

interface Login {

    default void loginUser(String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        java.sql.ResultSet r = x.conn.createStatement()
                .executeQuery("SELECT * FROM users where mobile = '"
                        + mobile + "' AND otp = '" + otp + "';");

        x.conn.close();

        if (!r.next()) {
            throw new Exception("Invalid credentials");
        }
    }

    default void loginAgent(String mobile, String otp) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        java.sql.ResultSet r = x.conn.createStatement()
                .executeQuery("SELECT * FROM agents where mobile = '"
                        + mobile + "' AND otp = '" + otp + "';");

        x.conn.close();

        if (!r.next()) {
            throw new Exception("Invalid credentials");
        }
    }
}
