package datalaag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataLayer {
    private String dbName;
    private final String login = "localhost:3306";
    private final String pass = "Maximus2045";
    private Connection con;

    public DataLayer(String dbName, boolean alternative) {
        this.dbName = dbName;
        if (alternative) {
            makeConnectionAlternative();
        } else {
            makeConnection();
        }
    }

    private void makeConnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", login, pass);

        } catch (SQLException ex) {
            Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void makeConnectionAlternative() {
        try {
            Properties connectionProps = new Properties();
            connectionProps.setProperty("user", this.login);
            connectionProps.setProperty("password", this.pass);
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", connectionProps);
        } catch (SQLException ex) {
            Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
