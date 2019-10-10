package models;

import java.io.Serializable;

public class User implements Serializable
{
    boolean active;
    String email;
    String fname;
    String lname;
    String password;

    public User() 
    {
        active=true;
    }

    public User(boolean active, String email, String fname, String lname, String password) 
    {
        this.active = active;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public boolean isActive() 
    {
        return active;
    }

    public void setActive(boolean active) 
    {
        this.active = active;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getFname() 
    {
        return fname;
    }

    public void setFname(String fname) 
    {
        this.fname = fname;
    }

    public String getLname() 
    {
        return lname;
    }

    public void setLname(String lname) 
    {
        this.lname = lname;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
}
