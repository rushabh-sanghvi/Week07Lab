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
    
    private static final String UPDATE_STATEMENT = "UPDATE User_Table set fname=? lname=? where active = true and email=?";

    public int insert(User user) throws InventoryDBException {
        return 0;
    }

    public int update(User user) throws InventoryDBException {
        
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
     * @return ArrayList dudes
     * @throws NotesDBException 
     */
    public List<User> getAll() throws InventoryDBException, SQLException  {
        User dude;
        ArrayList<User> dudes = new ArrayList<>();
        
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ResultSet product = ps.executeQuery();
        
        while(product.next()){
            boolean boo = product.getBoolean(1);
            String userEmail = product.getString(2);
            String fname = product.getString(3);
            String lname = product.getString(4);
            dude = new User(boo, userEmail, fname, lname, null);
            dudes.add(dude);
        }

        return dudes;
    }

    public User getUser(String username) throws InventoryDBException {
        return null;
    }

    public int delete(User user) throws InventoryDBException {
        return 0;
    }
}
