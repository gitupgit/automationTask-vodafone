package stepDefintion;

import Pages.P1_searchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class D1_CartStepDef {
    P1_searchPage searchPage;

    @Given("^write search keyword as \"(.*)\"$")
    public void write_keyword(String search) {
        searchPage = new P1_searchPage(Hooks.driver);
        searchPage.searchSteps(search);
        System.out.println("search  " + search);
        searchPage.searchPom().sendKeys(Keys.ENTER);
    }


    @When("select item")
    public void clickItem() {

        Hooks.driver.findElement(By.cssSelector
                ("[src=\"https://m.media-amazon.com/images/I/81dL5l3CYoL._AC_UL320_.jpg\"]")).click();
    }


    @Then("click add to cart")
    public void clickCart() {
        Hooks.driver.findElement(By.cssSelector("[id=\"add-to-cart-button\"]")).sendKeys(Keys.ENTER);
    }

    @Then("notification img visible")
    public void itemAdded() throws InterruptedException {

        String msg = Hooks.driver.findElement(By.cssSelector("span[class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")).getText();
        System.out.println(msg);
        Thread.sleep(2000);
        Assert.assertTrue(msg.contains("Added to Cart"));
    }


    @Given("go  to  today'sDeal")
    public void deal() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("a[href=\"/gp/goldbox?ref_=nav_cs_gb\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @When("select headphone category")
    public void select1() {
        Hooks.driver.findElement(By.xpath
                ("//span [@class=\"CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F\"][text()='Grocery']")).click();
    }


    @And("select grocery")
    public void select2() {
        Hooks.driver.findElement(By.xpath
                ("//span [@class=\"CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F\"][text()='Headphones']")).click();
    }

    @And("select discount part")
    public void select3() {
        Hooks.driver.findElement(By.xpath
                ("//span [@class=\"a-text-bold\"][text()='10% off or more']")).sendKeys(Keys.ENTER);
    }

    @Then("select item add to cart")
    public void add() {
        Hooks.driver.findElement(By.cssSelector("[data-a-hires=\"https://m.media-amazon.com/images/I/41BESnIeuuL._AC_UF452,452_FMjpg_.jpg\"]")).click();
    }


    @And("check if added items")
    public void check() {
        Hooks.driver.findElement(By.name("submit.add-to-cart")).click();
        String msg = Hooks.driver.findElement(By.id("attachDisplayAddBaseAlert")).getText();
        System.out.println(msg);
        //Thread.sleep(2000);
        Assert.assertTrue(msg.contains("Added to Cart"));

    }
}
