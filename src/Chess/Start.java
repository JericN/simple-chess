package Chess;

import Piece.*;
import Enum.*;

import java.awt.*;
import java.util.ArrayList;

public class Start {
    private ArrayList<Piece> pieces;

    public Start() {
        pieces = new ArrayList<Piece>();
    }

    public ArrayList<Piece> initializePieces() {
        initializeWhite();
        initializeBlack();
        return pieces;
    }

    public void initializeWhite() {
        Player player = Player.BLACK;
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(new Point(i, 1), player));
        }
        pieces.add(new Rook(new Point(0, 0), player));
        pieces.add(new Rook(new Point(7, 0), player));
        pieces.add(new Knight(new Point(1, 0), player));
        pieces.add(new Knight(new Point(6, 0), player));
        pieces.add(new Bishop(new Point(2, 0), player));
        pieces.add(new Bishop(new Point(5, 0), player));
        pieces.add(new Queen(new Point(3, 0), player));
        pieces.add(new King(new Point(4, 0), player));
    }

    public void initializeBlack() {
        Player player = Player.WHITE;
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(new Point(i, 6), player));
        }
        pieces.add(new Rook(new Point(0, 7), player));
        pieces.add(new Rook(new Point(7, 7), player));
        pieces.add(new Knight(new Point(1, 7), player));
        pieces.add(new Knight(new Point(6, 7), player));
        pieces.add(new Bishop(new Point(2, 7), player));
        pieces.add(new Bishop(new Point(5, 7), player));
        pieces.add(new Queen(new Point(3, 7), player));
        pieces.add(new King(new Point(4, 7), player));
    }
}
