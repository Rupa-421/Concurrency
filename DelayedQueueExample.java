import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayedQueueExample {

    public static void main(String[] args){
        DelayQueue<DelayedTask> dQ = new DelayQueue<>();
        dQ.offer(new DelayedTask(5, TimeUnit.SECONDS));
        dQ.offer(new DelayedTask(10, TimeUnit.SECONDS));
        dQ.offer(new DelayedTask(15,TimeUnit.SECONDS));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            while(!dQ.isEmpty()){
                try{
                    DelayedTask task = dQ.take();
                    task.execute();
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });
        executorService.shutdown();
    }
}
