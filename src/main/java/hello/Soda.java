package hello;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Soda {
    String brand;
    double price;
    private static final AtomicInteger count = new AtomicInteger(0);
    int id;

    Soda(String brand){
        this.brand = brand;
        this.price = 1.50;
        this.id = count.incrementAndGet();
    }
}
