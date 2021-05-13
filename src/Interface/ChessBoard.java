package Interface;

import Chess.*;
import Piece.*;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChessBoard {
    private JFrame mainFrame;
    private JPanel gamePanel;
    private JPanel boardPanel;
    private JPanel sidePanelRight;
    private JPanel sidePanelLeft;
    private static JButton[][] grid;


    final int FRAME_WIDTH = 1600;
    final int FRAME_HEIGHT = 900;
    private ArrayList<Piece> pieces;

    public void startChessBoard() {
        setMainFrame();
        setGamePanel();
        setSidePanelLeft();
        setBoardPanel();
        gridPanel();
        setSidePanelRight();
        updateGridPanels();
        mainFrame.setVisible(true);
    }

    private void setMainFrame() {
        MigLayout mainFrameLayout = new MigLayout("fill");
        mainFrame = new JFrame();
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(mainFrameLayout);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void setGamePanel() {
        gamePanel = new JPanel();
        MigLayout gamePanelLayout = new MigLayout(
                new LC().wrapAfter(3).fill(),
                new AC().shrink(0),
                new AC().shrink(0)
        );
        gamePanel.setLayout(gamePanelLayout);
        gamePanel.setBackground(Color.gray);
        mainFrame.add(gamePanel, "grow");
    }

    private void setSidePanelLeft() {
        JPanel sidePanelLeft = new JPanel();
        sidePanelLeft.setBackground(Color.black);
        sidePanelLeft.setLayout(new MigLayout());
        gamePanel.add(sidePanelLeft, "grow, w 200px!, h 800px!");
    }

    private void setBoardPanel() {
        MigLayout boardLayout = new MigLayout(
                new LC().wrapAfter(8).fill()
        );
        boardPanel = new JPanel();
        boardPanel.setBackground(Color.white);
        boardPanel.setLayout(boardLayout);
        gamePanel.add(boardPanel, "grow, w 800px!, h 800px!");
    }

    private void setSidePanelRight() {
        sidePanelRight = new JPanel();
        sidePanelRight.setBackground(Color.black);
        sidePanelRight.setLayout(new MigLayout());
        gamePanel.add(sidePanelRight, "grow, w 200px!, h 800px!");
    }

    private void gridPanel() {
        MigLayout gridPanelLayout = new MigLayout();
        grid = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[j][i] = new JButton();
                grid[j][i].addActionListener(new CommandListener());
                grid[j][i].setActionCommand(j + "," + i);
                grid[j][i].setBackground(Color.cyan);
                grid[j][i].setBorder(BorderFactory.createEmptyBorder());
                grid[j][i].setHorizontalAlignment(SwingConstants.CENTER);
                grid[j][i].setLayout(gridPanelLayout);
                boardPanel.add(grid[j][i], "grow, w 90px!, h 90px!");
            }
        }
    }

    public void updateGridPanels() {
        pieces = Chess.getPieceList();
        Point pos;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j].setBackground(Color.cyan);
                grid[i][j].setIcon(null);
            }
        }
        for (Piece p : pieces) {
            pos = p.getLocation();
            grid[pos.x][pos.y].setIcon(p.getIcon());
        }
    }

    public void showMovablePath(ArrayList<Point> path, ArrayList<Point> capture) {
        if (path != null) {
            for (Point pos : path) {
                grid[(int) pos.getX()][(int) pos.getY()].setBackground(Color.blue);
            }
            for (Point pos:capture){
                grid[(int) pos.getX()][(int) pos.getY()].setBackground(Color.red);
            }
        }

    }
}
