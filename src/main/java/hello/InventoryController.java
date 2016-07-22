package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    Inventory inventory;

    @RequestMapping("/inventory")
    public Inventory inventory() {
        return new Inventory();
    }

    @RequestMapping(value = "/updateSoda", method = RequestMethod.PATCH)
    public @ResponseBody Soda updateSoda(@RequestParam(value="newBrand", defaultValue="Coke") String newBrand){
        return new Soda(newBrand);
    }

    @RequestMapping(value = "/addSoda", method = RequestMethod.POST)
    public @ResponseBody Soda addSoda(@RequestParam(value="brand", defaultValue="Coke") String brand,
                                      @RequestParam(value="id", defaultValue = "0") int id,
                                      @RequestParam(value="price", defaultValue = "1.5") double price){
        return new Soda(brand,id,price);
    }


    private Soda convertBrand(String newBrand, Soda soda){
         soda.brand = newBrand;
        return soda;
    }
}

//[soda1, soda2, soda3]
//
//        {
//            date: "7-21-2016",
//            numOfCokes: 4,
//            numOfPepsis: 6,
//            inventory: [soda1, soda2, soda3]
//        }