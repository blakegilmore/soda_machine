package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Inventory {
    Soda[] inventory = new Soda[4];

    Inventory(){
        this.inventory[0] = new Soda("One", "Pepsi");
        this.inventory[1] = new Soda("Zero", "Coke");
        this.inventory[2] = new Soda("One", "Pepsi");
        this.inventory[3] = new Soda("Zero", "Coke");
    }

    Soda getIndexValue(int pos){
        return inventory[pos];
    }

}