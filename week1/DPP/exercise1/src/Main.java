public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Pattern ---");

        // Attempting to fetch the logger instance twice
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Using the logger references
        logger1.log("Application has started.");
        logger2.log("User successfully logged in.");
        logger1.log("Fetching data from the database...");

        System.out.println("\n--- Verification ---");

        // Use the '==' operator to check if both references point to the same memory location
        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 are the exact same instance.");
            System.out.println("Memory address 1: " + logger1.hashCode());
            System.out.println("Memory address 2: " + logger2.hashCode());
        } else {
            System.out.println("FAILURE: Multiple instances were created.");
        }
    }
}