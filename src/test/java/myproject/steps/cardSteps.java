package myproject.steps;

import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class cardSteps extends TestBase {

    @And("^I inquire VJA payment history with \"([^\"]*)\" card number from \"([^\"]*)\" file within a month$")
    public void iInquireVJAPaymentHistoryWithCardNumberFromFileWithinAMonth(String cardNum, String path) throws Exception {
        String oldCard,oldDate;
        oldCard = getValueInLine(path,19,30,6);
        oldDate = getValueInLine(path,15,23,8);
        String fileContents = readFile(path);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, cardNum);
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String date = dateFormat.format(new Date());
        fileContents = fileContents.replaceAll(oldDate,date);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire VJA card information with \"([^\"]*)\" card number from \"([^\"]*)\" file$")
    public void iInquireVJACardInformationWithCardNumberFromFile(String cardNum, String path) throws Exception {
        String oldCard;
        oldCard = getValueInLine(path,19,31,5);
        String fileContents = readFile(path);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, cardNum);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I top up from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount from \"([^\"]*)\" file$")
    public void iTopUpFromToWithAmountFromFile(String fromAccount, String toAccount, String amount, String fileName) throws Exception {
        String oldRequestId,oldFromAccount,oldToAccount,oldAmount;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldFromAccount = getValueInLine(fileName,15,18,6);
        oldToAccount = getValueInLine(fileName,23,26,7);
        oldAmount = getValueInLine(fileName,14,17,8);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldFromAccount, fromAccount);
        fileContents = fileContents.replaceAll(oldToAccount, toAccount);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
