import java.awt.*;
import java.lang.Math;


public class Robot {
    Point position;
    int orientation;

    public Robot(int x, int y, int angle) {
        position = new Point(x, y);
        orientation = angle % 360;
    }

    public void turn(SIDE side) {
        if (side == SIDE.LEFT)
            orientation = (orientation + 45) % 360;
        else
            if (orientation == 0)
                orientation = 315;
            else
                orientation -= 45;
    }

    public void advance() {
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
    }

}
