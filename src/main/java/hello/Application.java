package hello;

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
            System.out.println(input);
            x += 1;

        }
    }
}
