package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    Inventory inventory = new Inventory();

    @RequestMapping("/inventory")
    public List getInventory() {
        return inventory.getInventoryByBrand();
    }

    @RequestMapping(value = "/updateSoda", method = RequestMethod.PATCH)
    public @ResponseBody Soda updateSoda(@RequestParam(value="newBrand", defaultValue="Coke") String newBrand){
        return new Soda(newBrand);
    }

    @RequestMapping(value = "/addSoda", method = RequestMethod.POST)
    public @ResponseBody Soda addSoda(@RequestParam(value="brand", defaultValue="Coke") String brand,
                                      @RequestParam(value="price", defaultValue = "1.5") double price){
        inventory.addSoda(brand);
        return inventory.getValueFromIndex(inventory.getInventorySize());
    }


    private Soda convertBrand(String newBrand, Soda soda){
         soda.brand = newBrand;
        return soda;
    }
}