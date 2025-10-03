public class ThreadCreation2
{
    public static void main(String[] args){
        System.out.println("Going inside main method " + Thread.currentThread().getName());
        MultiThreadingClass myThread = new MultiThreadingClass();
        myThread.start();
        System.out.println("Finish main method " + Thread.currentThread().getName());
    }
}
