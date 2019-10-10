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
    private Connection connection;
    
    private static final String UPDATE_STATEMENT = "UPDATE User_Table set fname=? lname=? password=? where active = true and email=?";

    public int insert(User user) throws NotesDBException {
        
    }

    public int update(User user) throws NotesDBException {
        
        try
          {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, c.getFirstName());
            
            
          } catch (SQLException ex)
          {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    /**
     * This method queries the database for all users. Every user (dude) is put into an ArrayList of users (dudes).
     * @return ArrayList dudes
     * @throws NotesDBException 
     */
    public List<User> getAll() throws InventoryDBException {
        User dude;
        ArrayList<User> dudes = new ArrayList<>();
        
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ResultSet product = ps.executeQuery();
        
        while(product.next()){
            boolean boo = product.getBoolean();
            String userEmail = product.getString();
            String fname = product.getString();
            String lname = product.getString();
            dude = new User(boo, userEmail, fname, lname, null);
            dudes.add(dude);
        }

        return dudes;
    }

    /**
     * This method queries the database for a particular user (dude) that has a matching email.
     * @param email
     * @return User dude
     * @throws NotesDBException 
     */
    public User getUser(String email) throws InventoryDBException {
        User dude;
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, email);
        ResultSet product = ps.executeQuery();
        
        while(product.next()){
            boolean boo = product.getBoolean();
            String userEmail = product.getString();
            String fname = product.getString();
            String lname = product.getString();
            dude = new User(boo, userEmail, fname, lname, null);
        }

        return dude;
    }

    public int delete(User user) throws InventoryDBException {
        return 0;
    }
}
