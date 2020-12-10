package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;

public class billingSteps extends TestBase {
    String providerId, serviceType, customerCode, userName, accountNumber, merchantId, amount, phoneNumber, localBillID, billNo, billSeries, billDetail, billValue;

    @And("^I inquire the bill with \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone from \"([^\"]*)\" file$")
    public void iInquireTheBillWithServiceCodeProviderIdServiceTypeCustomerCodeUserNameAccountNumberMerchantId(String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String path) throws Exception {
        String oldProviderId, oldServiceType, oldCustomerCode, oldUserName, oldAccountNumber, oldMerchantId, oldAmount, oldPhone;
        File file = new File(System.getProperty("user.dir") + "\\data\\" + path);
        String filePath = file.getAbsolutePath();
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: " + fileContents);
        //closing the Scanner object
        sc.close();
        oldProviderId = getValueInLine(path, 19, 22, 4);
        oldServiceType = getValueInLine(path, 20, 28, 5);
        oldCustomerCode = getValueInLine(path, 21, 34, 6);
        oldUserName = getValueInLine(path, 17, 26, 7);
        oldAccountNumber = getValueInLine(path, 22, 37, 8);
        oldMerchantId = getValueInLine(path, 19, 22, 9);
        oldAmount = getValueInLine(path, 15, 21, 10);
        oldPhone = getValueInLine(path, 20, 30, 11);

        fileContents = fileContents.replaceAll(oldProviderId, proId);
        fileContents = fileContents.replaceAll(oldServiceType, serviceType);
        fileContents = fileContents.replaceAll(oldCustomerCode, customerCode);
        fileContents = fileContents.replaceAll(oldUserName, userName);
        fileContents = fileContents.replaceAll(oldAccountNumber, accountNumber);
        fileContents = fileContents.replaceAll(oldMerchantId, merchantId);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldPhone, phone);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I get \"([^\"]*)\" from the above request$")
    public void iGetFromTheAboveRequest(String field) throws Throwable {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'" + field + "')]/following-sibling::span[1]"));
        String item = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'" + field + "')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + item);
    }

    @And("^I get providerId from the above request$")
    public void iGetProviderIdFromTheAboveRequest() throws Exception {
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
        String oldproviderId, oldserviceType, oldcustomerCode, olduserName, oldaccountNumber, oldmerchantId, oldamount, oldphoneNumber, oldlocalBillID, oldbillNo, oldbillSeries, oldbillDetail, oldbillValue;
        String fileContents = readFile(fileName);
        oldproviderId = getValueInLine(fileName, 18, 23, 5);
        oldserviceType = getValueInLine(fileName, 19, 29, 6);
        oldcustomerCode = getValueInLine(fileName, 20, 34, 7);
        olduserName = getValueInLine(fileName, 16, 27, 8);
        oldaccountNumber = getValueInLine(fileName, 21, 38, 9);
        oldmerchantId = getValueInLine(fileName, 18, 23, 10);
        oldamount = getValueInLine(fileName,14,22 , 13);
        oldphoneNumber = getValueInLine(fileName,19 ,31, 14);
        oldlocalBillID = getValueInLine(fileName,23,31 , 18);
        oldbillNo = getValueInLine(fileName, 18,23, 19);
        oldbillSeries = getValueInLine(fileName,22,28 , 20);
        oldbillDetail = getValueInLine(fileName,22,27 , 21);
        oldbillValue = getValueInLine(fileName, 21,29, 22);

        fileContents = fileContents.replaceAll(oldproviderId, providerId);
        fileContents = fileContents.replaceAll(oldserviceType, serviceType);
        fileContents = fileContents.replaceAll(oldcustomerCode, customerCode);
        fileContents = fileContents.replaceAll(olduserName, userName);
        fileContents = fileContents.replaceAll(oldaccountNumber, accountNumber);
        fileContents = fileContents.replaceAll(oldmerchantId, merchantId );
        fileContents = fileContents.replaceAll(oldamount, amount);
        fileContents = fileContents.replaceAll(oldphoneNumber, phoneNumber);
        fileContents = fileContents.replaceAll(oldlocalBillID, localBillID);
        fileContents = fileContents.replaceAll(oldbillNo,billNo );
        fileContents = fileContents.replaceAll(oldbillSeries,billSeries);
        fileContents = fileContents.replaceAll(oldbillDetail, billDetail);
        fileContents = fileContents.replaceAll(oldbillValue, billValue);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }


    @And("^I get customerCode from the above request$")
    public void iGetCustomerCodeFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'customerCode')]/following-sibling::span[1]"));
        customerCode = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'customerCode')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + customerCode);
    }

    @And("^I get userName from the above request$")
    public void iGetUserNameFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'userName')]/following-sibling::span[1]"));
        userName = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'userName')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + userName);
    }

    @And("^I get accountNumber from the above request$")
    public void iGetAccountNumberFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'accountNumber')]/following-sibling::span[1]"));
        accountNumber = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'accountNumber')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + accountNumber);
    }

    @And("^I get merchantId from the above request$")
    public void iGetMerchantIdFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'merchantId')]/following-sibling::span[1]"));
        merchantId = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'merchantId')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + merchantId);
    }

    @And("^I get amount from the above request$")
    public void iGetAmountFromTheAboveRequest()  throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'amount')]/following-sibling::span[1]"));
        amount = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'amount')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + amount);
    }

    @And("^I get phoneNumber from the above request$")
    public void iGetPhoneNumberFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'phoneNumber')]/following-sibling::span[1]"));
        phoneNumber = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'phoneNumber')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + phoneNumber);
    }

    @And("^I get localBillID from the above request$")
    public void iGetLocalBillIDFromTheAboveRequest()  throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')]/following-sibling::span[1]"));
        localBillID = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + localBillID);
    }

    @And("^I get billNo from the above request$")
    public void iGetBillNoFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')]/following-sibling::span[1]"));
        billNo = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billNo);
    }

    @And("^I get billSeries from the above request$")
    public void iGetBillSeriesFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')]/following-sibling::span[1]"));
        billSeries = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billSeries);
    }

    @And("^I get billDetail from the above request$")
    public void iGetBillDetailFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billDetail')]/following-sibling::span[1]"));
        billDetail = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billDetail')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billDetail);
    }

    @And("^I get billValue from the above request$")
    public void iGetBillValueFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')]/following-sibling::span[1]"));
        billValue = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billValue);
    }

    @And("^I inquire service list with serviceType is \"([^\"]*)\" from \"([^\"]*)\" file$")
    public void iInquireServiceListWithServiceTypeIsFromFile(String serviceType, String fileName) throws Throwable {
        String oldServiceType;
        String fileContents = readFile(fileName);
        oldServiceType = getValueInLine(fileName, 18, 25, 2);
        fileContents = fileContents.replaceAll(oldServiceType, serviceType);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire provider list with serviceType is \"([^\"]*)\" and serviceCode is \"([^\"]*)\" from \"([^\"]*)\" file$")
    public void iInquireProviderListWithServiceTypeIsAndServiceCodeIsFromFile(String serviceType, String serviceCode, String fileName) throws Throwable {
        String oldServiceType,oldServiceCode;
        String fileContents = readFile(fileName);
        oldServiceCode = getValueInLine(fileName, 18, 22, 2);
        oldServiceType = getValueInLine(fileName, 18, 25, 3);
        fileContents = fileContents.replaceAll(oldServiceCode, serviceCode);
        fileContents = fileContents.replaceAll(oldServiceType, serviceType);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire code topup with providerId is \"([^\"]*)\" from \"([^\"]*)\" file$")
    public void iInquireCodeTopupWithProviderIdIsFromFile(String providerId, String fileName) throws Throwable {
        String oldproviderId;
        String fileContents = readFile(fileName);
        oldproviderId = getValueInLine(fileName, 17, 22, 2);
        fileContents = fileContents.replaceAll(oldproviderId, providerId);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
