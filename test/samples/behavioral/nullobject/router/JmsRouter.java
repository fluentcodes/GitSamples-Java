package samples.behavioral.nullobject.router;

public class JmsRouter implements Router {

    @Override
    public void route(Message msg) {
        System.out.println("Routing to a JMS queue. Msg: " + msg);
    }

}
