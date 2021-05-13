package Chess;

import Piece.*;

import java.awt.*;
import java.util.ArrayList;

public class Logic {
    ArrayList<Piece> pieces;

    public boolean isEmpty(Point pos) {
        pieces = Chess.getPieceList();
        for (Piece p : pieces) {
            if (p.getLocation().equals(pos)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInside(Point pos) {
        if (pos.getX() >= 0 && pos.getX() <= 7) {
            if (pos.getY() >= 0 && pos.getY() <= 7) {
                return true;
            }
        }
        return false;
    }

    public boolean inPath(ArrayList<Point> path, Point loc) {
        for (Point p : path) {
            if (p.equals(loc)) {
                return true;
            }
        }
        return false;
    }

    public Piece getPiece(Point pos) {
        pieces = Chess.getPieceList();
        for (Piece p : pieces) {
            if (p.getLocation().equals(pos)) {
                return p;
            }
        }
        return null;
    }

    public void removePiece(Point pos) {
        pieces = Chess.getPieceList();
        for (Piece p : pieces) {
            if (p.getLocation().equals(pos)) {
                pieces.remove(p);
                return;
            }
        }
    }

}
