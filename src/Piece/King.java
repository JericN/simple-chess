package Piece;

import Enum.*;

import javax.swing.*;
import java.awt.*;

public class King extends Piece {

    public King(Point loc, Player player) {
        super(loc, player, PieceType.KING);
        String iconPath = (player == Player.WHITE) ? "img/king_white.png" : "img/king_black.png";
        Image img = new ImageIcon(iconPath).getImage().getScaledInstance(SIZE.x, SIZE.y, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(img));
        getPath();
    }

    protected void getPath() {
        path = new Point[1][8];
        int k = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    path[0][k++] = new Point(j, i);
                }
            }
        }
    }
}
