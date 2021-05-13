package Piece;

import Enum.*;

import javax.swing.*;
import java.awt.*;

public class Queen extends Piece {

    public Queen(Point loc, Player player) {
        super(loc, player, PieceType.QUEEN);
        String iconPath = (player == Player.WHITE) ? "img/queen_white.png" : "img/queen_black.png";
        Image img = new ImageIcon(iconPath).getImage().getScaledInstance(SIZE.x, SIZE.y, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(img));
        getPath();
    }

    protected void getPath() {
        path = new Point[8][7];
        for (int i = 1; i <= 7; i++) {
            path[0][i - 1] = new Point(0, i);
            path[1][i - 1] = new Point(i, 0);
            path[2][i - 1] = new Point(0, -i);
            path[3][i - 1] = new Point(-i, 0);
            path[4][i - 1] = new Point(i, i);
            path[5][i - 1] = new Point(i, -i);
            path[6][i - 1] = new Point(-i, -i);
            path[7][i - 1] = new Point(-i, i);
        }
    }
}
