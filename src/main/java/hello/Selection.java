package hello;

import java.util.ArrayList;
import java.util.List;
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
            input = changeNames(input);
            if (input.equals("inventory")) { manipulateInventory(); }
            checkInventoryForSelection(input);
            if (input.equals("off")) { on = false; }
            if (selected == false) {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
            }
        }
    }

    void manipulateInventory(){
        selected = true;
        String input = captureUserInput("add or remove?");
        if (input.equals("add")) {
            input = captureUserInput("restock all, multiple, or one?");
            if (input.equals("all")) {
                String brand = captureUserInput("brand?");
                int toAdd = 20 - inventory.getInventorySizeByInt();
                inventory.addMultipleSodas(toAdd, brand);
            }
        } else if (input.equals("one")){
            input = captureUserInput("add or remove?");
            if (input.equals("add")) {
                input = captureUserInput("brand?");
                inventory.addSoda(input);
                inventory.getInventoryByBrand();
            }
            if (input.equals("remove")) {
                input = captureUserInput("position?");
                inventory.removeSoda(Integer.parseInt(input));
            }
        } else {
            ArrayList<Integer> sodaList = new ArrayList<Integer>();
            input = captureUserInput("id of soda you want to remove:");
            sodaList.add(Integer.parseInt(input));
            inventory.removeSodasById(sodaList);
        }

        System.out.println("\n");
    }

    void dispenseDrink(String input){
        selected = true;
        System.out.println("Here is your drink");
        System.out.println("|\n|");
        System.out.println("|\n");
        System.out.println(input);
        System.out.println("\n");
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

    void checkInventoryForSelection(String input){
        for (int i = 0; i < inventory.getInventorySizeByInt(); i++) {
            if (inventory.getIndexValue(i).brand.equals(input)) {
                dispenseDrink(input);
            }
        }
    }
}
