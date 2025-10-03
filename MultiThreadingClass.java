public class MultiThreadingClass extends Thread{
    @Override
    public void run(){
        System.out.println("code executed by thread " + Thread.currentThread().getName());
    }
}
