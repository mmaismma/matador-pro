package services;

interface AddStop {

    default void addStop(lib.StopDetails sd, lib.AgentDetails agent) throws Exception {
        try {
            new services.Api().loginAgent(agent.mobile, agent.otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        services.SQLConnector x = new services.SQLConnector();

        x.conn
                .createStatement()
                .executeUpdate("INSERT INTO stops VALUES ("
                        + "'" + sd.scheduleId + "', "
                        + "'" + sd.stopName + "', "
                        + "'" + sd.stopSeq + "', "
                        + "'" + sd.arrival + "' "
                        + ");"
                );

        x.conn.close();
    }

}
