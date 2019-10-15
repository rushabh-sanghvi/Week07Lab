package models;

import java.io.Serializable;
/**
 * This class represents the User java bean
 * 
 * @author Neshat Khorsandi
 */
public class User implements Serializable
{
    boolean active;
    String email;
    String fname;
    String lname;
    String password;

    /**
     * Sets a user as active
     */
    public User() 
    {
        active=true;
    }
    /**
     * Initializes the newly created User
     * 
     * @param active
     * @param email
     * @param fname
     * @param lname
     * @param password 
     */
    public User(boolean active, String email, String fname, String lname, String password) 
    {
        this.active = active;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    /**
     * 
     * @return active returns an active user
     */
    public boolean isActive() 
    {
        return active;
    }

    /**
     * Sets a user as active
     * @param active 
     */
    public void setActive(boolean active) 
    {
        this.active = active;
    }
    /**
     * Gets the users email
     * @return email returns the users email
     */
    public String getEmail() 
    {
        return email;
    }
    /**
     * Sets the users email
     * @param email 
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }
    /**
     * Gets the users first name
     * @return fname returns the first name
     */
    public String getFname() 
    {
        return fname;
    }
    /**
     * Sets the first name
     * @param fname 
     */
    public void setFname(String fname) 
    {
        this.fname = fname;
    }
    /**
     * Gets the last name
     * @return lname returns the lastname
     */
    public String getLname() 
    {
        return lname;
    }
    /**
     * Sets the last name
     * @param lname 
     */
    public void setLname(String lname) 
    {
        this.lname = lname;
    }
    /**
     * Gets the password
     * @return password returns the users password
     */
    public String getPassword() 
    {
        return password;
    }
    /**
     * Sets the password
     * @param password 
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }
}
