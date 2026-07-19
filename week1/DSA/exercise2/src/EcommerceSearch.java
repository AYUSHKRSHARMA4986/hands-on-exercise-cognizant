import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{id=" + productId + ", name='" + productName + "', category='" + category + "'}";
    }
}

public class EcommerceSearch {

    // 1. Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p; // Match found
            }
        }
        return null; // Product not found
    }

    // 2. Binary Search Implementation
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow
            int midId = sortedProducts[mid].productId;

            if (midId == targetId) {
                return sortedProducts[mid]; // Match found
            } else if (midId < targetId) {
                left = mid + 1;             // Search right half
            } else {
                right = mid - 1;            // Search left half
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Setup: Create an array of products
        Product[] catalog = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(101, "Mechanical Keyboard", "Electronics"),
                new Product(109, "Desk Mat", "Accessories"),
                new Product(102, "USB-C Hub", "Electronics")
        };

        int searchId = 109;

        // Execute Linear Search (Does not require sorting)
        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(catalog, searchId);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Execute Binary Search (Requires sorting first)
        System.out.println("\n--- Binary Search ---");
        Arrays.sort(catalog, Comparator.comparingInt(p -> p.productId));
        Product foundBinary = binarySearch(catalog, searchId);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}