package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends HelperBase{

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        //click(By.xpath("//a[text()=' Let the car work ']"));
        // click(By.xpath("//*[@id='1' AND @class='logo']"));
        click(By.xpath("//*[@id='1']"));
    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
    }

    public void fillCarForm(Car car) {
        type(By.xpath("//*[@id='pickUpPlace']"),car.getLocation());
        pause(500);
        if(isElementPresent(By.xpath("/html/body/div[4]/div/table/tr/td[2]/button"))) {
            click(By.xpath("/html/body/div[4]/div/table/tr/td[2]/button"));
        }
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), String.valueOf(car.getSeats()));
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice() + "");
        type(By.id("about"), car.getAbout());
    }

    public void addPhoto(String link) {
        wd.findElement(By.xpath("//a[text()='Add photos of your car']")).sendKeys(link);
    }

    public void okButtoon(){
        click(By.xpath("/html/body/div[5]/div/table/tr/td[2]/button"));
    }

}