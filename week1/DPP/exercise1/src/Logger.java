public class Logger {

    // 1. Private static instance.
    // 'volatile' ensures changes to the instance are immediately visible to other threads.
    private static volatile Logger instance;

    // 2. Private constructor prevents instantiation from outside this class.
    private Logger() {
        // Optional safeguard: Prevent instantiation via Reflection API
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // 3. Public static method to get the single instance.
    public static Logger getInstance() {
        // First check (without locking) to improve performance
        if (instance == null) {
            // Synchronize on the class block to ensure only one thread can create the instance
            synchronized (Logger.class) {
                // Second check (with locking) to guarantee a single instance
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A simple utility method to demonstrate the logger working
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}