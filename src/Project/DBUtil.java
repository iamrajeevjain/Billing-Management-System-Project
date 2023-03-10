package Project;
 import java.sql.*;

public class DBUtil {

    private final String HOST = "jdbc:mysql://localhost:3306/";
    private final String USERNAME = "root";
    private final String PASSWORD = "rootpassword";
    private final String DATABASE_NAME = "bms";
    private final String a = "?autoReconnect=true&useSSL=false";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() throws Exception {
        Connection connection;

        Class.forName(DRIVER);

        System.out.println("Connection to Database...");
        connection = DriverManager.getConnection(HOST + DATABASE_NAME, USERNAME, PASSWORD);
        System.out.println("Connected Successfully");
        return connection;
    }

    public void close(Connection connection, PreparedStatement pstmt) throws Exception {
        if (connection == null) {
            return;
        }
        connection.close();
        pstmt.close();

    }
}
 