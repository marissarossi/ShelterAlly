public class Decision extends AbstractDecision{
    String decision;

    public Decision(String st){
        this.decision = st;
    }

    public String DoIt(){
        return "yes";
    }
}
