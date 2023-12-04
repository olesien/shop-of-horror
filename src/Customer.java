public class Customer {
    private int amountInBasket;
    private double totalCost;

    Customer() {
        amountInBasket = 0;
        totalCost = 0;
    }

    void addTobasket(double price) {
        amountInBasket++;
        totalCost += price;
    }

    public int getAmount() {
        return this.amountInBasket;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

}
