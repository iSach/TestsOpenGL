package be.isach.greatgame.render.moveable;

import static org.lwjgl.opengl.GL11.*;

/**
 * Package: be.isach.greatgame.render.component
 * Created by: sachalewin
 * Date: 30/07/16
 * Project: greatgame
 */
public class Square extends Moveable {

    private int size;

    private int r = 0, g = 0, b = 255;

    public Square(int size) {
        this.size = size;
        setX(100);
        setY(100);
    }

    public void update() {
        if (r == 255 && g < 255 && b == 0) g += 5;
        if (g == 255 && r > 0 && b == 0) r -= 5;
        if (g == 255 && b < 255 && r == 0) b += 5;
        if (b == 255 && g > 0 && r == 0) g -= 5;
        if (b == 255 && r < 255 && g == 0) r += 5;
        if (r == 255 && b > 0 && g == 0) b -= 5;
    }

    public void render() {
        glPopMatrix();
        {
            glColor3f(r / 255f, g / 255f, b / 255f);
            glBegin(GL_QUADS);
            {
                glVertex2d(getX(), getY());
                glVertex2d(getX() + size, getY());
                glVertex2d(getX() + size, getY() + size);
                glVertex2d(getX(), getY() + size);
            }
            glEnd();
        }
        glPushMatrix();
    }
}
