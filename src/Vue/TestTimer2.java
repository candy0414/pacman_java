package Vue;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer2 {

    static int counter = 0;
    static Timer timer;
    public TimerTask timerTask;
    public TestTimer2() {
    	   //create timer task to increment counter
        timerTask = new TimerTask() {

           @Override
           public void run() {
               // System.out.println("TimerTask executing counter is: " + counter);
               counter++;
               System.out.println("Counter is : "+counter);
           }
       };
       Thread t = new Thread(new Runnable() {

           @Override
           public void run() {
               while (true) {
                   try {
                       System.out.println("Thread reading counter is: " + counter);
                       if (counter == 3) {
                           System.out.println("Counter has reached 3 now will terminate");
                           timer.cancel();//end the timer
                           break;//end this loop
                       }
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       ex.printStackTrace();
                   }
               }
               //create thread to print counter value
               

               

              
           }
           
           
       });
       timer = new Timer("MyTimer");//create a new timer
       timer.scheduleAtFixedRate(timerTask, 30, 3000);//start timer in 30ms to increment  counter
       t.start();//start thread to display counter
    }

    

     

     
    
}