package hello;

import java.util.Scanner;

/**
 * Created by blakegilmore on 7/14/16.
 */
public class Selection {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    boolean on = true;

    void selectSoda() {
        while (on == true) {
            boolean selected = false;
            Inventory inventory = new Inventory();

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
                System.out.println("add or remove?");
                input = scanner.next();
                if (input.equals("add")) {
                    //AddSoda.addSoda();
                } else if (input.equals("remove")) {
                    //AddSoda.removeSoda();
                } else {
                    continue;
                }
            }
            System.out.println("\n");

            for (int i = 0; i < 2; i++) {
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
}
