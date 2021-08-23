package dailybasket;

import dailybasket.entities.*;

import java.util.HashMap;
import java.util.Map;

public class BasketSystem {

    private final HashMap<String, User> userMap;
    private final HashMap<Item, Integer> itemToPrice;
    private HashMap<Item, Integer> itemToQuantity;

    public BasketSystem() {
        userMap = new HashMap<>();
        itemToPrice = new HashMap<>();
        itemToQuantity = new HashMap<>();
    }

    void createItem(String itemCategory, String brand, int price) {

        itemToPrice.put(new Item(itemCategory, brand), price);
        System.out.println("Item Added Successfully");
    }

    void addInventory(String itemCategory, String brand, int quantity) {
        itemToQuantity.put(new Item(itemCategory, brand), quantity);
    }

    void addUser(String userName, int walletAmount) {
        userMap.put(userName, new User(userName, walletAmount));
    }

    void addToCart(String userName, String itemCategory, String brand, int requiredQuantity) {

        User user = userMap.get(userName);
        Item item = new Item(itemCategory, brand);

        int walletAmount = user.getWalletAmount();

        try {
            if (itemToPrice.get(item) * requiredQuantity <= user.getWalletAmount() && requiredQuantity < itemToQuantity.get(item)) {
                user.setWalletAmount(walletAmount - requiredQuantity * itemToPrice.get(item));
                user.getUserCart().addItemsToCart(item, requiredQuantity);
            } else {
                throw new InvalidRequestException("AddToCart:" + user + " Not Authorised! Remaining Balance:" + walletAmount + " " + item);
            }
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
        }
    }

    void updateCart(String userName, String itemCategory, String brand, int requiredQuantity) {
        User user = userMap.get(userName);
        Item item = new Item(itemCategory, brand);
        int walletAmount = user.getWalletAmount();

        int prevQuantity = user.getUserCart().getItemsinCart().get(item);
        int prevAmount = prevQuantity * itemToPrice.get(item);
        walletAmount += prevAmount;

        try {
            if (itemToPrice.get(item) * requiredQuantity < walletAmount && requiredQuantity < itemToQuantity.get(item)) {
                user.setWalletAmount(walletAmount - requiredQuantity * itemToPrice.get(item));
                user.getUserCart().getItemsinCart().put(item, requiredQuantity);
            } else
                throw new InvalidRequestException("UpdateCart: " + user + " Not Authorised! Remaining Balance:" + walletAmount + " " + item);
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
        }
    }

    void removeFromCart(String userName, String itemCategory, String brand) {
        User user = userMap.get(userName);
        Item item = new Item(itemCategory, brand);
        user.getUserCart().getItemsinCart().remove(item);
    }

    void getCart(String userName) {
        User user = userMap.get(userName);
        System.out.println(userName + "Cart: ");
        for (Map.Entry<Item, Integer> entry : user.getUserCart().getItemsinCart().entrySet())
            System.out.println(entry.getKey());
        System.out.println();
    }

    void cartCheckout(String userName) {

        User user = userMap.get(userName);
        int walletAmount = user.getWalletAmount();
        HashMap<Item, Integer> initialHashMap = new HashMap<>(itemToQuantity);

        try {
            for (Map.Entry<Item, Integer> item : user.getUserCart().getItemsinCart().entrySet()) {
                int actualQuantity = initialHashMap.get(item.getKey());
                int requiredQuantity = item.getValue();
                if (requiredQuantity > actualQuantity) {
                    throw new InvalidRequestException("cartCheckout: " + user + " Not Authorised! Required Quantity more than actual for " + item + " Rolling Back");
                }
                int diff = actualQuantity - requiredQuantity;
                System.out.println(item.getKey() + " Remaining quantity: " + diff);
                initialHashMap.put(item.getKey(), diff);
                walletAmount = walletAmount - requiredQuantity * itemToPrice.get(item.getKey());
            }
            user.setWalletAmount(walletAmount);
            this.itemToQuantity = initialHashMap;
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
        }
    }

}
