package be.isach.greatgame.util;

/**
 * Package: be.isach.greatgame.util
 * Created by: sachalewin
 * Date: 8/08/16
 * Project: greatgame
 */
public class Color4i {

    private int r, g, b, alpha;

    public Color4i(int r, int g, int b, int alpha) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    public float getRedFloat() {
        return r / 255f;
    }

    public float getGreenFloat() {
        return g / 255f;
    }

    public float getBlueFloat() {
        return b / 255f;
    }

    public float getAlphaFloat() {
        return alpha / 255f;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getAlpha() {
        return alpha;
    }
}
