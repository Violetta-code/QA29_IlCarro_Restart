package tests;

import manager.DataProviderCar;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
           app.getHelperUser().login(new User().withEmail("solodka1998@mail.ru").withPassword("Atteloiv123!"));
        }
    }

    @Test(dataProvider = "validCarFile", dataProviderClass = DataProviderCar.class)
    public void addNewCarSuccess(Car car){

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().okButtoon();
        app.getHelperCar().addPhoto("D:\\QA_29_Auto\\QA29_IlCarro_Restart\\cernoe.jpg");
        app.getHelperCar().buttonYalla();
    }

    @Test
    public void addNewCarFail(Car car){

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().okButtoon();
        app.getHelperCar().addPhoto("D:\\QA_29_Auto\\QA29_IlCarro_Restart\\cernoe.jpg");
        app.getHelperCar().buttonYalla();

        Assert.assertTrue();
    }


}
