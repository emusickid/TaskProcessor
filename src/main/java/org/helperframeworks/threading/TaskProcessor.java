package org.helperframeworks.threading;

import javafx.concurrent.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by emusickid on 8/2/14.
 */
public class TaskProcessor {

    public TaskProcessor(int threadCount, int queueCapacity){
        this.threadCount = threadCount;
        this.queueCapacity = queueCapacity;
        this.blockingQueue = new LinkedBlockingQueue<ThreadTask>();
    }


    private Thread[] tasks;
    private WorkerTask[] workerTasks;


    private BlockingQueue<ThreadTask> blockingQueue;
    private int threadCount;
    private int queueCapacity;




    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public BlockingQueue<ThreadTask> getBlockingQueue() {
        return blockingQueue;
    }

    public void start(){

        tasks = new Thread[threadCount];
        workerTasks = new WorkerTask[threadCount];


        for(int i = 0; i< this.threadCount; i++){
            workerTasks[i] = new WorkerTask(blockingQueue);
            tasks[i] = new Thread(workerTasks[i]);
            tasks[i].start();
        }

    }

    public void enqueueWork(ThreadTask threadTask) throws InterruptedException {

        blockingQueue.put(threadTask);

    }

}
