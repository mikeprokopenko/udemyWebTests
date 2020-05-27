package config;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    private final String USER_NAME_FOR_SIGN_UP = "mikeUser" + System.currentTimeMillis();
    private final String USER_EMAIL_FOR_SIGN_UP = System.currentTimeMillis() + "email@yopmail.com";
    private final String USER_PW_FOR_SIGN_UP = "TestPassword!" + System.currentTimeMillis();
    private final String[] ARRAY_HEADER_CATEGORIES = {"Development", "Business", "Finance & Accounting", "IT & Software", "Office Productivity",
    "Personal Development", "Design", "Marketing", "Lifestyle", "Photography", "Health & Fitness", "Music", "Teaching & Academics"};

    public String getUSER_NAME_FOR_SIGN_UP() {
        return USER_NAME_FOR_SIGN_UP;
    }

    public String getUSER_EMAIL_FOR_SIGN_UP() {
        return USER_EMAIL_FOR_SIGN_UP;
    }

    public String getUSER_PW_FOR_SIGN_UP() {
        return USER_PW_FOR_SIGN_UP;
    }

    public String getUSER_NAME_FOR_LOGIN() {
        return "MikeUser";
    }

    public String getUSER_EMAIL_FOR_LOGIN() {
        return "mikeemail@yopmail.com";
    }

/*    public String getUSER_PW_FOR_LOGIN() {
        return "TestPW1234";
    }*/

    public String getSearchKeyword() {
        return "Angular";
    }

    public ArrayList<String> getARRAY_LIST_HEADER_CATEGORIES() {
        return new ArrayList<>(Arrays.asList(ARRAY_HEADER_CATEGORIES));
    }
}
