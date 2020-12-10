package myproject.steps;

import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.util.UUID;

public class domesticSteps extends TestBase {

    @And("^I transfer from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount and \"([^\"]*)\" bankId from \"([^\"]*)\" file$")
    public void iTransferFromToWithAmountAndBankIdFromFile(String fromAccount, String toAccount, String amount, String bankId, String fileName) throws Throwable {
        String oldRequestId,oldFromAccount,oldToAccount,oldAmount,oldBankId;
        oldRequestId = getValueInLine(fileName,18,21,3);
        oldFromAccount = getValueInLine(fileName,26,29,7);
        oldAmount = getValueInLine(fileName,23,26,8);
         oldToAccount = getValueInLine(fileName,24,27,10);
        oldBankId = getValueInLine(fileName,17,20,12);
        String newRequestId = UUID.randomUUID().toString();
        String fileContents = readFile(fileName);
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldRequestId, newRequestId);
        fileContents = fileContents.replaceAll(oldFromAccount, fromAccount);
        fileContents = fileContents.replaceAll(oldToAccount, toAccount);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldBankId, bankId);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
