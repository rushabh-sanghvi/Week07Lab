package services;

import dataaccess.UserDB;
import models.User;
import java.util.List;
import dataaccess.UserDB;
import java.util.ArrayList;

public class UserService {
    private final UserDB db = new UserDB();
    
    /**
     * This method calls the getUser() method in UserDB.
     * @param email - the user's email to identify them in the database.
     * @return user - the user that is requested.
     * @throws Exception - all exceptions that could be had.
     */
    public User get(String email) throws Exception {
        User user = db.getUser(email);
        
        return user;
    }

    /**
     * This method calls the getAll() method from UserDB.
     * @return userList - a list of users from the database.
     * @throws Exception - all exceptions that could be had.
     */
    public List<User> getAll() throws Exception {
        ArrayList<User> userList = (ArrayList<User>) db.getAll();
        
        return userList;
    }

    /**
     * Author David
     * @param email
     * @param password
     * @return
     * @throws Exception 
     */
    public int update(String email, String password) throws Exception {
        return 0;
    }

    /**
     * Author David
     * 
     * Method does not call delete function because business rule to logically delete
     * @param email
     * @return
     * @throws Exception 
     */
    public int delete(String email) throws Exception {
        return 0;
    }

    public int insert(String email, String password) throws Exception {
        return 0;
    }

}
