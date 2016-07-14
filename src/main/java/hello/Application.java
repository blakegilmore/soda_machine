package hello;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int x = 0;


        while (x < 2) {
            System.out.println("Please choose drink A or B");
            String input = scanner.next();

            String[] inventory = new String[2];
            inventory[0] = "A";
            inventory[1] = "B";

            if (Arrays.asList(inventory).contains(input)) {
                System.out.println("Here is your drink");
                System.out.println(input);
            }

            x += 1;

        }

    }
}
