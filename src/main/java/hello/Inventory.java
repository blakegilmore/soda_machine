package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    Map<Integer,Soda> inventory = new HashMap<Integer,Soda>();
    PaymentService payments = new PaymentService();

    Inventory() {
        this.inventory.put(0, new Soda("Coke"));
        this.inventory.put(1, new Soda("Pepsi"));
        this.inventory.put(2, new Soda("Coke"));
        this.inventory.put(3, new Soda("Coke"));
        this.inventory.put(4, new Soda("Pepsi"));
    }

    public List<String> getInventoryByBrand() {
        List<String> inventoryByBrand = new ArrayList<String>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i)!=null) {
                inventoryByBrand.add(inventory.get(i).brand);
            } else {
                inventoryByBrand.add("[]");
            }
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

    boolean checkInventoryForSelection(boolean selected, String brand) throws InterruptedException {
        for(int i = 0;i < inventory.size();i++) {
            if (inventory.get(i).brand == brand) {
                payments.makePayment(brand);
                selected = true;
                return selected;
            }
        }
        return selected;
    }


    public void removeSodasById(ArrayList<Integer> input) throws InterruptedException {
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

    public void addSoda(String brand,int i) {
        inventory.put(i, new Soda(brand));
    }

    /// method that refills the stock by adding the number of sodas needed for the rack to be filled
    public void addMultipleSodas(int toAdd, String brand) {
        for (int i = 0; i < toAdd; i++) {
            addSoda(brand,inventory.size());
        }
        getInventoryByBrand();
    }

    public void restockSodas(){
        for(int i = 0;i<5;i++){
            if(inventory.get(i) == null){
                addSoda("Coke",i);
            }
        }
    }

    public void removeSoda(int pos) throws InterruptedException {
        if (pos < inventory.size()) {
            System.out.println("Removing " + inventory.get(pos).brand+"...");
            Thread.sleep(1000);
            inventory.remove(pos);
        } else {
            System.out.println("That item doesn't exist.");
        }
        return;
    }

    public void removeSodaByBrand(String brand) throws InterruptedException {
        for(int i = 0;i < inventory.size();i++){
            if(inventory.get(i).brand == brand){
                removeSoda(i);
                break;
            }
        }
    }

    public void removeAll() throws InterruptedException {
        int sizeOfInventory = inventory.size();
        for (int i = sizeOfInventory - 1; i > -1; i--) {
            removeSoda(i);
        }
    }

    void manipulateInventory() throws InterruptedException {
        Selection selection = new Selection();
        String input = selection.captureUserInput("view, add, or remove?");
        if (input.equals("view")) {
            getInventoryByBrand();
        }
        else if (input.equals("add")) {
            input = selection.captureUserInput("restock all or one?");
            if (input.equals("all")) {
                String brand = selection.captureUserInput("brand?");
                int toAdd = 20 - getInventorySizeByInt();
                addMultipleSodas(toAdd, brand);
            } else if (input.equals("one")) {
                String brand = selection.captureUserInput("brand?");
                addSoda(brand,inventory.size());
            } else {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
            }
        }
        else if (input.equals("remove")) {
            input = selection.captureUserInput("remove all, multiple, or one?");
            if (input.equals("all")) {
                removeAll();
                System.out.println("No more sodas :( ");
                getInventoryByBrand();
                restockSodas();
            }
            else if (input.equals("multiple")) {
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
                restockSodas();
            }
            else if (input.equals("one")) {
                input = selection.captureUserInput("position?");
                removeSoda(Integer.parseInt(input));
                restockSodas();
            } else {
                System.out.println("Unavailable, please make a different selection.");
                System.out.println("\n");
                manipulateInventory();
            }
        }
        else {
            System.out.println("Unavailable, please make a different selection.");
            System.out.println("\n");
            manipulateInventory();
        }


    }

}