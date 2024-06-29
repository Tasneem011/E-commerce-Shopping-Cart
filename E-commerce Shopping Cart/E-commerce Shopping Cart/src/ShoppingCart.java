import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> Items;
    public ShoppingCart() {
        Items = new ArrayList<Product>();
    }
    public void addItem(Product product) {

        Items.add(product);
        System.out.println("product added to shopping cart"+product.getName());

    }
    public void removeItem(Product product) {
        Items.remove(product);
        System.out.println("product removed from shopping cart"+product.getName());
    }
    public void viewcart (){
        if (Items.isEmpty()){
            System.out.println("No items in shopping cart");
        }
        else {
            System.out.println("Items in shopping cart");
            for (Product product : Items) {
                System.out.println(product.getName() +" " + "$ " + product.getPrice());
            }
        }
    }
    public double calculateTotal() {
        double total = 0;
        for (Product product : Items) {
            total += product.getPrice();
        }
        return total;
    }


    public CharSequence getCartItems() {
        return  null;
    }

    public void clearCart() {
        System.out.println("cleared cart from shopping cart");
    }
}
