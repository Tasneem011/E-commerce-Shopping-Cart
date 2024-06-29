import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ecommerce_System {
    private List<Product> products;
    private ShoppingCart cart;
    private Scanner scanner;

    public Ecommerce_System() {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProductList() {
        System.out.println("Product Listings:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Available Quantity: " + product.getQuantity());
            System.out.println("---------------------------");
        }
    }

    public void startShopping() {
        System.out.println("Welcome to the E-Commerce System!");
        System.out.println("Enter '1' to view product listings.");
        System.out.println("Enter '2' to add a product to the cart.");
        System.out.println("Enter '3' to remove a product from the cart.");
        System.out.println("Enter '4' to view the cart.");
        System.out.println("Enter '5' to checkout.");
        System.out.println("Enter '0' to exit.");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    cart.viewcart();
                    break;
                case 5:
                    checkout();
                    break;
                case 0:
                    System.out.println("Thank you for using the E-Commerce System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addToCart() {
        System.out.print("Enter the name of the product you want to add to the cart: ");
        String productName = scanner.next();

        Product product = findProductByName(productName);
        if (product != null) {
            cart.addItem(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void removeFromCart() {
        System.out.print("Enter the name of the product you want to remove from the cart: ");
        String productName = scanner.next();

        Product product = findProductByName(productName);
        if (product != null) {
            cart.removeItem(product);
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    private void checkout() {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Your cart is empty. Add some products before checking out.");
            return;
        }

        System.out.println("Total amount to be paid: $" + cart.calculateTotal());

        // Code for handling payment and order confirmation can be added here.
        // Simulate the payment process for a console-based application.

        System.out.println("Payment successful. Thank you for your purchase!");
        cart.clearCart(); // Clear the cartafter successful checkout.
    }

    private Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}