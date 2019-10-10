package dataaccess;

/**
 * 
 * @author Ayden and David
 */
public class InventoryDBException extends Exception {
    
    //@TODO ACTUALLY HANDLE THE EXCEPTIONS
    public InventoryDBException(String message) {
        super(message);
        System.out.println(message);
    }
    
    
    
    
}
