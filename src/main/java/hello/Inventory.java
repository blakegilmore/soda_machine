package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    String[] inventory = new String[2];

    Inventory(){
        this.inventory[0]="Pepsi";
        this.inventory[1]="Coke";
    }

    String getIndexValue(int pos){
        return inventory[pos];
    }

}