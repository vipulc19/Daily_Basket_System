package dailybasket.entities;

public class User {

    private final String userName;
    private int walletAmount;
    private final Cart userCart;

    public User(String userName, int walletAmount) {
        this.userName = userName;
        this.walletAmount = walletAmount;
        this.userCart = new Cart();
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

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) 
            return true;
        
        if (o == null) 
            return false;
        
        if (this.getClass() != o.getClass()) 
            return false;
        
        User other = (User)o;
        return this.userName.equals(other.userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", walletAmount=" + walletAmount +
                '}';
    }

}
