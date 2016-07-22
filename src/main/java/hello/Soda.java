package hello;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blakegilmore on 7/13/16.
 */
public class Soda {
    public String getBrand() {
        return brand;
    }

    public Soda setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Soda setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getId() {
        return id;
    }

    public Soda setId(int id) {
        this.id = id;
        return this;
    }

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
