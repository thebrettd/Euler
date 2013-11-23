package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer extends Thread{
    IntBuffer buffer;

    public Consumer(IntBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        while(true){
            int num = buffer.remove();
            System.out.println("main.java.Consumer " + num );
        }

    }



}

