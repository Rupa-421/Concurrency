import java.sql.Time;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
    private final long delayTime;
    private final long startTime;
    public DelayedTask(long delay, TimeUnit timeUnit){
    this.delayTime = timeUnit.toMillis(delay);
    this.startTime = System.currentTimeMillis() + delayTime;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff,TimeUnit.MICROSECONDS);
    }

    public void execute() {
        System.out.println("Task executed at: " + System.currentTimeMillis());
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayedTask) o).startTime) {
            return -1;
        }
        if (this.startTime > ((DelayedTask) o).startTime) {
            return 1;
        }
        return  0 ;
    }
}
