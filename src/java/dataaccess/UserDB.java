package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDB {
    
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    
    /**
     * This method inserts user elements and return the number of rows affected.
     * @author Euna Cho
     * @param user user
     * @return rows rows
     */
    public int insert(User user) 
    {
        int rows=0;
        try 
        {
            String preparedQuery =
                    "INSERT INTO User_Table "
                    + "(email, fname, lname, password) "
                    + "VALUES "
                    + "(?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
    
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFname());
            ps.setString(3, user.getLname());
            ps.setString(4, user.getPassword());
            
            rows = ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    /**
     * This method update the User record.
     * @param user User to be updated
     * @return successCount Number of records updated
     */
    public int update(User user)  {
        String UPDATE_STATEMENT = "UPDATE User_Table set fname=? lname=? where email=?";
        int successCount = 0;
        try
          {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getEmail());
            
            successCount = statement.executeUpdate();
            statement.close();
            
          } catch (SQLException ex)
          {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        return successCount;
        
    }

    /**
     * This method queries the database for all users. Every user (dude) is put into an ArrayList of users (dudes).
     * @return ArrayList dudes - the list of users retrieved from the database.
     * @throws SQLException
     */
    public List<User> getAll() throws SQLException  {
        User dude;
        ArrayList<User> dudes = new ArrayList<>();
        
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ResultSet product = ps.executeQuery();
        
        while(product.next()) {
            String userEmail = product.getString(1);
            String fname = product.getString(2);
            String lname = product.getString(3);
            dude = new User(userEmail, fname, lname, null);
            dudes.add(dude);
        }

        return dudes;
    }

    /**
     * This method queries the database for a particular user (dude) that has a matching email.
     * @param email - the user's email to be searched for.
     * @return User dude - the user retrieved from the database.
     * @throws SQLException
     */
    public User getUser(String email) throws SQLException {
        User dude = new User();
        String preparedSQL = "SELECT email, fname, lname FROM user_table WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, email);
        ResultSet product = ps.executeQuery();
        
        while(product.next()) {
            String userEmail = product.getString(1);
            String fname = product.getString(2);
            String lname = product.getString(3);
            dude = new User(userEmail, fname, lname, null);
        }

        return dude;
    }

    /**
     * This method physically deletes a user from the user_table
     * @param user
     * @return false returns false if there's nothing to delete
     * @throws InventoryDBException 
     */
    public boolean delete(User user)  
    {
        try {
                String DELETE_STMT = "DELETE FROM User_Table where Email = ?";
                PreparedStatement prepare = connection.prepareStatement(DELETE_STMT);
                prepare.setString(1, user.getEmail());            
                
                int rowCount = prepare.executeUpdate();
                prepare.close();
                return rowCount == 1;
                
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
