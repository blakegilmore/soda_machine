package hello;

import java.util.Scanner;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class PaymentService {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    double amountNeeded = 1.50;

    void makePayment(String brand) throws InterruptedException {
        Currency currency = new Currency();
        try {
            currency.insertMoney(brand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String changeToMoney(String input) throws InterruptedException {
        if (input.equals("D"))
            input = "1.0";
        else if (input.equals("Q"))
            input = ".25";
        else { System.out.println("Please enter dollars or quarters"); input = "0.0"; Thread.sleep(1500); }
        return input;
    }

    public void payWithCash(String brand) throws InterruptedException {
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
                amountNeeded = -1;
            }
        }
    }

    public void payWithCard(String brand) throws InterruptedException {
        Selection selection = new Selection();
        System.out.println("Cost = $1.50");
        String input = selection.captureUserInput("Enter any key twice to charge your card");
        if(scanner.hasNext()){
            System.out.println("Charging your card...");
            Thread.sleep(1500);
        }
        selection.dispenseDrink(brand);
        return;
        }
}

