package dailybasket;

import dailybasket.entities.Cart;
import dailybasket.entities.Inventory;
import dailybasket.entities.Item;
import dailybasket.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketSystem {



    HashMap<String, Integer> itemToPrice;

    HashMap<String, Integer> itemsToQuantity;

    HashMap<User, HashMap<String, Integer>> userToCartItems;

    HashMap<String, User> userNameToUser;


    public BasketSystem() {
        itemToPrice = new HashMap<>();
        userToCartItems = new HashMap<>();
        itemsToQuantity = new HashMap<>();
        userNameToUser = new HashMap<>();
    }

    void createItem(String itemCategory, String brand, int price) {

        itemToPrice.put(itemCategory + "#" + brand, price);
        System.out.println("Item Added Successfully");
    }

    void addInventory(String itemCategory, String brand, int quantity) {
        itemsToQuantity.put(itemCategory + "#" + brand, quantity);
    }

    void addUser(String userName, int walletAmount) {

        User u = new User(userName, walletAmount);
        userNameToUser.put(userName, new User(userName, walletAmount));
        userToCartItems.put(u, new HashMap<>());

    }

    void addToCart(String userName, String itemCategory, String brand, int requiredQuantity) {

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put(itemCategory + "#" + brand, requiredQuantity);

        userToCartItems.put(userNameToUser.get(userName), hashMap);
    }

    void updateCart(String userName, String itemCategory, String brand, int requiredQuantity) {
        userToCartItems.get(userNameToUser.get(userName)).put(itemCategory + "#" + brand, requiredQuantity);
    }

    void removeFromCart(String userName, String itemCategory, String brand) {
        userToCartItems.get(userNameToUser.get(userName)).remove(itemCategory + "#" + brand);
    }

    void getCart(String userName) {

        HashMap<String, Integer> itemToQ = userToCartItems.get(userNameToUser.get(userName));

        for (Map.Entry<String, Integer> entry : itemToQ.entrySet()) {
            System.out.print("Item Category & Brand: " + entry.getKey());
            System.out.println(", Quantity: " + entry.getValue());
        }

    }

    void cartCheckout(String userName) {

        HashMap<String, Integer> itemToQ = userToCartItems.get(userNameToUser.get(userName));

        for (Map.Entry<String, Integer> entry : itemToQ.entrySet()) {

            int actualQuantity = itemsToQuantity.get(entry.getKey());
            int requiredQuantity = entry.getValue();
            int diff = actualQuantity - requiredQuantity;
            System.out.println("Remaining Quantity: "+ diff);
            itemsToQuantity.put(entry.getKey(), diff);
        }
    }


}
