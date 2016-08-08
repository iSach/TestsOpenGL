package be.isach.greatgame.game.level.tile;

import be.isach.greatgame.math.MathUtils;
import be.isach.greatgame.render.graphic.Renderer;
import be.isach.greatgame.util.Color3i;

/**
 * Package: be.isach.greatgame.game.level.tile
 * Created by: sachalewin
 * Date: 8/08/16
 * Project: greatgame
 */
public class Tile {

    public static int SIZE = 16;

    private int x;
    private int y;
    private Color3i color;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = new Color3i(MathUtils.random(256), MathUtils.random(256), MathUtils.random(256));
    }

    public void render() {
        Renderer.renderQuad(x * SIZE, y * SIZE, SIZE, SIZE, color);
        System.out.println("a");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color3i getColor() {
        return color;
    }
}
