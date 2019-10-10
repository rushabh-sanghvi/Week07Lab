package dataaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;
import java.util.List;

public class UserDB {

    public int insert(User user) throws NotesDBException {
        return 0;
    }

    public int update(User user) throws NotesDBException {
        return 0;
    }

    /**
     * This method queries the database for all users. Every user (dude) is put into an ArrayList of users (dudes).
     * @return ArrayList dudes
     * @throws NotesDBException 
     */
    public List<User> getAll() throws NotesDBException {
        User dude;
        ArrayList<User> dudes = new ArrayList<>();
        
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ResultSet product = ps.executeQuery();
        
        while(product.next()){
            User dude = new User(product.getBoolean(), product.getString(),
                                product.getString(), product.getString());
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
    public User getUser(String email) throws NotesDBException {
        String preparedSQL = "SELECT active, email, fname, lname FROM user_table WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, email);
        ResultSet product = ps.executeQuery();
        
        while(product.next()){
            User dude = new User(product.getBoolean(), product.getString(),
                                product.getString(), product.getString());
        }

        return dude;
    }

    public int delete(User user) throws NotesDBException {
        return 0;
    }
}
