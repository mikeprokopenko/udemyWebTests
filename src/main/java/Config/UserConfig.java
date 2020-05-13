package Config;

import java.io.File;

public class UserConfig {

    File file = new File("/config.txt");

    public static String userNameForSignUp = "mikeUser" + System.currentTimeMillis();
    public static String userEmailForSignUp = System.currentTimeMillis() + "email@yopmail.com";
    public static String userPasswordForSignUp = "TestPassword!" + System.currentTimeMillis();

    public static String userNameForLogin = "MikeUser";
    public static String userEmailForLogin = "mikeemail@yopmail.com";
    public static String userPasswordForLogin = "TestPW1234";
}
