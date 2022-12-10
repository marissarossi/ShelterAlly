public class Employee extends AbstractHandler {
    public Decision decision;


    public Decision SuggestDecision(){
        return decision;
    }

    @Override
    public void HandleNotification(Notify notif) {

    }
}
