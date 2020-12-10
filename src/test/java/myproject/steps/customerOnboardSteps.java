package myproject.steps;


import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class customerOnboardSteps extends TestBase {

    @And("^I create iMoney card with \"([^\"]*)\" name from \"([^\"]*)\" file$")
    public void iCreateSkyClubCardWithFromFile(String name,String path) throws Throwable {
        String oldRequestId, oldNumberPhone, oldName;
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
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire \"([^\"]*)\" card information from \"([^\"]*)\" file$")
    public void iInquireCardInformationFromFile(String card, String path) throws Throwable {
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
        oldCard = getValueInLine(path,15,21,6);

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, card);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
