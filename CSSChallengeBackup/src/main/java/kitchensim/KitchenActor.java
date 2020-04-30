package kitchensim;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * This class sends messages to the OrderActor to receive orders
 * It delegates the preparation of orders to the KitchenLogic class
 * It spawns a Courier Actor to pick up the order.
 */
public class KitchenActor extends AbstractBehavior<KitchenActor.StartCooking> {

    private KitchenLogic kl;

    public static class StartCooking {
        public StartCooking() {
        }
    }

    public static Behavior<StartCooking> create() {
        return Behaviors.setup(KitchenActor::new);
    }

    private KitchenActor(ActorContext<StartCooking> context) {
        super(context);
        context.getLog().info("KitchenActor started");
    }

    @Override
    public Receive<StartCooking> createReceive() {
        return newReceiveBuilder()
                .onMessage(StartCooking.class, this::onStartCooking)
                .build();
    }

    private Behavior<StartCooking> onStartCooking(StartCooking command) {
        kl = KitchenLogic.create();
        return this;
    }


}
