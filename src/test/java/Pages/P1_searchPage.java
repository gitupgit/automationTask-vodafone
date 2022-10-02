package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefintion.Hooks;

public class P1_searchPage {

    WebDriver driver;

    public P1_searchPage(WebDriver driver) {
        this.driver = driver;

        //create PageFactory
        PageFactory.initElements(driver, this);
    }

    //pagefactory
    @FindBy(id="twotabsearchtextbox")
    WebElement searchPF;

    public WebElement searchPom(){
        By search = By.id("twotabsearchtextbox");
        WebElement searchElement = Hooks.driver.findElement(search);
        return searchElement;
    }

    public void searchSteps(String search)
    {
        //searchPF.clear();

        searchPom().sendKeys(search);
    }
}
