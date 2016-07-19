package hello;

import java.util.Scanner;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class PaymentService {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    double amountNeeded = 1.50;

    void makePayment(String brand) {
        Currency currency = new Currency();
        currency.insertMoney(brand);
        }

    String changeToMoney(String input) {
        if (input.equals("D"))
            input = "1.0";
        else if (input.equals("Q"))
            input = ".25";
        else { System.out.println("Please enter dollars or quarters"); input = "0.0"; }
        return input;
    }

    public void payWithCash(String brand) {
        Selection selection = new Selection();
        while(amountNeeded >= 0) {
            System.out.println("Cost = $1.50");
            String input = selection.captureUserInput("(D for dollars, Q for quarters)");
            input = changeToMoney(input);
            amountNeeded = amountNeeded - Double.parseDouble(input);
            if (amountNeeded > 0) {
                System.out.println("Please add $" + amountNeeded);
            }
            if (amountNeeded <= 0) {
                selection.dispenseDrink(brand);
            }
        }
    }

    public void payWithCard(String brand) {
        Selection selection = new Selection();
        System.out.println("Cost = $1.50");
        System.out.println("type 'swipe' when ready");
        selection.dispenseDrink(brand);
        return;
        }
}

