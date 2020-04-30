package kitchensim;

import akka.actor.typed.ActorSystem;

public class KitchenSimMain {

    public static void main(String[] args) {
        ActorSystem.create(ACloudKitchen.create(), "ACloudKitchen");
    }
}
