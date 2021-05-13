package Piece;

import Enum.*;

import javax.swing.*;
import java.awt.*;

public class Knight extends Piece {

    public Knight(Point loc, Player player) {
        super(loc, player, PieceType.KNIGHT);
        String iconPath = (player == Player.WHITE) ? "img/knight_white.png" : "img/knight_black.png";
        Image img = new ImageIcon(iconPath).getImage().getScaledInstance(SIZE.x, SIZE.y, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(img));
        getPath();
    }

    protected void getPath() {
        path = new Point[1][8];
        int k = 0;
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) != Math.abs(j) && i * j != 0) {
                    path[0][k++] = new Point(i, j);
                }
            }
        }
    }
}
