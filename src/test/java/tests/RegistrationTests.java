package tests;

import com.google.errorprone.annotations.InlineMeValidationDisabled;
import manager.DataProviderUserRegistration;
import models.User;
import models.UserRegistration;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccessTest(){
        int i = new Random().nextInt(1000)+1000;

        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("test"+i+"@test.com").setPassword("Test"+i+"!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().getScreen("src/test/screenshots/screen-"+i +".png");
        app.getHelperUser().clickPolicyLabel();
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
        app.getHelperUser().buttonOk();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationEmptyFirstName(){
        UserRegistration user=new UserRegistration()
                .setFirstName("").setLastName("test").setEmail("test12345@test.com").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    //Bug
    @Test(enabled = false)
    public void registrationSpaceFirstName(){
        UserRegistration user=new UserRegistration()
                .setFirstName("   ").setLastName("test").setEmail("test12345@test.com").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationEmptyLastName(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("").setEmail("test12345@test.com").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    //Bug
    @Test(enabled = false)
    public void registrationSpaceLastName(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("   ").setEmail("test12345@test.com").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test(dataProvider = "registrationWrongEmailFile", dataProviderClass = DataProviderUserRegistration.class)
    public void registrationWrongEmailTest(UserRegistration user){
        logger.info("Wrong Email Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()==true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
                    "Wrong email format");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationWrongEmailTest(){
        int i = new Random().nextInt(1000)+1000;

        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("Test"+i+"@test.com").setPassword("Test"+i+"!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().getScreen("src/test/screenshots/screen-"+i +".png");
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()==true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationEmptyEmailTest(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()==true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationSpaceEmailTest(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("   ").setPassword("Test12345!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()==true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test(dataProvider = "registrationWrongPasswordFile", dataProviderClass = DataProviderUserRegistration.class)
    public void registrationWrongPasswordTest(UserRegistration user){
        logger.info("Wrong Password Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()!=true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain 1 uppercase letter, " +
                    "1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationEmptyPasswordTest(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("test1234@test.com").setPassword("");

        logger.info("Wrong Password Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()!=true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void registrationSpacePasswordTest(){
        UserRegistration user=new UserRegistration()
                .setFirstName("test").setLastName("test").setEmail("test1234@test.com").setPassword("   ");

        logger.info("Wrong Password Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().clickPolicyLabel();

        if(app.getHelperUser().isYallaButtonNotActive()!=true) {
            Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain 1 uppercase letter, " +
                    "1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
            Assert.assertFalse(app.getHelperUser().isLogged());
        }
        logger.info("Finish testing !!!!!!");
    }
}
