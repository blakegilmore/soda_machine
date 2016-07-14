package hello;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int x = 0;

        while (x < 1) {
            System.out.println("Please choose drink A or B");
            String input = scanner.next();
            boolean selected = false;

            Inventory inventory = new Inventory();

            for (int i = 0; i<2; i++) {
                if (inventory.getIndexValue(i).equals(input)) {
                    System.out.println("Here is your drink");
                    System.out.println(input);
                    selected = true;
                }
            }
            if (selected == false) {
                System.out.println("Unavailable, please make a different selection.");
            }

            x += 1;

        }

    }
}
