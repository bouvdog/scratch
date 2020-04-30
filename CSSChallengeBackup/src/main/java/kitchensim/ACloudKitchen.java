package kitchensim;

import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class ACloudKitchen extends AbstractBehavior<Void> {

    public static Behavior<Void> create() {
        return Behaviors.setup(ACloudKitchen::new);
    }

    private ACloudKitchen(ActorContext<Void> context) throws Exception {
        super(context);
        getContext().getLog().info("ACloudKitchen has started");
    }

    @Override
    public Receive<Void> createReceive() {
        return newReceiveBuilder().onSignal(PostStop.class, signal -> onPostStop()).build();
    }

    private ACloudKitchen onPostStop() {
        getContext().getLog().info("ACloudKitchen has stopped");
        return this;
    }

}
