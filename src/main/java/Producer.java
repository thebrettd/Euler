import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer extends Thread{
    IntBuffer buffer;

    Producer(IntBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        Random r = new Random();
        while(true){
            int num = r.nextInt();
            buffer.add(num);
            System.out.println("Produced " + num );
        }

    }

}