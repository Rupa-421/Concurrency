public class MonitorLockEx1 {
    public synchronized void task1(){
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
        }
        catch (Exception e){

        }
    }

    public void task2(){
        System.out.println("task2, but before synchronized");
        synchronized (this){
            System.out.println("task2 inside synchronized");
        }
    }
    public void task3(){
        System.out.println("inside task3");
    }
    public static void main(String[] args){
        MonitorLockEx1 monitorLockEx1 = new MonitorLockEx1();
        Thread t1=new Thread(()-> {monitorLockEx1.task1();});
        Thread t2=new Thread(()->{ monitorLockEx1.task2();});
        Thread t3=new Thread(()->{ monitorLockEx1.task3();});
        t1.start();
        t2.start();
        t3.start();
    }
}
