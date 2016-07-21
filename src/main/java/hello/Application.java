package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by blakegilmore on 7/13/16.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        Selection mySelection = new Selection();
        mySelection.selectSoda();
        SpringApplication.run(Application.class, args);
    }
}


