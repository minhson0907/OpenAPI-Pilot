package myproject.steps;

import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class inhouseFTSteps extends TestBase {

    String traceNumber;

    @And("^I get trace number from the above response$")
    public void iGetTraceNumberFromTheAboveResponse() throws Exception{
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'bankTransactionId')]/following-sibling::span[1]"));
        String s_traceNumber = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'bankTransactionId')]/following-sibling::span[1]")).getText();
        traceNumber = s_traceNumber.substring(1,7);
        System.out.println("********************* " + traceNumber);
    }

    @And("^I transfer from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount from \"([^\"]*)\" api$")
    public void iTransferFromTo(String fromAccountNum, String toAccountNum, String amount, String path) throws Throwable {
        String oldLine1,oldLine2,oldAmount;
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
        String fromAccount = Files.readAllLines(Paths.get(filePath)).get(6);
        System.out.println("********************" + fromAccount);
        oldLine1 = fromAccount.substring(26,41);
        System.out.println("********************" + oldLine1);

        String toAccount = Files.readAllLines(Paths.get(filePath)).get(7);
        System.out.println("********************" + toAccount);
        oldLine2 = toAccount.substring(24,39);
        System.out.println("********************" + oldLine2);
        oldAmount = getValueInLine(path,23,28,8);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine1, fromAccountNum);
        fileContents = fileContents.replaceAll(oldLine2, toAccountNum);
        fileContents = fileContents.replaceAll(oldAmount,amount);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I transfer from \"([^\"]*)\" with the above trace number from \"([^\"]*)\" api$")
    public void iTransferFromWithTheAboveTraceNumberFromFile(String fromAccountNum, String path) throws Throwable {
        String oldRequestId,oldLine1,oldLine2,oldLine3;
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
        oldLine1 = getValueInLine(path,26,32,6);
        oldLine2 = getValueInLine(path,26,41,7);
        oldLine3 = getValueInLine(path,24,26,8);
        oldRequestId = getValueInLine(path,18,21,2);
        String newRequestId = UUID.randomUUID().toString();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(new Date());
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldLine1, traceNumber);
        fileContents = fileContents.replaceAll(oldLine2, fromAccountNum);
        fileContents = fileContents.replaceAll(oldLine3, date);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

}
