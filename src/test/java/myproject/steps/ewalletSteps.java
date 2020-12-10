package myproject.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import myproject.base.TestBase;
import org.openqa.selenium.By;

public class ewalletSteps extends TestBase {

    @When("^I access into EwalletService version \"([^\"]*)\"$")
    public void iAccessIntoEwalletServiceVersion(String version) throws Throwable {
        waitElement(By.xpath("//div[@class='apicApiCardMain']//div[text()='"+version+"']"));
        driver.findElement(By.xpath("//div[@class='apicApiCardMain']//div[text()='"+version+"']")).click();
    }

    @Given("^I access into EwalletService on portal at (1|2|3) page$")
    public void iAccessIntoOnPortal( String position) throws Throwable {
        driver.get(prop.getProperty("url.api"));
        switch (position){
            case "2":
                waitElement(By.xpath("//a[@title='Go to next page']"));
                driver.findElement(By.xpath("//a[@title='Go to next page']")).click();
                break;
            case "3":
                waitElement(By.xpath("//a[@title='Go to next page']"));
                driver.findElement(By.xpath("//a[@title='Go to next page']")).click();
                driver.findElement(By.xpath("//a[@title='Go to next page']")).click();
                break;
            default:
        }
        waitElement(By.xpath("//div[@data-original-title='EwalletService']"));
        driver.findElement(By.xpath("//div[@data-original-title='EwalletService']")).click();
    }
}
