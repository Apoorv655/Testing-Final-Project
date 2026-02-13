package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class BookingPage extends Base{

   

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

     By searchDestination = By.xpath("//input[@placeholder='Search destinations']");
     By selectDate = By.xpath("//div[normalize-space()='When']");
    By selectSearch= By.xpath("//*[@id=\"react-application\"]/div/div/div[1]/div/div/div[1]/div[3]/div[1]/div/div/header/form/div[1]/div/div[2]/div[3]/button/div/div[2]");
    
    
    public WebElement meathodTask() throws Exception {
       return driver.findElement(searchDestination);    
    }
    
    public WebElement openCalendar() throws Exception {
        WebElement element = driver.findElement(selectDate);
        return element; 
    }
    
    public void clickByXpath(String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(7000);
    }
    
    public void clickSearchButton() throws InterruptedException
    {
    	driver.findElement(selectSearch).click();
    	Thread.sleep(7000);
    }
    
    
}
