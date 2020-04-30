package kitchensim;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrderActor {

    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Test
    public void testOrderStreamActor() {
        TestProbe<OrderActor.RespondOrder> probe = testKit.createTestProbe(OrderActor.RespondOrder.class);
        ActorRef<OrderActor.Command> osActor = testKit.spawn(OrderActor.create(OrderSourceJSON.create()));
        osActor.tell(new OrderActor.GetOrder(probe.getRef()));
        OrderActor.RespondOrder response = probe.receiveMessage();
        assertEquals("Banana Split", response.order.getName());

        osActor.tell(new OrderActor.GetOrder(probe.getRef()));
        response = probe.receiveMessage();
        assertEquals("McFlury", response.order.getName());
    }
}




