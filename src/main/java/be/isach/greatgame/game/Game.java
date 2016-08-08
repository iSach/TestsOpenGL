package be.isach.greatgame.game;

import be.isach.greatgame.game.level.Level;
import be.isach.greatgame.game.level.tile.Tile;
import be.isach.greatgame.render.component.Component;
import org.lwjgl.util.vector.Vector2f;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: be.isach.greatgame.game
 * Created by: sachalewin
 * Date: 6/08/16
 * Project: greatgame
 */
public class Game {

    private Level level;

    public Game() {
        this.level = new Level(Component.WIDTH / 16, Component.HEIGHT / 16);
    }

    public void init() {
        this.level.init();
    }

    public void tick() {
        this.level.tick();
    }

    public void render() {
        this.level.render();
    }

    public Level getLevel() {
        return level;
    }
}
