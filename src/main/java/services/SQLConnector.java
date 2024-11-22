package services;

public class SQLConnector {

    public java.sql.Connection conn;

    public SQLConnector() {
        String dbUrl = "jdbc:mysql://localhost:3306/matadorpro";

        try {
            this.conn = java.sql.DriverManager.getConnection(dbUrl, "root", "groot");
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
    }
}
