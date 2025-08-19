package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement el= wd.findElement(locator);
        el.click();
        el.clear();
        clearSpace(el);
        if (text.length()>0){
            el.sendKeys(text);
        }
    }

    public void clearSpace(WebElement el){
        el.sendKeys(" ");
        el.sendKeys(Keys.BACK_SPACE);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void buttonYalla(){
         if (isElementPresent(By.xpath("//*[@type='submit']")))
        click(By.xpath("//*[@type='submit']"));

    }

    public boolean isElementPresent(By locator){
        List<WebElement> elementList = wd.findElements(locator);
        return elementList.size()>0;
    }

    public String getMessage() {
        pause(500);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));

        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();

        return res && !result;
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public void getScreen(String link) {
        TakesScreenshot ts= (TakesScreenshot) wd;
        File fileTakesScreenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(fileTakesScreenshot, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
