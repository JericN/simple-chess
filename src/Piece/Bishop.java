package Piece;

import Enum.*;

import javax.swing.*;
import java.awt.*;

public class Bishop extends Piece {
    public Bishop(Point loc, Player color) {
        super(loc, color, PieceType.BISHOP);
        String iconPath = (color == Player.WHITE) ? "img/bishop_white.png" : "img/bishop_black.png";
        Image img = new ImageIcon(iconPath).getImage().getScaledInstance(SIZE.x, SIZE.y, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(img));
        getPath();
    }

    protected void getPath() {
        path = new Point[4][7];
        for (int i = 1; i <= 7; i++) {
            path[0][i - 1] = new Point(i, i);
            path[1][i - 1] = new Point(i, -i);
            path[  2][i - 1] = new Point(-i, -i);
            path[3][i - 1] = new Point(-i, i);
        }
    }
}
