package main.java;

import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Philosopher extends Thread {

    private int philosopherNum;
    private int fork1;
    private int fork2;
    private Object[] forks;

    public Philosopher(int philosopherNum, int fork1, int fork2, Object[] forks) {
        this.philosopherNum = philosopherNum;
        this.fork1 = fork1;
        this.fork2 = fork2;
        this.forks = forks;
    }

    public void run() {

        System.out.println("main.java.Philosopher " + philosopherNum + " ready to eat using forks " + fork1 + " and " + fork2);

        pause();

        while (true) {

            //acquire fork
            synchronized (forks[fork1]){
                Timer t = new Timer();
                System.out.println("main.java.Philosopher " + philosopherNum + " acquired fork " + fork1);


                synchronized(forks[fork2]){
                    //acquire other fork
                    System.out.println("main.java.Philosopher " + philosopherNum + " acquired fork " + fork2);
                    System.out.println("main.java.Philosopher ate, yum!");
                }
            }
            //put forks down
        }

    }

    private void pause(){
        try{
            sleep(200);
        } catch (InterruptedException e){

        }
    }

}
