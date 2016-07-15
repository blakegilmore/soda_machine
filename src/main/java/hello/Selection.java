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

            System.out.println("Please choose A (Pepsi) or B (Coke)");
            String input = scanner.next();
            if (input.equals("A")) {
                input = "Pepsi";
            }
            if (input.equals("B")) {
                input = "Coke";
            }
            if (input.equals("off")) {
                on = false;
            }
            if (input.equals("inventory")) {
                manipulateInventory();
            }

            for (int i = 0; i < inventory.getInventorySizeByInt(); i++) {
                if (inventory.getIndexValue(i).brand.equals(input)) {
                    System.out.println("Here is your drink");
                    System.out.println("|\n|");
                    System.out.println("|\n");
                    System.out.println(input);
                    System.out.println("\n");
                    selected = true;
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
        System.out.println("all or one?");
        String input = scanner.next();
        if (input.equals("all")) {
            inventory.getInventorySize();
            inventory.getInventoryByBrand();
        } else {
            System.out.println("add or remove?");
            input = scanner.next();
            if (input.equals("add")) {
                System.out.println("brand?");
                input = scanner.next();
                inventory.addSoda(input);
            }
            if (input.equals("remove")) {
                System.out.println("position?");
                input = scanner.next();
                inventory.removeSoda(Integer.parseInt(input));
            }
        }

        System.out.println("\n");
    }
}
