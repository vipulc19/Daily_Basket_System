package dailybasket.entities;

public class Item {

    private final String itemCategory;
    private final String brand;

    public Item(String itemCategory, String brand) {
        this.itemCategory = itemCategory;
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        return itemCategory.hashCode() + brand.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Item other = (Item)o;
        return this.itemCategory.equals(other.itemCategory) && this.brand.equals(other.brand);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCategory='" + itemCategory + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
