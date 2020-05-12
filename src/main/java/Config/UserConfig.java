package Config;

import java.io.File;

public class UserConfig {

    File file = new File("/config.txt");

    public static String userName = "mikeUser" + System.currentTimeMillis();
    public static String userEmail = System.currentTimeMillis() + "email@yopmail.com";
    public static String userPassword = "TestPassword1234!";
}
