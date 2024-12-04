package services;

interface AddBus {

    default void addBus(lib.BusDetails busDetails, lib.AgentDetails agent) throws Exception {

        try {
            new services.Api().loginAgent(agent.mobile, agent.otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        services.SQLConnector x = new services.SQLConnector();
        java.sql.ResultSet existingBus = x.conn
                .createStatement()
                .executeQuery("SELECT * FROM buses WHERE number = '" + busDetails.number + "';");

        if (existingBus.next()) {
            throw new Exception("Bus with number " + busDetails.number + " already in use");
        }

        x.conn
                .createStatement()
                .executeUpdate("INSERT INTO buses VALUES ("
                        + "'" + busDetails.name + "', "
                        + "'" + busDetails.number + "', "
                        + "'" + busDetails.agent + "', "
                        + "'" + busDetails.standingFare + "', "
                        + "'" + busDetails.sittingFare + "' "
                        + ");"
                );

        x.conn.close();
    }
}
