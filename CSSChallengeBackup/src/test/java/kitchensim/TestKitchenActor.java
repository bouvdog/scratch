package kitchensim;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import org.junit.ClassRule;
import org.junit.Test;

public class TestKitchenActor {

    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Test
    public void testKitchenActor() {
        TestProbe<KitchenActor.StartCooking> probe = testKit.createTestProbe();
        ActorRef<KitchenActor.StartCooking> underTest = testKit.spawn(KitchenActor.create());
        underTest.tell(new KitchenActor.StartCooking());
    }
}