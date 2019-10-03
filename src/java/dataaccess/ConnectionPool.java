package dataaccess;

import java.sql.*;

public class ConnectionPool {

    private ConnectionPool() {

    }

    public static synchronized ConnectionPool getInstance() {
        return null;
    }

    public Connection getConnection() {
        return null;
    }

    public void freeConnection(Connection c) {
        
    }
}