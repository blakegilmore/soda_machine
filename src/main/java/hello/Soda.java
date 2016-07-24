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
        this.price = 2;
        this.id = count.incrementAndGet();
    }

    Soda(String brand,double price) {
        this.brand = brand;
        this.id = count.incrementAndGet();
        this.price = price;
    }

    Soda(String brand,int id,double price) {
        this.brand = brand;
        this.id = id;
        this.price = price;
    }

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

}
