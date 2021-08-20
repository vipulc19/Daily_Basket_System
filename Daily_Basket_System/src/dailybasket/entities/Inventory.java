package dailybasket.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    List<Item> items;

    HashMap<String, Integer> itemToQuantity;

    public Inventory() {
        items = new ArrayList<>();
        itemToQuantity = new HashMap<>();
    }

    public void addItems(Item item){
        items.add(item);
    }

    public HashMap<String, Integer> getItemToQuantity() {
        return itemToQuantity;
    }

}
