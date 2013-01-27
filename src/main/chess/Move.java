package chess;

import chess.ChessCoordinate;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/19/12
 * Time: 3:58 PM
 */
public class Move {

    ChessPiece piece;

    ChessCoordinate oldPosition;
    ChessCoordinate newPosition;

    public Move(ChessPiece piece, ChessCoordinate oldPosition, ChessCoordinate newPosition) {
        this.piece = piece;

        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    //If no oldPosition is specified, assume -1,-1
    public Move(ChessPiece piece, ChessCoordinate newPosition) {
        this.piece = piece;

        this.oldPosition = new ChessCoordinate(-1,-1);
        this.newPosition = newPosition;
    }

    public void print(){
        System.out.println("Moving " + piece.name +
                " from " + (oldPosition.toString().equals("N/AN/A") ? "N/A" : oldPosition.toString()) +
                " to " + newPosition.toString());
    }

    public String toString(){
        return "" + oldPosition + newPosition;
    }
}
