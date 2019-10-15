package services;

import models.User;
import java.util.List;
import dataaccess.UserDB;
import java.util.ArrayList;

/**
 * 
 * 
 * */

public class UserService {
    private UserDB db = new UserDB();
    
    /**
     * This method calls the getUser() method in UserDB.
     * @param email - the user's email to identify them in the database.
     * @return user - the user that is requested.
     * @throws Exception - all exceptions that could be had.
     */
    public User get(String email) throws Exception {
        User user = db.getUser(email);
        
        if (user == null){
            throw new Exception("No user found.");
        }
        
        return user;
    }

    /**
     * This method calls the getAll() method from UserDB.
     * @return userList - a list of users from the database.
     * @throws Exception - all exceptions that could be had.
     */
    public List<User> getAll() throws Exception {
        ArrayList<User> userList = (ArrayList<User>) db.getAll();
        if (userList == null){
            throw new Exception("No users found.");
        }
        ArrayList<User> activeUsers = (ArrayList<User>)db.getAll();
        //coded by David
        userList.stream().filter((u) -> (u.isActive())).forEachOrdered((u) -> {
            activeUsers.add(u);
        });
        return activeUsers;
    }

    /**
     * Author David and Ayden With leadership from Ember
     * @param user
     * @return
     * @throws Exception 
     */
    public int update(User user) throws Exception {
        int i = db.update(user);
        
        if (i == 0){
            throw new Exception("No user found.");
        }
        
        return i;
    }

    /**
     * @Author David and Ayden With leadership from Ember
     * 
     * Method does not call delete function because business rule to logically delete
     * @param email the email to delete
     * @return the int from UserDb
     * @throws Exception - all exceptions that could be had.
     */
    public int delete(String email) throws Exception {
        User arranSmells = get(email);
        arranSmells.setActive(false);
        int i = db.update(arranSmells);
        
        if (i == 0){
            throw new Exception("No user found");
        }
        
        return i;
    }

     /**
     * @Author David and Ayden With leadership from Ember
     * @param user the user to update
     * @return the int from UserDb
     * @throws Exception - all exceptions that could be had.
     */
    public int insert(User user) throws Exception {
        int i = db.insert(user);
        
        if (i == 0){
            throw new Exception("User could not be added.");
        }
        
        return i;
    }

}
