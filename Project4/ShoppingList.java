import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item {
    private String description;
    private double weight;
    private double price;

    
    public Item(String description, double weight, double price) {
        if (weight <= 0) {
            throw new IllegalArgumentException("\nWeight must be positive.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Weight: " + weight + "kg, Price: " + price + "€";
    }
}

public class ShoppingList {
    private List<Item> items;
    //Περιγραφή: Δημιουργεί μια κενή λίστα αγορών
    public ShoppingList() {
        items = new ArrayList<>();
    }
    //Περιγραφή: Προσθέτει ένα αντικείμενο στη λίστα αγορών
    public void addItem(Item item) {
        items.add(item);
    }
     //Περιγραφή: Εκτυπώνει τη λίστα αγορών
    public void printList() {
        System.out.println("Shopping List:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
   //Περιγραφή: Ταξινομεί τη λίστα αλφαβητικά με βάση την περιγραφή του αντικειμένου
    public void sortAlphabetically() {
        items.sort(Comparator.comparing(Item::getDescription));
        System.out.println("\nList sorted alphabetically:");
        printList();
    }
    //Περιγραφή: Ταξινομεί τη λίστα με βάση το βάρος του αντικειμένου και εκτυπώνει το ελαφρύτερο και το βαρύτερο αντικείμενο
    public void sortByWeight() {
        items.sort(Comparator.comparingDouble(Item::getWeight));
        System.out.println("\nList sorted by weight:");
        printList();
        System.out.println("Lightest item: " + items.get(0));
        System.out.println("Heaviest item: " + items.get(items.size() - 1));
    }
    //Περιγραφή: Ταξινομεί τη λίστα με βάση την τιμή του αντικειμένου και εκτυπώνει το φθηνότερο και το ακριβότερο αντικείμενο
    public void sortByPrice() {
        items.sort(Comparator.comparingDouble(Item::getPrice));
        System.out.println("\nList sorted by price:");
        printList();
        System.out.println("Cheapest item: " + items.get(0));
        System.out.println("Most expensive item: " + items.get(items.size() - 1));
    }

    public static void main(String[] args) {
        try {
            // Create shopping list
            ShoppingList shoppingList = new ShoppingList();

            // Add items to the list
            shoppingList.addItem(new Item("Apples", 1.2, 3.5));
            shoppingList.addItem(new Item("Oranges", 1.5, 2.8));
            shoppingList.addItem(new Item("Milk", 1.0, 1.2));
            shoppingList.addItem(new Item("Bread", 0.5, 1.0));
            shoppingList.addItem(new Item("Cheese", 1, 5.0));
            shoppingList.addItem(new Item("Meat", 2.0, 10.0));
            shoppingList.addItem(new Item("Rice", 1.0, 2.0));
            shoppingList.addItem(new Item("Pasta", 0.7, 1.5));
            shoppingList.addItem(new Item("Eggs", 0.6, 3.0));
            shoppingList.addItem(new Item("Sugar", 1.0, 1.8));
           // shoppingList.addItem(new Item("Salt", 0, 0.5));
            // Print initial list
            shoppingList.printList();

            // Sort alphabetically and print
            shoppingList.sortAlphabetically();

            // Sort by weight and find lightest/heaviest
            shoppingList.sortByWeight();

            // Sort by price and find cheapest/most expensive
            shoppingList.sortByPrice();

            // Test invalid item
            try {
                Item invalidItem = new Item("Invalid Item", -1.0, 2.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}