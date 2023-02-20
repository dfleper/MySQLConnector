package Connector;
/*
*  @author Domingo 2023_02_20
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    String db = "proof";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Connector() {
    }

    public Connection connect() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + db, user, password);
            System.out.println("Successful Connection to the Database " + db);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Failed Connection to the Database " + db);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return cx;
    }

    public void disconnect() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public static void main(String[] args) {
        Connector conn = new Connector();
        conn.connect();
    }
}
