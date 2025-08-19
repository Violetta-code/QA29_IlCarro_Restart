package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;
    HelperUser helperUser;
    String browser;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    HelperCar helperCar;

    public ApplicationManager() {
        this.wd = wd;
    }

    public void init() {

        wd = new EdgeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.web.app/");
        logger.info("Open link --->"+wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperCar= new HelperCar(wd);

    }
    public void stop(){

        wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperCar getHelperCar() {
        return helperCar;
    }

}
