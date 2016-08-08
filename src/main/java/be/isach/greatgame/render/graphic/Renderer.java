package be.isach.greatgame.render.graphic;

import be.isach.greatgame.util.Color3i;
import be.isach.greatgame.util.Color4i;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;

import static org.lwjgl.opengl.GL11.*;

/**
 * Package: be.isach.greatgame.render.graphic
 * Created by: sachalewin
 * Date: 6/08/16
 * Project: greatgame
 */
public class Renderer {

    public static void quadData(float x, float y, float width, float height, Color4i color) {
        glColor4f(color.getRedFloat(), color.getGreenFloat(), color.getBlueFloat(), color.getAlphaFloat());
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
    }

    public static void renderQuad(float x, float y, float width, float height, Color4i color) {
        glBegin(GL_QUADS);
        {
            quadData(x, y, width, height, color);
        }
        glEnd();
    }


    public static void quadData(float x, float y, float width, float height) {
        quadData(x, y, width, height, new Color3i(255, 255, 255));
    }
    public static void renderQuad(float x, float y, float width, float height) {
        renderQuad(x, y, width, height, new Color3i(255, 255, 255));
    }

}
