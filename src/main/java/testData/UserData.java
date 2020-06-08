package testData;

import models.User;

public interface UserData {

    User registeredUser = new User("mikeemail@yopmail.com", "MikeUser", "TestPW1234");

    User newUser = new User()
            .setEmail("mikeUser" + System.currentTimeMillis())
            .setName(System.currentTimeMillis() + "email@yopmail.com")
            .setPassword("TestPassword!" + System.currentTimeMillis());

}
