package be.isach.greatgame.render.component;

import be.isach.greatgame.render.moveable.Square;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

/**
 * Package: be.isach.greatgame
 * Created by: sachalewin
 * Date: 29/07/16
 * Project: greatgame
 */
public class Component {

    private static final int SCALE = 3, WIDTH = 720 / SCALE, HEIGHT = 480 / SCALE, MAX_FPS = 144;
    private static final String TITLE = "slt gaprand lwjgl";

    private DisplayMode displayMode = new DisplayMode(WIDTH * SCALE, HEIGHT * SCALE);
    private boolean running = false;
    private int r = 0, g = 0, b = 255; // def color
    private long ticks = 0;

    private Square square;

    public Component() {
        try {
            Display.setDisplayMode(displayMode);
            Display.setResizable(true);
            Display.setFullscreen(false);
            Display.setVSyncEnabled(false);
            Display.setTitle(TITLE);
            Display.create();
            initGl();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(square == null) {
            square = new Square(50);
        }

        square.update();

        if(Mouse.isButtonDown(0)) {
            int x = Mouse.getX() / SCALE;
            int y = Mouse.getY() / SCALE;

            square.setX(x);
            square.setY(y);

            System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
            System.out.println(square);
        }

        ticks++;
    }

    private void render() {
        square.render();
    }

    private void loop() {
        while (running) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            if (Display.isCloseRequested()) {
                stop();
                break;
            }

            update();
            render();

            Display.update();
        }
        exit();
    }

    public void start() {
        this.running = true;
        loop();
    }

    public void stop() {
        running = false;
    }

    private void exit() {
        Display.destroy();
        System.exit(0);
    }

    private void initGl() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0, WIDTH, HEIGHT, 0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

}
