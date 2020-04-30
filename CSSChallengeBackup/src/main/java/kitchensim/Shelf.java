package kitchensim;

import java.util.Optional;

public interface Shelf {

    void putOrder(Order order);

    Optional<Order> pullOrder(String orderId);

    void discardBadOrder(String orderId);

    boolean hasRoomForOrder();

    Optional<Order> returnOrderOfTempType(String temp);

    void discardAny();
}
