package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;

public class billingSteps extends TestBase {
    String providerId,serviceType,customerCode,userName,accountNumber,merchantId,amount,phoneNumber,localBillID,billNo,billSeries,billDetail,billValue;

    @And("^I inquire the bill with \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone from \"([^\"]*)\" file$")
    public void iInquireTheBillWithServiceCodeProviderIdServiceTypeCustomerCodeUserNameAccountNumberMerchantId(String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String path) throws Exception {
        String oldProviderId,oldServiceType,oldCustomerCode,oldUserName,oldAccountNumber,oldMerchantId,oldAmount,oldPhone;
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
        oldProviderId = getValueInLine(path,19,22,4);
        oldServiceType = getValueInLine(path,20,28,5);
        oldCustomerCode = getValueInLine(path,21,34,6);
        oldUserName = getValueInLine(path,17,26,7);
        oldAccountNumber = getValueInLine(path,22,37,8);
        oldMerchantId = getValueInLine(path,19,22,9);
        oldAmount = getValueInLine(path,15,21,10);
        oldPhone = getValueInLine(path,20,30,11);

        fileContents = fileContents.replaceAll(oldProviderId,proId);
        fileContents = fileContents.replaceAll(oldServiceType,serviceType);
        fileContents = fileContents.replaceAll(oldCustomerCode,customerCode);
        fileContents = fileContents.replaceAll(oldUserName,userName);
        fileContents = fileContents.replaceAll(oldAccountNumber,accountNumber);
        fileContents = fileContents.replaceAll(oldMerchantId,merchantId);
        fileContents = fileContents.replaceAll(oldAmount,amount);
        fileContents = fileContents.replaceAll(oldPhone,phone);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I get \"([^\"]*)\" from the above request$")
    public void iGetFromTheAboveRequest(String field) throws Throwable {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'"+field+"')]/following-sibling::span[1]"));
        String item = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'"+field+"')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + item);
    }

    @And("^I get providerId from the above request$")
    public void iGetProviderIdFromTheAboveRequest() throws Exception{
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'providerId')]/following-sibling::span[1]"));
        providerId = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'providerId')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + providerId);
    }

    @And("^I get serviceType from the above request$")
    public void iGetServiceTypeFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'serviceType')]/following-sibling::span[1]"));
        serviceType = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'serviceType')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + serviceType);
    }

    @And("^I pay the above bill from \"([^\"]*)\" file$")
    public void iPayTheAboveBillFromFile(String fileName) throws Throwable {
        String oldproviderId,oldserviceType,oldcustomerCode,olduserName,oldaccountNumber,oldmerchantId,oldamount,oldphoneNumber,oldlocalBillID,oldbillNo,oldbillSeries,oldbillDetail,oldbillValue;
        String fileContents = readFile(fileName);
        oldproviderId = getValueInLine(fileName,18,23,5);
        oldserviceType = getValueInLine(fileName,19,29,6);

        fileContents = fileContents.replaceAll(oldproviderId,providerId);
        fileContents = fileContents.replaceAll(oldserviceType,serviceType);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }


}
