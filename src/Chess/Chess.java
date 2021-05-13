package Chess;

import Interface.*;
import Piece.*;

import java.awt.*;
import java.util.ArrayList;

public class Chess {
    static ChessBoard chessBoard = new ChessBoard();
    Start start = new Start();
    private static ArrayList<Piece> pieces;

    public Chess(){
        System.out.println("STOOPS");
    }
    public void BeginChess() {
        pieces = start.initializePieces();
        chessBoard.startChessBoard();
    }

    public static ArrayList<Piece> getPieceList() {
        return pieces;
    }


}
