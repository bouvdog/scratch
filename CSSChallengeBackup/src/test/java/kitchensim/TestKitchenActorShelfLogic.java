package kitchensim;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestKitchenActorShelfLogic {

    @Test
    public void givenFullShelf_whenNewOrderArrives_thenPutNewOrderOnOverflow() throws Exception {
        byte[] jsonOrders = Files.readAllBytes(Paths.get("orders.json"));

        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(jsonOrders, Order[].class);

        List<Order> coldOrders = Arrays.stream(orders)
                .filter(o -> o.getTemp().equals("cold"))
                .collect(Collectors.toList());



    }
}
