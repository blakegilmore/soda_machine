package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    List<Soda> inventory = new ArrayList<Soda>();

    Inventory(){
        this.inventory.add(new Soda("Pepsi"));
        this.inventory.add(new Soda("Coke"));
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
        for (int i=0;i<inventory.size();i++) {
            inventoryByBrand.add(inventory.get(i).brand);
        }
        System.out.println(inventoryByBrand);
        return inventoryByBrand;
    }

    public void getInventorySize() {
        System.out.println("There are "+inventory.size()+" sodas total.");
        return;
    }

    public int getInventorySizeByInt() {
        return inventory.size();
    }

    public Soda getIndexValue(int pos){
        return inventory.get(pos);
    }

    public void removeSodasById(ArrayList<Integer> input){
        for(int i : input){
            if(getIndexValue(i) != null) { removeSoda(i); }
        }
        return;
    }

    public void addSoda(String brand){
        inventory.add(new Soda(brand));
        System.out.println("Added " + inventory.get(inventory.size()-1).brand);
    }

    /// method that refills the stock by adding the number of sodas needed for the rack to be filled
    public void addMultipleSodas(int toAdd, String brand){
        for (int i = 0;i<toAdd;i++){
            addSoda(brand);
        }
        getInventoryByBrand();
    }

    public void removeSoda(int pos){
        if (pos < inventory.size()) {
            System.out.println("Removing " + inventory.get(pos).brand);
            inventory.remove(pos);
        } else {
            System.out.println("That item doesn't exist.");
        }
        return;
    }



}