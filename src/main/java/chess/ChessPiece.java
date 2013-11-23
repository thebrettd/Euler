package chess;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/18/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ChessPiece implements IChessPiece {

    String owner;
    String name;

    ChessCoordinate position;

    public ChessPiece(String name, String owner, ChessCoordinate startingPosition){
        this.name = name;
        this.owner = owner;
        this.position = startingPosition;
    }

    @Override
    public void doMove(Move move){

        position = move.newPosition;

        //move.print();

    }

    @Override
    public void undoMove(Move move){

        position = move.oldPosition;

        //move.print();

    }


    }
