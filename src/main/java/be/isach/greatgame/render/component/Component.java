package be.isach.greatgame.render.component;

import be.isach.greatgame.game.Game;
import be.isach.greatgame.render.graphic.Renderer;
import be.isach.greatgame.util.Color3i;
import be.isach.greatgame.util.IconLoader;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;
import org.lwjgl.util.glu.GLU;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;

import static org.lwjgl.opengl.GL11.*;

/**
 * Package: be.isach.greatgame
 * Created by: sachalewin
 * Date: 29/07/16
 * Project: greatgame
 */
public class Component {

    private static final int SCALE = 3;
    private static final String TITLE = "slt gaprand lwjgl |";
    private static final double TICKS_PER_SECOND = 50;
    public static int WIDTH = 720 / SCALE, HEIGHT = 480 / SCALE;
    private static boolean tick = false;
    private static boolean render = false;

    private boolean running = false;
    private long ticks = 0, frames = 0;
    private Game game;

    public Component() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH * SCALE, HEIGHT * SCALE));
            Display.setResizable(true);
            Display.setFullscreen(false);
            Display.setVSyncEnabled(false);
            Display.setTitle(TITLE);
            Display.create();
            File file = new File("/Users/sachalewin/Desktop/icon.png");
            Display.setIcon(IconLoader.load(file));
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        this.game = new Game();
    }

    public void tick() {
        this.game.tick();
    }

    private void render() {
        view2d(WIDTH, HEIGHT);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        this.game.render();
    }

    private void loop() {
        long before = System.nanoTime(), timer = System.currentTimeMillis();
        double elapsed = 0;
        double nanoSeconds = 1000000000 / TICKS_PER_SECOND;

        while (running) {

            if (Display.isCloseRequested()) {
                stop();
                break;
            }

            if (Display.wasResized()) {
                WIDTH = Display.getWidth() / SCALE;
                HEIGHT = Display.getHeight() / SCALE;
            }

            long now = System.nanoTime();
            elapsed = now - before;

            if (elapsed >= nanoSeconds) {
                before += nanoSeconds;
                tick();
                ticks++;
            } else {
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Display.setTitle(Display.getTitle().split(Pattern.quote("|"))[0] + "| FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
            Display.update();
        }
        exit();
    }

    public void start() {
        this.running = true;
        this.game.init();
        loop();
    }

    public void stop() {
        running = false;
    }

    private void exit() {
        Display.destroy();
        System.exit(0);
    }

    private void view2d(int width, int height) {
        glViewport(0, 0, width * SCALE, height * SCALE);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0, width, height, 0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public long getTicks() {
        return ticks;
    }

    public long getFrames() {
        return frames;
    }
}
