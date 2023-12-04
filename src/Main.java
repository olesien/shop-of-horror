import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //This method exists to check if product is discounted, and
    //if so it adds to the text to tell the customer that it is discounted
    public static String discount(int discountBy) {
        if (discountBy == 0) {
            return ""; //There is no discount
        } else {
            return "(DISCOUNT! " + discountBy + "% off!)";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        //Another feasible solution would be to make use of a method to make the class on the fly (with Discount being optional), and thus not use an array directly.
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new DiscountedProduct("Fake Spider", 100.10, 1, 50));
        products.add(new Product("Eye", 70.10, 33));
        products.add(new Product("Scary Doll", 1000.10, 2));

        //Re-loop the list until user has entered 4 (or whichever end value it is) and is done shopping.
        boolean StillShopping = true;
        while (StillShopping) {
            for (int i = 1; i <= products.size() + 1; i++) {

                if (i == products.size() + 1) {
                    System.out.println(i + ". Quit");
                } else {
                    Product product = products.get(i - 1);

                    System.out.printf("%d. %s %,.2f SEK, %d left %s%n", i, product.getName(), product.getPrice(), product.getAmountLeft(), discount(product.getDiscountBy()));
                }
            }
            System.out.print("Choose your option: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer <= products.size()) {
                //Check if we can buy one
                Product product = products.get(answer - 1);
                boolean hasBought = product.buyOne();
                if (!hasBought) {
                    System.out.println("Sorry but that item is out of stock!");
                } else {
                    //Adjust the basket
                    customer.addTobasket(product.getPrice());
                }
            } else if (answer == products.size() + 1) {
                //End it
                StillShopping = false;
            } else {
                //Invalid response
                System.out.println("Invalid response.");
            }
        }

        System.out.printf("You purchased a total of %d items. The total cost was %,.2f SEK", customer.getAmount(), customer.getTotalCost());

    }
}