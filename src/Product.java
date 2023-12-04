public class Product{
    private String name;
    private double price;

    private int amountLeft;

    Product(String name, double price, int amountLeft) {
        this.name = name;
        this.price = price;
        this.amountLeft = amountLeft;
    }

    public String getName () {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getAmountLeft( ) {
        return amountLeft;
    }

    public boolean buyOne() {
        if (amountLeft > 0) {
            amountLeft--;
            return true;
        }
        return false;
    }

    public int getDiscountBy() {
        return 0;
    }
}
