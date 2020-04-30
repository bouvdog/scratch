package kitchensim;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Static factory method and interface allow for different data sources to be used
 */
public class OrderSourceJSON implements OrderSource {

    public static OrderSourceJSON create() {
        return new OrderSourceJSON();
    }

    // The entire order data file is read in. This could be changed to a
    // streaming interface as an enhancement but seemed beyond the scope
    // of the current exercise.
    // TODO: put orders file name in properties file
    @Override
    public Order[] getOrders() throws Exception {
        byte[] jsonOrders = Files.readAllBytes(Paths.get("orders.json"));
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(jsonOrders, Order[].class);
        return orders;
    }
}
