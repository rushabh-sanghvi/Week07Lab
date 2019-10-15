package services;

import dataaccess.UserDB;
import models.User;
import java.util.List;

public class UserService {
    private final UserDB db = new UserDB();
    
    public User get(String email) throws Exception {
            return null;
    }

    public List<User> getAll() throws Exception {
        return null;
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
