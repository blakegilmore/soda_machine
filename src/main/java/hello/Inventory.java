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

    public List<String> getInventoryByBrand() {
        List<String> inventoryByBrand = new ArrayList<String>();
        for (int i=0;i<inventory.size();i++) {
            inventoryByBrand.add(inventory.get(i).brand);
        }
        System.out.println(inventoryByBrand);
        return inventoryByBrand;
    }

    public Inventory setInventory(List<Soda> inventory) {
        this.inventory = inventory;
        return this;
    }

    Soda getIndexValue(int pos){
        return inventory.get(pos);
    }

    void addSoda(String brand){
        inventory.add(new Soda(brand));
    }

//    void removeSoda(int pos){
//        inventory.remove(pos);
//    }

}