package services;

class SearchBuses {

    static java.util.ArrayList<lib.BusDetails> searchBuses(String source, String dest) throws Exception {
        services.SQLConnector x = new services.SQLConnector();

        java.util.ArrayList<lib.BusDetails> busList = new java.util.ArrayList<lib.BusDetails>();
        java.sql.ResultSet r = x.conn.createStatement()
                .executeQuery("SELECT * FROM buses WHERE stops LIKE "
                        + "'%" + source + "%" + dest + "%';");
        while (r.next()) {
            busList.add(new lib.BusDetails());
        }

        x.conn.close();

        return busList;
    }
}
