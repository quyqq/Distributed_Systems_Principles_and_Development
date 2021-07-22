/**
 * @author Quyet Quang Quy ID: 12118217
 * @version 1.0 
 * this class is to check port number is valid or not
 */
package PPFileSharing;

public class InputCondition {   
    
   
    /**
     * this method is to check the port can be used or not
     * the port from 1025 can be used
     * @param port
     * @return valid port
     */
    public static int checkPortNumber(int port)
    {
        if(port>1024 && port<65535)
        {
            return port;
        }
        else if(port>=0 && port <=1024)
        {
            throw new IllegalArgumentException("Port "+port+" in the rage from 0 to 1024 well-kown ports.\nPlease enter port number from 1025 tp 65535");
        }
        else
        {
            throw new IllegalArgumentException("Port "+port+" is invalid");
        }
    }
}
