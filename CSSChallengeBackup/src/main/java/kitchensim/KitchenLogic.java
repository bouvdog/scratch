package kitchensim;

import java.io.FileInputStream;
import java.util.*;

/**
 * This class (the KitchenLogic) is the central class in this system.
 * It places orders on the appropriate shelves.
 */
public class KitchenLogic {

    private static String HOT = "hot";
    private static String COLD = "cold";
    private static String FROZEN = "frozen";
    private static String OVERFLOW = "overFlow";

    List<String> shelfTypes;

    private int hotCapacity = 10;
    private int coldCapacity = 10;
    private int frozenCapacity = 10;
    private int overFlowCapacity = 15;

    Shelf hotShelf;
    Shelf coldShelf;
    Shelf frozenShelf;
    Shelf overFlowShelf;
    Map<String, Shelf> shelves = new HashMap<>();

    public static KitchenLogic create() {
        return new KitchenLogic();
    }

    private KitchenLogic() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("challenge.properties"));
            OptionalInt oi = checkProperty("hotCapacity", prop);
            oi.ifPresent(value -> hotCapacity = value);

            oi = checkProperty("coldCapacity", prop);
            oi.ifPresent(value -> coldCapacity = value);

            oi = checkProperty("frozenCapacity", prop);
            oi.ifPresent(value -> frozenCapacity = value);

            oi = checkProperty("overFlowCapacity", prop);
            oi.ifPresent(value -> overFlowCapacity = value);

            shelves.put(HOT, new ShelfDefault(hotCapacity));
            shelves.put(COLD, new ShelfDefault(coldCapacity));
            shelves.put(FROZEN, new ShelfDefault(frozenCapacity));
            shelves.put(OVERFLOW, new ShelfDefault(overFlowCapacity));

            shelfTypes = new ArrayList<>();
            shelfTypes.add(HOT);
            shelfTypes.add(COLD);
            shelfTypes.add(FROZEN);

        } catch (Exception e) {
            System.out.println("Could not find or read properties file. Using defaults.");
        }
    }

    // This method exists to check on the validity of the values in the properties file
    // TODO: upper bound on capacity?
    private OptionalInt checkProperty(String property, Properties prop) {
        int intValue = -1;
        try {
            String value = prop.getProperty(property);
            if (value != null) {
                intValue = Integer.parseInt(value);
            }
        } catch (NumberFormatException ignored) {
            // use default value for the shelf capacity
        }
        if (intValue > 0) {
            return OptionalInt.of(intValue);
        } else {
            return OptionalInt.empty();
        }
    }

    // This method and the one below it (findMoveableOrder) could be replaced by a State pattern.
    // However, I didn't think the increased bulk associated with the State pattern was justified. If
    // it was likely that the shelf logic would change, then the State pattern would make that easier and
    // would be justifed.
    public void putOrder(Order o) {
        Shelf shelf = shelves.get(o.getTemp());
        if (shelf.hasRoomForOrder()) {
            shelf.putOrder(o);
        } else {
            shelf = shelves.get(OVERFLOW);
            if (shelf.hasRoomForOrder()) {
                shelf.putOrder(o);
            } else {
                findMoveableOrder(o);
            }
        }
    }

    // If the overflow shelf is full, an existing order of your choosing on the
    // overflow should be moved to an allowable shelf with room. If no such move is possible, a random order
    // from the overflow shelf should be discarded as waste (and will not be available for a courier pickup).
    private void findMoveableOrder(Order toOverflowShelf) {
        Shelf overflow = shelves.get(OVERFLOW);
        boolean thereIsNoRoom = true;
        for (String tempType : shelfTypes) {
            Shelf shelf = shelves.get(tempType);
            if (shelf.hasRoomForOrder()) {
                Optional<Order> toBeMoved = overflow.returnOrderOfTempType(tempType);
                toBeMoved.ifPresent(fromOverflowShelf -> shelf.putOrder(fromOverflowShelf));
                overflow.putOrder(toOverflowShelf);
                thereIsNoRoom = false;
                break;
            }
        }
        if (thereIsNoRoom) {
            overflow.discardAny();
            overflow.putOrder(toOverflowShelf);
        }
    }

    // check the appropriate shelf and possibly the overflow shelf for the order
    public Optional<Order> getorder(String orderId, String tempShelf) {
        Optional<Order> opt;
        Shelf shelf = shelves.get(tempShelf);
        opt = shelf.pullOrder(orderId);
        if (orderNotOnShelf(opt)) {
            shelf = shelves.get(OVERFLOW);
            opt = shelf.pullOrder(orderId);
        }
        return opt;
    }

    private boolean orderNotOnShelf(Optional<Order> opt) {
        if (opt.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
