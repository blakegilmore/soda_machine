package hello;

import java.util.Scanner;

/**
 * Created by blakegilmore on 7/14/16.
 */
public class Selection {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    int x = 0;

    void selectSoda(){
        while (x < 5) {
            boolean selected = false;
            Inventory inventory = new Inventory();

            System.out.println("Please choose A (Pepsi) or B (Coke)");
            String input = scanner.next();
            if(input.equals("A")){
                input = "Pepsi";
                System.out.println(input);
            }
            if (input.equals("B")) {
                input = "Coke";
            }

            for (int i = 0; i<2; i++) {
                if (inventory.getIndexValue(i).equals(input)) {
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

            x += 1;
        }

    }

}
