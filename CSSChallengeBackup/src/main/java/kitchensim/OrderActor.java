package kitchensim;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * Purpose of this class is to return an order when asked. The rate at which
 * orders 'arrive' can be realized in the Kitchen class. Doesn't affect the behavior
 * of the system to have the Kitchen class request orders at a set/configured rate
 * rather than the OrderStream class push messages at the Kitchen.
 *
 * We are assuming that the order data is clean. That is
 */
public class OrderActor extends AbstractBehavior<OrderActor.Command> {

    public interface Command{}

    public static final class GetOrder implements Command {
        final ActorRef<RespondOrder> replyTo;

        public GetOrder(ActorRef<RespondOrder> replyTo) {
            this.replyTo = replyTo;
        }
    }

    public static final class RespondOrder {
        final Order order;

        public RespondOrder(Order order) {
            this.order = order;
        }
    }

    public static Behavior<Command> create(OrderSource source) {
        return Behaviors.setup(context -> new OrderActor(context, source));
    }

    private Order[] orders;
    private int currentOrder;

    private OrderActor(ActorContext<Command> context, OrderSource source) {
        super(context);
        try {
            orders = source.getOrders();
        } catch (Exception e) {
            getContext().getLog().error("Order source failed" + e.getMessage());
            // TODO: figure out how to send a message to the parent to kill the system
        }
        getContext().getLog().info("OrderActor started");
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onMessage(GetOrder.class, this::onGetOrder)
                .onSignal(PostStop.class, signal -> onPostStop())
                .build();
    }

    private Behavior<Command> onGetOrder(GetOrder go) {
        go.replyTo.tell(new RespondOrder(orders[currentOrder++]));
        return this;
    }

    private OrderActor onPostStop() {
        getContext().getLog().info("OrderActor stopped");
        return this;
    }

    public static void main(String args[]) throws Exception {

        //System.out.println("Order Object\n" + orders[0].toString());
    }
}
