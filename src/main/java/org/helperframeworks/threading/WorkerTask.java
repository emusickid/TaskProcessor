package org.helperframeworks.threading;

import javax.print.attribute.DateTimeSyntax;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by emusickid on 8/2/14.
 */
public class WorkerTask implements Runnable  {

    private BlockingQueue<ThreadTask> blockingQueue;
    private boolean isRunning;


    public WorkerTask(BlockingQueue<ThreadTask> blockingQueue){
        this.blockingQueue = blockingQueue;
        this.isRunning = false;
    }


    public void start()  {

        System.out.println("Thread started " + Thread.currentThread().getId() + " OK." + LocalDateTime.now());

        isRunning = true;

        while(isRunning){

            if(this.blockingQueue.size() > 0){
                ThreadTask threadTask = null;
                try {
                    threadTask = blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadTask.execute();
            }


            try {
                System.out.println("Thread " + Thread.currentThread().getId() + " is about to sleep." + LocalDateTime.now());
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop(){
        isRunning = false;
    }

    @Override
    public void run() {
        start();
    }
}
