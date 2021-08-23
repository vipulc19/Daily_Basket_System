package dailybasket.entities;

import java.util.HashMap;

public class Cart {

    private final HashMap<Item, Integer> itemList;

    public Cart(){
        this.itemList = new HashMap<>();
    }

    public void addItemsToCart(Item item, int quantity){
        itemList.put(item, quantity);
    }

    public HashMap<Item, Integer> getItemsinCart() {
        return itemList;
    }
}
