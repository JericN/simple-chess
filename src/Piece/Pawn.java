package Piece;

import Enum.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Point loc, Player player) {
        super(loc, player, PieceType.PAWN);
        String iconPath = (player == Player.WHITE) ? "img/pawn_white.png" : "img/pawn_black.png";
        Image img = new ImageIcon(iconPath).getImage().getScaledInstance(SIZE.x, SIZE.y, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(img));
        getPath();
    }

    protected void getPath() {
        path = new Point[1][3];
        Point temp = path[0][0] = new Point(0, (super.getColor() == Player.WHITE) ? -1 : 1);
        path[0][1] = new Point(temp.x-1,temp.y);
        path[0][2] = new Point(temp.x+1,temp.y);
    }

    public void getPossiblePath() {
        activePath = new ArrayList<>();
        Point pos = new Point(getLocation());
        pos.translate(path[0][0].x, path[0][0].y);
        if (logic.isInside(pos) && logic.isEmpty(pos)){
            activePath.add(pos);
        }
    }

    public ArrayList<Point> getPossibleCapture() {
        capture = new ArrayList<>();
        Point current = new Point(getLocation());
        Point pos = new Point(path[0][1]);
        pos.translate(current.x, current.y);
        if(logic.isInside(pos) && !logic.isEmpty(pos)){
            if(logic.getPiece(pos).getColor() != getColor()){
                capture.add(pos);
            }
        }

        pos = new Point(path[0][2]);
        pos.translate(current.x, current.y);
        if(logic.isInside(pos) && !logic.isEmpty(pos)){
            if(logic.getPiece(pos).getColor() != super.getColor()){
                capture.add(pos);
            }
        }
        return capture;
    }
}
