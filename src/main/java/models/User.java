package models;

import org.openqa.selenium.Cookie;

public class User {

    private String email;
    private  String name;
    private String password;
    private Cookie cookie;

    public User(){}

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public User setCookie(Cookie cookie) {
        this.cookie = cookie;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
