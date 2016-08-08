package be.isach.greatgame.game;

import be.isach.greatgame.game.level.Level;
import be.isach.greatgame.render.component.Component;
import org.lwjgl.opengl.GL11;

/**
 * Package: be.isach.greatgame.game
 * Created by: sachalewin
 * Date: 6/08/16
 * Project: greatgame
 */
public class Game {

    public static float xScroll, yScroll;

    private Level level;

    public Game() {
        this.level = new Level(Component.WIDTH / 16, Component.HEIGHT / 16);
    }

    public void translateView(float xa, float ya) {
        xScroll += xa;
        yScroll += ya;
    }

    public void init() {


        this.level.init();
    }

    public void tick() {
        translateView(-.1f, -.1f);

        this.level.tick();
    }

    public void render() {
        GL11.glTranslatef(xScroll, yScroll, 0);


        this.level.render();
    }

    public Level getLevel() {
        return level;
    }
}
