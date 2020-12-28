package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class cardSteps extends TestBase {

    @And("^I inquire VJA payment history with \"([^\"]*)\" user name, \"([^\"]*)\" card number from \"([^\"]*)\" file within a month$")
    public void iInquireVJAPaymentHistoryWithCardNumberFromFileWithinAMonth(String userName,String cardNum, String path) throws Exception {
        String olduserName,oldCard,oldDate;
        olduserName = getValueInLine(path,17,27,5);
        oldCard = getValueInLine(path,19,30,6);
        oldDate = getValueInLine(path,15,23,8);
        String fileContents = readFile(path);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(olduserName, userName);
        fileContents = fileContents.replaceAll(oldCard, cardNum);
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String date = dateFormat.format(new Date());
        fileContents = fileContents.replaceAll(oldDate,date);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire VJA card information with \"([^\"]*)\" card number and \"([^\"]*)\" user name from \"([^\"]*)\" file$")
    public void iInquireVJACardInformationWithCardNumberFromFile(String cardNum,String userName, String path) throws Exception {
        String oldCard,oldUserName;
        oldCard = getValueInLine(path,19,31,5);
        oldUserName = getValueInLine(path,17,27,6);
        String fileContents = readFile(path);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldCard, cardNum);
        fileContents = fileContents.replaceAll(oldUserName,userName);
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

    @And("^I send a request otp with \"([^\"]*)\" cardNumber, \"([^\"]*)\" amount and \"([^\"]*)\" userName from \"([^\"]*)\" file$")
    public void iSendARequestOtpWithCardNumberAmountAndUserNameFromFile(String cardNumber, String amount, String userName, String fileName) throws Throwable {
        String oldRequestId, oldcardNumber, oldamount, olduserName;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldcardNumber = getValueInLine(fileName,19,31,5);
        oldamount = getValueInLine(fileName,14,19,6);
        olduserName = getValueInLine(fileName,17,27,8);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldcardNumber, cardNumber);
        fileContents = fileContents.replaceAll(oldamount, amount);
        fileContents = fileContents.replaceAll(olduserName, userName);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @Then("^I pay VJA ticket with the above otp, \"([^\"]*)\" cardNumber, \"([^\"]*)\" amount and \"([^\"]*)\" userName from \"([^\"]*)\" file$")
    public void iPayVJATicketWithTheAboveOtpCardNumberAmountAndUserNameFromFile(String cardNumber, String amount, String userName, String fileName) throws Throwable {
        String oldRequestId, oldcardNumber, oldamount, olduserName;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldcardNumber = getValueInLine(fileName,19,31,5);
        oldamount = getValueInLine(fileName,14,19,6);
        olduserName = getValueInLine(fileName,17,27,8);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldcardNumber, cardNumber);
        fileContents = fileContents.replaceAll(oldamount, amount);
        fileContents = fileContents.replaceAll(olduserName, userName);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @Then("^I inquire credit card list with \"([^\"]*)\" clientIdentifier from \"([^\"]*)\" file$")
    public void iInquireCreditCardListWithClientIdentifierFromFile(String id, String fileName) throws Throwable {
        String oldRequestId, oldId;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldId = getValueInLine(fileName,25,33,6);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldId, id);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
