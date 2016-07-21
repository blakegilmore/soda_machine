package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    Map<Integer,Soda> inventory = new HashMap<Integer,Soda>();
    PaymentService payments = new PaymentService();
    int numRemoved = 0;

    Inventory() {
        this.inventory.put(0, new Soda("Coke"));
        this.inventory.put(1, new Soda("Pepsi"));
        this.inventory.put(2, new Soda("Coke"));
        this.inventory.put(3, new Soda("Coke"));
        this.inventory.put(4, new Soda("Pepsi"));
    }

    public List<String> getInventoryByBrand() {
        List<String> inventoryByBrand = new ArrayList<String>();
        if(numRemoved>5){ numRemoved = 5; }
        for (int i = 0; i < inventory.size()+numRemoved; i++) {
            if(inventory.get(i)!=null) {
                inventoryByBrand.add(inventory.get(i).brand);
            } else {
                inventoryByBrand.add("__");
            }
        }
        System.out.println("\nCurrent inventory :\n\n"+inventoryByBrand+"\n");
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

    public void removeSodasByKey(ArrayList<Integer> input) throws InterruptedException {
        numRemoved = numRemoved + (input.size());
        for(int i : input) {
            System.out.println("Removing " + inventory.get(i).brand+"...");
            inventory.remove(i);
            Thread.sleep(1000);
            numRemoved++;
        }
        Thread.sleep(1000);
        getInventoryByBrand();
        return;
    }

    public void addSoda(String brand,int i) {
        inventory.put(i, new Soda(brand));
    }

    public void addSelection(){
        Selection selection = new Selection();
        String input = selection.captureUserInput("restock all or one?");
        if (input.equals("all")) {
            String brand = selection.captureUserInput("brand?");
            int toAdd = 20 - getInventorySizeByInt();
            addMultipleSodas(toAdd, brand);
        } else if (input.equals("one")) {
            String brand = selection.captureUserInput("brand?");
            addSoda(brand,inventory.size());
            System.out.println("Added "+brand);
        } else {
            System.out.println("Unavailable, please make a different selection.\n");
        }
    }

    /// method that refills the stock by adding the number of sodas needed for the rack to be filled
    public void addMultipleSodas(int toAdd, String brand) {
        for (int i = 0; i < toAdd; i++) {
            addSoda(brand,inventory.size());
        }
        getInventoryByBrand();
    }


    public void removeSoda(int pos) throws InterruptedException {
        if (pos < inventory.size()) {
            System.out.println("Removing " + inventory.get(pos).brand+"...");
            Thread.sleep(1000);
            inventory.remove(pos);
            numRemoved++;
        } else {
            System.out.println("That item doesn't exist.");
        }
        return;
    }

    public void removeSodaByBrand(String brand) throws InterruptedException {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).brand == brand) {
                    removeSoda(i);
                }
            }
    }

    public void removeMultiple() throws InterruptedException {
        Selection selection = new Selection();
        ArrayList<Integer> sodaList = new ArrayList<Integer>();
        int numberToRemove = Integer.parseInt(selection.captureUserInput("how many sodas do you want to remove?"));
        if (numberToRemove > getInventorySizeByInt()) {
            numberToRemove = getInventorySizeByInt();
        }
        for (int x = 0; x < numberToRemove; x++) {
            int id = Integer.parseInt(selection.captureUserInput("id of soda:"));
            sodaList.add(id);
        }
        try {
            removeSodasByKey(sodaList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeSelection() throws InterruptedException {
        Selection selection = new Selection();
        String input = selection.captureUserInput("remove all, multiple, or one?");
        if (input.equals("all")) {
            try {
                removeAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (input.equals("multiple")) {
            removeMultiple();
        }
        else if (input.equals("one")) {
            input = selection.captureUserInput("position?");
            removeSoda(Integer.parseInt(input));
        } else {
            System.out.println("Unavailable, please make a different selection.\n");
            manipulateInventory();
        }
    }

    public void removeAll() throws InterruptedException {
        int sizeOfInventory = inventory.size();
        for (int i = sizeOfInventory - 1; i > -1; i--) {
            removeSoda(i);
        }
        System.out.println("No more sodas :( ");
        getInventoryByBrand();
    }

    void manipulateInventory() throws InterruptedException {
        Selection selection = new Selection();
        String input = selection.captureUserInput("view, add, or remove?");
        System.out.println(input);
        switch (input){
            case "view": getInventoryByBrand(); break;
            case "add": addSelection(); break;
            case "remove": removeSelection(); break;
            default: System.out.println("Unavailable, please make a different selection.\n"); manipulateInventory();
        }

    }

}