package myproject.steps;

import cucumber.api.java.en.And;
import myproject.base.TestBase;

public class onlineDomesticFTProductSteps extends TestBase {

    @And("^I inquire from \"([^\"]*)\" to \"([^\"]*)\" with \"([^\"]*)\" amount and \"([^\"]*)\" bankCode from \"([^\"]*)\" file$")
    public void iInquireFromToWithAmountAndBankCodeFromFile(String fromAccount, String toAccount, String amount, String bankCode, String fileName) throws Throwable {
        String oldFromAccount, oldToAccount, oldAmount, oldBankCode;

    }
}
