package testData;

import models.User;
import org.openqa.selenium.Cookie;

public interface UserData {

    Cookie cookie = new Cookie.Builder("dj_session_id", "4pdyj0nakera556o3mzqc5ktl8yyeguq")
            .domain("www.udemy.com")
            .path("/")
            .build();

    User registeredUser = new User()
            .setCookie(cookie)
            .setEmail("mikeemail@yopmail.com")
            .setName("MikeUser")
            .setPassword("TestPW1234");

    User newUser = new User()
            .setEmail(System.currentTimeMillis() + "test@yopmail.com")
            .setName("mikeUser" + System.currentTimeMillis())
            .setPassword("TestPassword!" + System.currentTimeMillis());

}
