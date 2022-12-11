public class ShyMeetAndGreet extends AbstractMeetAndGreet{
    @Override
    public void start(){
        this.MeetAndGreetIF().setConsultTime(10);
        this.MeetAndGreetIF().setMeetTime(30);
        this.MeetAndGreetIF().setPlayTime(10);
    }
}
