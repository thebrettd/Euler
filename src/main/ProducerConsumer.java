/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumer {

    public static void main(String[] args){
        IntBuffer b = new IntBuffer();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();
    }

}
