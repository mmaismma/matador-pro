package services;

interface AddSchedule {

    default String addSchedule(lib.ScheduleDetails sd, lib.AgentDetails agent) throws Exception {
        try {
            new services.Api().loginAgent(agent.mobile, agent.otp);
        } catch (Exception err) {
            throw new Exception("Invalid credentials!");
        }

        services.SQLConnector x = new services.SQLConnector();

        java.sql.ResultSet existingBus = x.conn
                .createStatement()
                .executeQuery("SELECT * FROM buses WHERE number = '" + sd.busNumber + "' AND agent = '" + agent.id + "';");

        if (!existingBus.next()) {
            throw new Exception("Bus with number " + sd.busNumber + " not under agent");
        }

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        sd.scheduleId = sb.toString();

        x.conn
                .createStatement()
                .executeUpdate("INSERT INTO schedules VALUES ("
                        + "'" + sd.scheduleId + "', "
                        + "'" + sd.days + "', "
                        + "'" + sd.busNumber + "' "
                        + ");"
                );

        x.conn.close();

        return sd.scheduleId;
    }

}
