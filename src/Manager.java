public class Manager extends AbstractHandler{
    //private List<Decision> suggestedDecisions;
    //private int counter;
    Dog dog = new Dog();
    Application app = new Application();

    public void DecisionGranted(){
        /*if(counter == 1){
            Decision decision = suggestedDecision[0];
            //print statement maybe
        }
         */
        //counter++
    }
    @Override
    public void HandleNotification(Notify notif) {
    }
}
