public class ThreadCreation1 {
    public static void main(String[] args){
        System.out.println("code inside main method " + Thread.currentThread().getName());
        MultiThreading multiThreading = new MultiThreading();
        Thread thread=new Thread(multiThreading);
        thread.start();
        System.out.println("code executed inside main by thread " + Thread.currentThread().getName());
    }

}
