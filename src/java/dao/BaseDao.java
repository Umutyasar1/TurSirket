
package dao;

import java.sql.Connection;
import util.DBConnection;

abstract class BaseDao implements Cloneable {

    private DBConnection connector;
    private Connection connection;

    public DBConnection getConnector() {
        if (this.connector == null) {
            this.connector = new DBConnection();
        }

        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }
}
