package Interface;

import Chess.*;
import Piece.*;
import Enum.*;

import java.awt.*;
import java.util.ArrayList;

public class Interaction extends ChessBoard {

    Logic logic = new Logic();
    static int turn = 0;
    static Piece selectedPiece = null;
    static ArrayList<Point> path;
    static ArrayList<Point> capture;

    public void newAction(Point pos) {
        Player player = (turn % 2 == 0) ? Player.WHITE : Player.BLACK;
        if (selectedPiece == null) {
            if (!logic.isEmpty(pos)) {
                if(logic.getPiece(pos).getColor()==player){
                    setSelectedPiece(pos);
                    showMovableTiles();
                }
            }
        } else {
            if (logic.inPath(path, pos)) {
                movePiece(pos);
                turn++;
            } else if (logic.inPath(capture, pos)) {
                capturePiece(pos);
                turn++;
            } else if (logic.isEmpty(pos)) {
                setSelectedPiece(pos);
                showMovableTiles();
            } else {
                if(logic.getPiece(pos).getColor()==player){
                    setSelectedPiece(pos);
                    showMovableTiles();
                }
            }
        }
    }

    private void setSelectedPiece(Point pos) {
        if (logic.isEmpty(pos)) {
            selectedPiece = null;
            path = null;
            capture = null;
        } else {
            selectedPiece = logic.getPiece(pos);
            selectedPiece.getPossiblePath();
            path = selectedPiece.getPossibleMovement();
            capture = selectedPiece.getPossibleCapture();
        }
    }

    private void showMovableTiles() {
        updateGridPanels();
        if (selectedPiece != null) {
            showMovablePath(path, capture);
        }
    }

    private void movePiece(Point pos) {
        selectedPiece.move(pos);
        selectedPiece = null;
        updateGridPanels();
    }

    private void capturePiece(Point pos) {
        if(logic.getPiece(pos).getType()==PieceType.KING){
            System.out.println("GAME OVER");
        }
        logic.removePiece(pos);
        selectedPiece.move(pos);
        selectedPiece = null;
        updateGridPanels();
    }
}
