package org.helperframeworks;

import org.helperframeworks.threading.TaskProcessor;

/**
 * Created by emusickid on 8/2/14.
 */
public class Main {


    public static void main(String[] args){
        System.out.println("Eric Loflin");

        TaskProcessor taskProcessor = new TaskProcessor(16, 500);

        taskProcessor.start();


        while(1==1){

        }

    }
}
