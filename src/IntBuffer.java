/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntBuffer{
    private int index;
    private int[] buffer = new int[8];

    public IntBuffer(){

    }

    public void add( int num){
        while(true){
            if (index < buffer.length){
                buffer[index++] = num;
                return;
            }
        }
    }

    public int remove(){
        while (true){
            if (index > 0){
                return buffer[--index];
            }
        }
    }
}
