package org.helperframeworks;

import org.helperframeworks.threading.TaskProcessor;

/**
 * Created by emusickid on 8/2/14.
 */
public class Main {


    public static void main(String[] args){
        System.out.println("Eric Loflin");

        final int threads = 16;

        TaskProcessor[] taskProcessor = new TaskProcessor[threads];

        for(int i = 0 ; i < threads; i++){

            taskProcessor[i] = new TaskProcessor(1, 500);
            taskProcessor[i].start();

        }

        String ans = "no";
        do
        {
            //System.out.printf("Are you done? [yes] [no] : ");
            //ans = System.console().readLine();
        }while(ans != "yes");

    }
}
