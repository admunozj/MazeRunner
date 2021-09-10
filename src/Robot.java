import java.awt.*;
import java.lang.Math;


public class Robot {
    Point position;
    Point maxPosition;
    int orientation;

    public Robot(int x, int y, int angle, int maxX, int maxY) {
        if (maxX >= x && maxY >= y) {
            position = new Point(x, y);
        } else {
            position = new Point(0, 0);
        }
        orientation = angle % 360;
        if (orientation < 0) orientation += 360;
        maxPosition = new Point(maxX, maxY);
    }

    public void turn(int angle) {
        orientation += angle;
        orientation %= 360;
        if (orientation < 0) orientation += 360;
    }

    public int advance() {
        double dx = Math.cos(Math.toRadians(orientation));
        double dy = Math.sin(Math.toRadians(orientation));

        if (0 > dx)
            dx = -1;
        else if (0 < dx)
            dx = 1;

        if (0 > dy)
            dy = -1;
        else if (0 < dy)
            dy = 1;

        position.translate((int) dx, (int) dy);

        if (position.x >= maxPosition.x || position.y >= maxPosition.y) {
            this.retreat();
            return 1;
        } else if (position.x < 0 || position.y < 0) {
            this.retreat();
            return 1;
        }

        return 0;
    }

    public void retreat() {
        double dx = Math.cos(Math.toRadians(orientation));
        double dy = Math.sin(Math.toRadians(orientation));

        if (0 > dx)
            dx = 1;
        else if (0 < dx)
            dx = -1;

        if (0 > dy)
            dy = 1;
        else if (0 < dy)
            dy = -1;

        position.translate((int) dx, (int) dy);
    }

    public Terrain activateSensors() {
        return null;
    }
}
