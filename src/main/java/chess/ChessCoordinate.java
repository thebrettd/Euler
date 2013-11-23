package chess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/20/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChessCoordinate {

    int rank;
    int file;

    public ChessCoordinate(int rank, int file){
        this.rank = rank;
        this.file = file;
    }

    public String toString(){
        return(ALGEBRAICRANKMAP.get(rank) + ALGEBRAICFILEMAP.get(file));
    }

    private static final Map<Integer,String> ALGEBRAICRANKMAP;
    static {
        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(-1,"N/A");
        m.put(0,"A");
        m.put(1,"B");
        m.put(2,"C");
        m.put(3,"D");
        m.put(4,"E");
        m.put(5,"F");
        m.put(6,"G");
        m.put(7,"H");

        ALGEBRAICRANKMAP = Collections.unmodifiableMap(m);

    }

    private static final Map<Integer,String> ALGEBRAICFILEMAP;
    static {
        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(-1,"N/A");
        m.put(0,"1");
        m.put(1,"2");
        m.put(2,"3");
        m.put(3,"4");
        m.put(4,"5");
        m.put(5,"6");
        m.put(6,"7");
        m.put(7,"8");

        ALGEBRAICFILEMAP = Collections.unmodifiableMap(m);

    }


}
