package Piece;

import Chess.*;
import Enum.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {
    final Point SIZE = new Point(50, 50);
    ArrayList<Point> activePath;
    ArrayList<Point> capture;
    Logic logic = new Logic();
    protected Point[][] path;
    private Point location;
    private PieceType type;
    private Player color;
    private Icon icon;

    public Piece(Point location, Player color, PieceType type) {
        setType(type);
        setColor(color);
        setLocation(location);
        System.out.println(type + " Added!");
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }

    public void setColor(Player color) {
        this.color = color;
    }

    public Player getColor() {
        return color;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getLocation() {
        return location.getLocation();
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }

    public void move(Point pos) {
        setLocation(pos);
    }

    public void getPossiblePath() {
        activePath = new ArrayList<>();
        capture = new ArrayList<>();
        for (Point[] points : path) {
            for (Point temp : points) {
                Point pos = new Point(getLocation());
                pos.translate(temp.x, temp.y);
                if (logic.isInside(pos)) {
                    if (logic.isEmpty(pos)) {
                        activePath.add(pos);
                    } else {
                        capture.add(pos);
                        if (getType() != PieceType.KNIGHT && getType() != PieceType.KING) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Point> getPossibleMovement() {
        return activePath;
    }

    public ArrayList<Point> getPossibleCapture() {
        capture.removeIf(pos -> logic.getPiece(pos).getColor() == getColor());
        return capture;
    }

    protected abstract void getPath();
}
