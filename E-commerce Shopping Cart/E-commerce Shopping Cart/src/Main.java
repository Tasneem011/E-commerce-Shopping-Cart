import  java.util. Scanner;
public class Main {
    public static void main(String[] args) {
// Create an instance of the ECommerceSystem
        Ecommerce_System system = new Ecommerce_System();

        // Create and add some products
        Product product1 = new Product("Phone", "A high-end smartphone", 999.99, 10);
        Product product2 = new Product("Laptop", "A powerful laptop for gaming and work", 1499.99, 5);
        Product product3 = new Product("Headphones", "Wireless headphones with noise cancellation", 199.99, 20);

        system.addProduct(product1);
        system.addProduct(product2);
        system.addProduct(product3);

        // Start the shopping system
        system.startShopping();
    }
}