package be.isach.greatgame.render.moveable;

import be.isach.greatgame.render.Renderable;

/**
 * Package: be.isach.greatgame.render.moveable
 * Created by: sachalewin
 * Date: 30/07/16
 * Project: greatgame
 */
public abstract class Moveable implements Renderable {

    private int x, y;

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(x=" + x + ", y=" + y + ")";
    }
}
