package dailybasket.entities;

public class User {

    String userName;
    int walletAmount;

    Cart userCart;

    public User(String userName, int walletAmount) {
        this.userName = userName;
        this.walletAmount = walletAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }
}
