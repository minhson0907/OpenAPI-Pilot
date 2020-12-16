package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myproject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class commonSteps extends TestBase {

    @Given("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginWithUsernameAndPassword(String userName, String passWord) throws Exception {
//        driver.get(prop.getProperty("url.api"));
        driver.navigate().to(prop.getProperty("url.api"));
        waitElement(By.id("edit-name"));
        driver.findElement(By.id("edit-name")).clear();
        driver.findElement(By.id("edit-name")).sendKeys(userName);
        driver.findElement(By.id("edit-pass")).clear();
        driver.findElement(By.id("edit-pass")).sendKeys(passWord);
        driver.findElement(By.id("edit-submit")).click();
//        endSession("Your current session.");
        waitElement(By.xpath("//a[text()='See all products']"));
        driver.findElement(By.xpath("//a[text()='See all products']")).click();
    }

    @When("^I access into \"([^\"]*)\" on portal at (1|2|3) page$")
    public void iAccessIntoOnOpenApiLink(String type, String position) throws Exception {
        switch (position) {
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
        waitElement(By.xpath("//div[@data-original-title='" + type + "']"));
        driver.findElement(By.xpath("//div[@data-original-title='" + type + "']")).click();
    }

    @Then("^I access into \"([^\"]*)\" api$")
    public void iAccessIntoApi(String type) throws Exception {
        waitElement(By.xpath("//li[@class='tocItem toc-op-method-post toc-op-path-" + type + "']"));
        driver.findElement(By.xpath("//li[@class='tocItem toc-op-method-post toc-op-path-" + type + "']")).click();
    }

    @And("^I click on \"([^\"]*)\" tab$")
    public void iClickOnTab(String text) throws Exception {
        waitElement(By.xpath("//a[text()='" + text + "']"));
        driver.findElement(By.xpath("//a[text()='" + text + "']")).click();
    }

    @And("^I click \"([^\"]*)\" button$")
    public void iClickButton(String button) throws Exception {
        waitElement(By.xpath("//button[text()='" + button + "']"));
        driver.findElement(By.xpath("//button[text()='" + button + "']")).click();
        Thread.sleep(10000);
    }

    @And("^I input \"([^\"]*)\" into Authorization$")
    public void iInputIntoAuthorization(String autho) throws Exception {
        waitElement(By.id("Authorization"));
        driver.findElement(By.id("Authorization")).clear();
        driver.findElement(By.id("Authorization")).sendKeys(autho);
    }

    @And("^I verify \"([^\"]*)\" \"([^\"]*)\" is displayed in response$")
    public void iVerifyIsDisplayedInResponse(String text1, String text2) throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']"));
        String responseBody = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']")).getText();
        assertTrue(responseBody.contains(text1));
        assertTrue(responseBody.contains(text2));
    }

    @And("^I input \"([^\"]*)\" Client Secret$")
    public void iInputClientSecret(String clientSecret) throws Throwable {
        waitElement(By.id("clientSecret"));
        driver.findElement(By.id("clientSecret")).clear();
        driver.findElement(By.id("clientSecret")).sendKeys(clientSecret);
    }

    @And("^I logout with \"([^\"]*)\"$")
    public void iLogoutWith(String user) throws Throwable {
        waitElement(By.xpath("//li[@title='" + user + "']"));
        driver.findElement(By.xpath("//li[@title='" + user + "']")).click();
        waitElement(By.xpath("//a[text()='Sign out']"));
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
    }

    @When("^I access into \"([^\"]*)\"$")
    public void iAccessInto(String text) throws Throwable {
        waitElement(By.xpath("//a[text()='"+text+"']"));
        driver.findElement(By.xpath("//a[text()='"+text+"']")).click();
    }

    public void endSession (String text) throws Exception{
        List<WebElement> listSession = driver.findElements(By.xpath("//span[@class='children']"));
        for (int i = 0; i < listSession.size(); i++) {
            waitElement(By.xpath("//span[@class='children']"));
            if(!listSession.get(i).getText().contains(text)){
                System.out.println(listSession.get(i).getText());
                listSession.get(i).click();
                driver.findElement(By.id("edit-submit")).click();
            }
        }
    }

    @Then("^I choose version \"([^\"]*)\"$")
    public void iChooseVersion(String version) throws Throwable {
        waitElement(By.xpath("//div[@class='apicApiCardVersion']//div[text()='"+version+"']"));
        driver.findElement(By.xpath("//div[@class='apicApiCardVersion']//div[text()='"+version+"']")).click();
    }

    @And("^I click Generate on transactionId$")
    public void iClickGenerateOnTransactionId() throws Exception{
        waitElement(By.xpath("//div[@class='parameterOther']//a[text()='Generate']"));
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class='parameterOther']//a[text()='Generate']")).click();
        clickToElementByJS("//div[@class='parameterOther']//a[text()='Generate']");
    }

    @And("^I wait for \"([^\"]*)\" seconds$")
    public void iWaitForSeconds(int seconds) throws Exception {
        Thread.sleep(seconds * 1000);
    }
}
