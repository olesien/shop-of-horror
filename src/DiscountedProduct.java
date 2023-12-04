public class DiscountedProduct extends Product {
    private final int discountBy;
    DiscountedProduct(String name, double price, int amountLeft, int discountBy) {
        super(name, price, amountLeft);
        this.discountBy = discountBy;
    }

    @Override
    public double getPrice() {
        double discount = 1 - ((double) this.discountBy / 100);
        return super.getPrice() * discount;
    }

    public int getDiscountBy() {
        return discountBy;
    }
}
