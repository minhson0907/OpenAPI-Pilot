package myproject.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class customerOnboardSteps extends TestBase {

    String cardNumber;

    @And("^I create iMoney card with \"([^\"]*)\" name and \"([^\"]*)\" email from \"([^\"]*)\" file$")
    public void iCreateSkyClubCardWithFromFile(String name, String email,String path) throws Throwable {
        String oldRequestId, oldNumberPhone, oldName, oldEmail;
        File file = new File(System.getProperty("user.dir") + "\\data\\" + path);
        String filePath = file.getAbsolutePath();
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();

        oldRequestId = getValueInLine(path,18,54,2);
        oldNumberPhone = getValueInLine(path,20,30,7);
        oldName = getValueInLine(path,17,20,6);
        oldEmail = getValueInLine(path,21,26,8);

        // Random requestId
        String newRequestId = UUID.randomUUID().toString();
        System.out.println("********************" + newRequestId);
        // Random phoneNumber
        String newPhoneNumber = String.format("%03d%03d%04d",(int) Math.floor(999*Math.random()), (int) Math.floor(999*Math.random()), (int) Math.floor(9999*Math.random()));
        System.out.println("********************" + newPhoneNumber);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldName,name);
        fileContents = fileContents.replaceAll(oldNumberPhone, newPhoneNumber);
        fileContents = fileContents.replaceAll(oldEmail,email);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire with the above cardNumber from \"([^\"]*)\" file$")
    public void iInquireWithTheAboveCardNumberFromFile(String path) throws Throwable {
        String oldCard;
        File file = new File(System.getProperty("user.dir") + "\\data\\" + path);
        String filePath = file.getAbsolutePath();
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        oldCard = getValueInLine(path,14,22,6);

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, cardNumber);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I get cardNumber from the above request$")
    public void iGetCardNumberFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'accountNumber')]/following-sibling::span[1]"));
        cardNumber = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'accountNumber')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + cardNumber);

    }

    @And("^I inquire with \"([^\"]*)\" cardNumber from \"([^\"]*)\" file$")
    public void iInquireWithCardNumberFromFile(String cardNumber, String fileName) throws Throwable {
        String oldCard;
        String fileContents = readFile(fileName);
        oldCard = getValueInLine(fileContents,14,22,6);

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, cardNumber);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
