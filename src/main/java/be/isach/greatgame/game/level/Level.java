package be.isach.greatgame.game.level;

import be.isach.greatgame.game.level.tile.Tile;
import org.lwjgl.util.vector.Vector2f;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;

/**
 * Package: be.isach.greatgame.game.level
 * Created by: sachalewin
 * Date: 8/08/16
 * Project: greatgame
 */
public class Level {

    private int width;
    private int height;
    private Map<Vector2f, Tile> tiles = new HashMap<>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        generate();
    }

    public void generate() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles.put(new Vector2f(x, y), new Tile(x, y));
            }
        }
    }

    public void init() {

    }

    public void tick() {

    }


    public void render() {
        tiles.values().forEach(Tile::render);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Vector2f, Tile> getTiles() {
        return tiles;
    }
}
