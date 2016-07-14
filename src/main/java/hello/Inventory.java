package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    String[] inventory = new String[2];

    Inventory(){
        this.inventory[0]="A";
        this.inventory[1]="B";
    }

    String getIndexValue(int pos){
        return inventory[pos];
    }

}