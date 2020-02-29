package EscapeTheHutch;

//Time is working in nanoseconds!
public class TimeStamper
{
    private long startTime;
    private long currentStamp;
  
    
    public TimeStamper(long startTime)
    {
        this.startTime = startTime;
        currentStamp = startTime;
    }
    
    public long getStartTime()
    {
        return startTime;
    }
    
    public long updateStamp(long currentTime)
    {
        long timePassed = currentTime - currentStamp;
        currentStamp = currentTime;
        return timePassed;
    }
    
}
