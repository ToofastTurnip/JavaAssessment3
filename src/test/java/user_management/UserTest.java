package user_management;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setup() {
        user = new User(
                "dingusman@gmail.com",
                1,
                "Mitch Taylor",
                "password"
        );
    }

    @Test
    public void getEmailTest() {
        Assert.assertEquals("dingusman@gmail.com", user.getEmail());
    }

    @Test
    public void getIdTest() {
        Assert.assertEquals(1, user.getId());
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Mitch Taylor", user.getName());
    }

    @Test
    public void getPasswordTest() {
        Assert.assertEquals("password", user.getPassword());
    }

}