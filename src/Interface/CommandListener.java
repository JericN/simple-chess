package Interface;

import Chess.Chess;
import Piece.Piece;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener extends Interaction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        int x = Character.getNumericValue(event.charAt(0));
        int y = Character.getNumericValue(event.charAt(2));
        newAction(new Point(x,y));
    }
}
