import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

abstract class AbstractMeetAndGreet implements MeetAndGreetIF{
    private MeetAndGreetEnvironment environment;

    public void setEnvironment(MeetAndGreetEnvironment environment) {
        this.environment = environment;
    } // setEnvironment(FoodProcessorEnvironmentIF)

    protected MeetAndGreetIF getEnvironment() {
        return environment;
    } // getEnvironment()

    public abstract void start() ;
}
