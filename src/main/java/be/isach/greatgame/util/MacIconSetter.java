package be.isach.greatgame.util;

import com.apple.eawt.Application;

import java.awt.*;

/**
 * Package: be.isach.greatgame.util
 * Created by: sachalewin
 * Date: 8/08/16
 * Project: greatgame
 */
public class MacIconSetter {

    public static void setIcon(String filePath) {
        Application application = Application.getApplication();
        Image image = Toolkit.getDefaultToolkit().getImage(filePath);
        application.setDockIconImage(image);
    }

}
