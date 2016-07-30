package be.isach.greatgame;

import be.isach.greatgame.render.component.Component;
import org.lwjgl.LWJGLUtil;

import java.io.File;

/**
 * Package: be.isach.greatgame
 * Created by: sachalewin
 * Date: 30/07/16
 * Project: greatgame
 */
public class Main  {

    public static void main(String... args) {
        setupNative();
        System.out.println("slt ça farte ?");
        Component component = new Component();
        component.start();
    }

    private static void setupNative()
    {
        switch (LWJGLUtil.getPlatform())
        {
            case LWJGLUtil.PLATFORM_WINDOWS:
                System.setProperty("org.lwjgl.librarypath", new File("native/windows").getAbsolutePath());
                break;

            case LWJGLUtil.PLATFORM_MACOSX:
                System.setProperty("org.lwjgl.librarypath", new File("native/macosx").getAbsolutePath());
                break;

            case LWJGLUtil.PLATFORM_LINUX:
                System.setProperty("org.lwjgl.librarypath", new File("native/linux").getAbsolutePath());
                break;

            default:
                // TODO : ERROR MESSAGE
                System.exit(1);
        }
    }

}
