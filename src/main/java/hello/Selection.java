package hello;

import java.util.Scanner;
/**
 * Created by blakegilmore on 7/14/16.
 */
public class Selection {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    boolean on = true;
    boolean selected = false;
    Inventory inventory = new Inventory();

    void selectSoda() {
        while (on == true) {
            selected = false;
            String input = captureUserInput("Please choose A (Pepsi) or B (Coke)");
            input = changeSodaNames(input);
            String brand = input;
            selected = inventory.checkInventoryForSelection(input,selected,brand);
            if (input.equals("inventory")) { inventory.manipulateInventory(); selected = true; }
            if (input.equals("off")) { on = false; }
            if (selected == false) {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
            }
        }
    }

    void dispenseDrink(String brand){
        selected = true;
        inventory.removeSodaByBrand(brand);
        System.out.println("Here is your drink");
        System.out.println("|\n|");
        System.out.println("|\n");
        System.out.println(brand);
        System.out.println("\n");
        return;
    }

    String changeSodaNames(String input){
        if (input.equals("A"))
            input = "Pepsi";
        if (input.equals("B"))
            input = "Coke";
        return input;
    }

    String captureUserInput(String prompt){
        System.out.println(prompt);
        String input = scanner.next();
        return input;
    }

}
