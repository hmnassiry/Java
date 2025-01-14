import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class TestingExecutors implements Callable /* or Runnable */ {

    public void run() {
        try {
            synchronized ("Test"){
                System.out.println("I am in thread " + Thread.currentThread().getName());
                System.out.println("sleep for 1 seconds...");
                sleep (1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    //unlike run() above call() can return a value
    public String call() throws InterruptedException {
        synchronized ("Test") {
            sleep (1000);
            return ("I am in thread " + Thread.currentThread().getName());
        }

    }

    public static void main (String args[]) throws ExecutionException, InterruptedException {
        //Test Executors with a single thread. It will create a thread Q and threads will wait for their turn.
        //ExecutorService service = Executors.newSingleThreadExecutor();

        //Create a thread pool so they can be reused
        ExecutorService service = Executors.newFixedThreadPool(50);
        
        for (int i = 0; i < 10; i++){
            // create one thread at a time. This is expensive.
            //new Thread(new TestingExecutors()).start();
            
            //service.execute(new TestingExecutors());
            
            //use futures so we can get return value from our call method
            Future<String>  future = service.submit(new TestingExecutors());
            System.out.println("I get: " + future.get());
        }
        service.shutdown();
    }
}
