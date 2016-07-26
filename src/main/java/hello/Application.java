package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
            System.out.println("There was an error with the driver");
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=password");

            // Do something with the Connection
            stmt = conn.createStatement();
            stmt.executeQuery("DROP TABLE sodas IF EXISTS");
            stmt.executeQuery("CREATE TABLE sodas(" +
                    "id SERIAL, brand VARCHAR(255), price INT)");
            
            /// add a soda to the table with a given brand name

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        Selection mySelection = new Selection();
        mySelection.selectSoda();
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

}



