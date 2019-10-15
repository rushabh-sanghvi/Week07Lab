package services;

import models.User;
import java.util.List;
import dataaccess.UserDB;
import java.util.ArrayList;

public class UserService {
    private UserDB db = new UserDB();
    
    /**
     * Author Tom
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
     * Author Tom
     * This method calls the getAll() method from UserDB.
     * @return userList - a list of users from the database.
     * @throws Exception - all exceptions that could be had.
     */
    public List<User> getAll() throws Exception {
        ArrayList<User> userList = (ArrayList<User>) db.getAll();
        
        return userList;
    }

    /**
     * Author David and Ayden
     * @param user
     * @return
     * @throws Exception 
     */
    public int update(User user) throws Exception {
        return db.update(user);
    }

    /**
     * @Author David and Ayden
     * 
     * Method does not call delete function because business rule to logically delete
     * @param user
     * @return
     * @throws Exception 
     */
    public int delete(String email) throws Exception {
        User arranSmells = get(email);
        arranSmells.setActive(false);
        return db.update(arranSmells);
    }

     /**
     * @Author David and Ayden
     * @param user
     * @return
     * @throws Exception 
     */
    public int insert(User user) throws Exception {
        return db.insert(user);
    }

}
