package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.util.UUID;

public class domesticSteps extends TestBase {

    @And("^I transfer from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount, \"([^\"]*)\" bankId and \"([^\"]*)\" feePayer from \"([^\"]*)\" file$")
    public void iTransferFromToWithAmountAndBankIdFromFile(String fromAccount, String toAccount, String amount, String bankId, String feePayer, String fileName) throws Throwable {
        String oldRequestId,oldFromAccount,oldToAccount,oldAmount,oldFreePayer,oldBankId;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldFromAccount = getValueInLine(fileName,26,29,6);
        oldAmount = getValueInLine(fileName,23,26,7);
        oldToAccount = getValueInLine(fileName,24,27,10);
        oldFreePayer = getValueInLine(fileName,17,25,8);
        oldBankId = getValueInLine(fileName,17,20,12);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldFromAccount, fromAccount);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldToAccount, toAccount);
        fileContents = fileContents.replaceAll(oldFreePayer,feePayer);
        fileContents = fileContents.replaceAll(oldBankId, bankId);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire citad bank from \"([^\"]*)\" file$")
    public void iInquireCitadBankFromFile(String fileName) throws Throwable {
        String oldRequestId;
        oldRequestId = getValueInLine(fileName,18,21,2);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I transfer from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount and \"([^\"]*)\" cardCode from \"([^\"]*)\" file$")
    public void iTransferFromToWithAmountAndCardCodeFromFile(String fromAccount, String toAccount, String amount, String cardCode, String fileName) throws Throwable {
        String oldRequestId,oldFromAccount,oldToAccount,oldAmount,oldCardCode;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldFromAccount = getValueInLine(fileName,26,29,6);
        oldToAccount = getValueInLine(fileName,24,27,7);
        oldAmount = getValueInLine(fileName,23,26,8);
        oldCardCode = getValueInLine(fileName,17,23,10);

        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldFromAccount, fromAccount);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldToAccount, toAccount);
        fileContents = fileContents.replaceAll(oldCardCode,cardCode);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);

    }

    @And("^I inquire to \"([^\"]*)\" with \"([^\"]*)\" cardCode from \"([^\"]*)\" file$")
    public void iInquireToWithAmountAndCardCodeFromFile(String toAccount, String cardCode, String fileName) throws Throwable {
        String oldRequestId,oldToAccount,oldAmount,oldCardCode;
        oldRequestId = getValueInLine(fileName,18,21,2);
        oldToAccount = getValueInLine(fileName,24,27,5);
//        oldAmount = getValueInLine(fileName,23,26,5);
        oldCardCode = getValueInLine(fileName,17,23,6);

        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
//        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldToAccount, toAccount);
        fileContents = fileContents.replaceAll(oldCardCode,cardCode);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
