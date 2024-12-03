package services;

interface Register {

    default boolean registerUser(lib.UserDetails userDetails) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

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

        userDetails.id = sb.toString();

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
                        + "'" + userDetails.id + "'"
                        + ");"
                );

        x.conn.close();

        return true;
    }

    default boolean registerAgent(lib.AgentDetails agentDetails) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        java.sql.ResultSet existingMobile = x.conn
                .createStatement()
                .executeQuery("SELECT * FROM agents WHERE mobile = '" + agentDetails.mobile + "';");

        if (existingMobile.next()) {
            throw new Exception("Mobile number " + agentDetails.mobile + " already in use");
        }

        java.sql.ResultSet existingEmail = x.conn
                .createStatement()
                .executeQuery("SELECT * FROM agents WHERE email = '" + agentDetails.email + "';");

        if (existingEmail.next()) {
            throw new Exception("Email " + agentDetails.email + " already in use");
        }

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        agentDetails.id = sb.toString();

        x.conn
                .createStatement()
                .executeUpdate("INSERT INTO agents VALUES ("
                        + "'" + agentDetails.first_name + "', "
                        + "'" + agentDetails.last_name + "', "
                        + "'" + agentDetails.aadhar + "', "
                        + "'" + agentDetails.mobile + "', "
                        + "'" + agentDetails.email + "', "
                        + "'" + agentDetails.otp + "', "
                        + "'" + agentDetails.id + "'"
                        + ");"
                );

        x.conn.close();

        return true;
    }
}
