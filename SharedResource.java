public class SharedResource {
    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }
    public synchronized void consumeItem(){
        System.out.println("ConsumeItem method invoked by " + Thread.currentThread().getName());

        //using while loop to avoid "spurious wake-up" , sometimes because of system noise
        while(!itemAvailable){
            try{
                System.out.println("Thread " + Thread.currentThread().getName());
                wait();
            }
            catch(Exception e){

            }
        }
        System.out.println("Item consumed by " + Thread.currentThread().getName());
        itemAvailable=false;
    }
    public static void main(String[] args){
        System.out.println("Main method start");
        SharedResource sharedResource = new SharedResource();
        Thread producerThread=new Thread(new ProduceTask(sharedResource));
        Thread consumerThread=new Thread(new ConsumeTask(sharedResource));
        producerThread.start();
        consumerThread.start();

    }
}
