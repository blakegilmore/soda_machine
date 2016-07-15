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
            String input = captureUserInput("Please choose A (Pepsi) or B (Coke)");
            input = changeNames(input);
            if (input.equals("off"))
                on = false;
            if (input.equals("inventory"))
                manipulateInventory();

            for (int i = 0; i < inventory.getInventorySizeByInt(); i++) {
                if (inventory.getIndexValue(i).brand.equals(input)) {
                    dispenseDrink(input);
                }
            }

            if (selected == false) {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
            }

        }
    }

    void manipulateInventory(){
        selected = true;
        String input = captureUserInput("all or one?");
        if (input.equals("all")) {
            inventory.getInventorySize();
            inventory.getInventoryByBrand();
        } else {
            input = captureUserInput("add or remove?");
            if (input.equals("add")) {
                input = captureUserInput("brand?");
                inventory.addSoda(input);
            }
            if (input.equals("remove")) {
                input = captureUserInput("position?");
                inventory.removeSoda(Integer.parseInt(input));
            }
        }

        System.out.println("\n");
    }

    void dispenseDrink(String input){
        System.out.println("Here is your drink");
        System.out.println("|\n|");
        System.out.println("|\n");
        System.out.println(input);
        System.out.println("\n");
        selected = true;
        return;
    }

    String changeNames(String input){
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
