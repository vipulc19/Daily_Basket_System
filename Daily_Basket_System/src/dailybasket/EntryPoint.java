package dailybasket;

public class EntryPoint {

    public static void main(String[] args) {

        BasketSystem basketSystem = new BasketSystem();

        basketSystem.createItem("Milk", "Amul", 25);
        basketSystem.createItem("Chocolate", "Cadbury", 50);
        basketSystem.createItem("Chocolate", "Parle", 10);
        basketSystem.createItem("Butter", "Amul", 10);

        basketSystem.addInventory("Milk", "Amul", 10);
        basketSystem.addInventory("Butter", "Amul", 20);
        basketSystem.addInventory("Chocolate", "Cadbury", 20);
        basketSystem.addInventory("Chocolate", "Parle", 15);

        basketSystem.addUser("Amit", 500);
        basketSystem.addUser("Goku", 1000);



        basketSystem.addToCart("Amit", "Milk", "Amul", 5);
        basketSystem.addToCart("Amit", "Chocolate", "Cadbury", 10);
        basketSystem.getCart("Amit");
        //basketSystem.cartCheckout("Amit");



    }
}
