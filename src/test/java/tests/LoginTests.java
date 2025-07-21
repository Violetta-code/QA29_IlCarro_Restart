package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()) {
              app.getHelperUser().logout();
        }
    }

    @Test(dataProvider = "loginValidFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessTest(User user){
        logger.info("Success login started ===> "+user.getEmail()+user.getPassword());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();
       // app.getHelperUser().pause(15);

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().buttonOk();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Finish testing !!!!!!");
    }

    @Test(dataProvider = "loginWrongEmailFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongEmail(User user){
        logger.info("Wrong Email login started ===> "+user.getEmail()+user.getPassword());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        if(app.getHelperUser().isYallaButtonNotActive()!=true) {
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
            app.getHelperUser().buttonOk();
        }else {
            Assert.assertEquals(app.getHelperUser().getMessage(), "Cannot read properties of undefined (reading 'data')");
            app.getHelperUser().buttonOk();
        }
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void loginWrongSymbolEmail(){
        User user = new User().withEmail("solodka1998mail.ru").withPassword("Atteloiv369!");
        logger.info("Empty Email login started ===> "+user);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Finish testing !!!!!!");
    }


    @Test
    public void loginEmptyEmail(){
        User user = new User().withEmail("").withPassword("Atteloiv369!");
        logger.info("Empty Email login started ===> "+user);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void loginSpaceEmail(){
        User user = new User().withEmail("   ").withPassword("Atteloiv369!");
        logger.info("Space Email login started ===> "+user);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        logger.info("Finish testing !!!!!!");
    }

    @Test(dataProvider = "loginWrongPasswordFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongPassword(User user){
        logger.info("Wrong Password login started ===> "+user.getEmail()+user.getPassword());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();


        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().buttonOk();

        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void loginEmptyPassword(){
        User user = new User().withEmail("solodka1998@mail.ru").withPassword("");
        logger.info("Empty Password login started ===> "+user);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        logger.info("Finish testing !!!!!!");
    }

    @Test
    public void loginSpacePassword(){
        User user = new User().withEmail("solodka1998@mail.ru").withPassword("   ");
        logger.info("Space Password login started ===> "+user);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().buttonOk();
        logger.info("Finish testing !!!!!!");
    }

}
