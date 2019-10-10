package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {
    private Connection connection;
    
    private static final String UPDATE_STATEMENT = "UPDATE User_Table set fname=? lname=? where active = true and email=?";

    public int insert(User user) throws NotesDBException {
        
    }

    public int update(User user) throws NotesDBException {
        
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

    public List<User> getAll() throws NotesDBException {
        return null;
    }

    public User getUser(String username) throws NotesDBException {
        return null;
    }

    public int delete(User user) throws NotesDBException {
        return 0;
    }
}
