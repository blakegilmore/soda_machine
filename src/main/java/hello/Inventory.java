package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    List<Soda> inventory = new ArrayList<Soda>();

    Inventory() {
        this.inventory.add(new Soda("Coke"));
        this.inventory.add(new Soda("Pepsi"));
        this.inventory.add(new Soda("Coke"));
        this.inventory.add(new Soda("Coke"));
        this.inventory.add(new Soda("Pepsi"));
    }

    public List<Soda> getInventory() {
        return inventory;
    }

    public Inventory setInventory(List<Soda> inventory) {
        this.inventory = inventory;
        return this;
    }

    public List<String> getInventoryByBrand() {
        List<String> inventoryByBrand = new ArrayList<String>();
        for (int i = 0; i < inventory.size(); i++) {
            inventoryByBrand.add(inventory.get(i).brand);
        }
        System.out.println(inventoryByBrand);
        return inventoryByBrand;
    }

    public void getInventorySize() {
        System.out.println("There are " + inventory.size() + " sodas total.");
        return;
    }

    public int getInventorySizeByInt() {
        return inventory.size();
    }

    public Soda getValueFromIndex(int pos) {
        if (pos >= inventory.size()) {
            throw new IndexOutOfBoundsException();
        }
        return inventory.get(pos);
    }

    boolean checkInventoryForSelection(String input,boolean selected){
        Selection selection = new Selection();
        for (int i = 0; i < getInventorySizeByInt(); i++) {
            if (getValueFromIndex(i).brand.equals(input)) {
                selection.dispenseDrink(input);
                selected = true;
            }
        }
        return selected;
    }

    public void removeSodasById(ArrayList<Integer> input) {
        for (int i : input) {
            //// loop through the inventory to find the id that matches the element
            for (int j = 0; j < inventory.size(); j++) {
                if (inventory.get(j).id == i) {
                    removeSoda(j);
                }
            }
        }
        return;
    }

    public void addSoda(String brand) {
        inventory.add(new Soda(brand));
        System.out.println("Added " + inventory.get(inventory.size() - 1).brand);
    }

    /// method that refills the stock by adding the number of sodas needed for the rack to be filled
    public void addMultipleSodas(int toAdd, String brand) {
        for (int i = 0; i < toAdd; i++) {
            addSoda(brand);
        }
        getInventoryByBrand();
    }

    public void removeSoda(int pos) {
        if (pos < inventory.size()) {
            System.out.println("Removed " + inventory.get(pos).brand);
            inventory.remove(pos);
        } else {
            System.out.println("That item doesn't exist.");
        }
        return;
    }

    public void removeAll() {
        int sizeOfInventory = inventory.size();
        for (int i = sizeOfInventory - 1; i > -1; i--) {
            removeSoda(0);
        }
    }

    void manipulateInventory() {
        Selection selection = new Selection();
        String input = selection.captureUserInput("view, add, or remove?");
        if (input.equals("view")) {
            getInventoryByBrand();
        }
        if (input.equals("add")) {
            input = selection.captureUserInput("restock all or one?");
            if (input.equals("all")) {
                String brand = selection.captureUserInput("brand?");
                int toAdd = 5 - getInventorySizeByInt();
                addMultipleSodas(toAdd, brand);
            } else if (input.equals("one")) {
                String brand = selection.captureUserInput("brand?");
                addSoda(brand);
            } else {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
            }
        }
        if (input.equals("remove")) {
            input = selection.captureUserInput("remove all, multiple, or one?");
            if (input.equals("all")) {
                removeAll();
            }
            if (input.equals("multiple")) {
                ArrayList<Integer> sodaList = new ArrayList<Integer>();
                int numberToRemove = Integer.parseInt(selection.captureUserInput("how many sodas do you want to remove?"));
                if (numberToRemove > getInventorySizeByInt()) {
                    numberToRemove = getInventorySizeByInt();
                }
                for (int x = 0; x < numberToRemove; x++) {
                    int id = Integer.parseInt(selection.captureUserInput("id of soda:"));
                    sodaList.add(id);
                }
                removeSodasById(sodaList);
            }
            if (input.equals("one")) {
                input = selection.captureUserInput("position?");
                removeSoda(Integer.parseInt(input));
            }
        }


    }
}