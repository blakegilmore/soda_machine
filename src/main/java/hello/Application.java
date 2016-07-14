package hello;

import java.util.Scanner;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int x = 0;

        while (x < 5) {
            System.out.println("Please choose drink A or B");
            String input = scanner.next();
            boolean selected = false;

            Inventory inventory = new Inventory();

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
