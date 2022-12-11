public class AggressiveMeetAndGreet extends AbstractMeetAndGreet{
    @Override
    public void start(){
        this.MeetAndGreetIF().setConsultTime(20);
        this.MeetAndGreetIF().setMeetTime(20);
        this.MeetAndGreetIF().setPlayTime(10);
    }
}

