package socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerLogging {
    private final static Logger logger = Logger.getLogger(ServerLogging.class.getName());

    public static void main(String[] args) {
        try {
            // Simulating a piece of code that might throw an exception
            logger.log(Level.INFO, "Starting the process");
            riskyOperation(); // This method is where an exception might occur
        } catch (Exception e) {
            // Log the exception with SEVERE level
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        } finally {
            // Cleanup code or final logging
            logger.log(Level.INFO, "Cleanup and closing resources");
        }
    }

    private static void riskyOperation() throws Exception {
        // Simulating an exception
        throw new Exception("Simulated exception");
    }
}
