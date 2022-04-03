package samples.behavioral.nullobject.router;

public class SmsRouter implements Router {

    @Override
    public void route(Message msg) {
        System.out.println("Routing to a SMS gateway. Msg: " + msg);
    }

}
