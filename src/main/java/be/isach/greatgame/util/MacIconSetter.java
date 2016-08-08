package be.isach.greatgame.util;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Package: be.isach.greatgame.util
 * Created by: sachalewin
 * Date: 8/08/16
 * Project: greatgame
 */
public class MacIconSetter {

    public static void setIcon(String filePath) {
        Image image = Toolkit.getDefaultToolkit().getImage(filePath);
        try {
            Class clazz = Class.forName("com.apple.eawt.Application");
            Method method = clazz.getMethod("getApplication");
            Object app = method.invoke(null);
            Method method1 = app.getClass().getMethod("setDockIconImage", Image.class);
            method1.invoke(app, image);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
