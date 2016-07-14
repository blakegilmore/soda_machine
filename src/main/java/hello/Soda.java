package hello;

import java.lang.reflect.Array;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Soda {
    String type;
    String brand;
    Array currentPosition;
    double price;

    Soda(String type,String brand, Array currentPosition){
        this.type = type;
        this.brand = brand;
        this.currentPosition = currentPosition;
        this.price = 1.50;
    }
}
