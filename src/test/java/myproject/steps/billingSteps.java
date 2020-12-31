package myproject.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import myproject.base.TestBase;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class billingSteps extends TestBase {
    String localBillID, billNo, billSeries, billDetail, billValue,localBillID1, billNo1, billSeries1, billValue1,localBillID2, billNo2, billSeries2, billValue2;
    String topupCode;

    @And("^I inquire the bill with \"([^\"]*)\" serviceCode, \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone, \"([^\"]*)\" topupPlanCode from \"([^\"]*)\" api$")
    public void iInquireTheBillWithServiceCodeProviderIdServiceTypeCustomerCodeUserNameAccountNumberMerchantId(String serCode, String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String topupPlanCode, String path) throws Exception {
        String oldRequestId,oldServiceCode, oldProviderId, oldServiceType, oldCustomerCode, oldUserName, oldAccountNumber, oldMerchantId, oldAmount, oldPhone,oldtopupPlanCode;
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
        oldRequestId = getValueInLine(path,16,19,1);
        oldServiceCode = getValueInLine(path,18,31,3);
        oldProviderId = getValueInLine(path, 19, 22, 5);
        oldServiceType = getValueInLine(path, 20, 28, 6);
        oldCustomerCode = getValueInLine(path, 21, 34, 7);
        oldUserName = getValueInLine(path, 17, 26, 8);
        oldAccountNumber = getValueInLine(path, 22, 37, 9);
        oldMerchantId = getValueInLine(path, 19, 22, 10);
        oldAmount = getValueInLine(path, 15, 21, 11);
        oldPhone = getValueInLine(path, 20, 30, 12);
        oldtopupPlanCode = getValueInLine(path, 22, 32, 15);

        String newRequestId = UUID.randomUUID().toString();
        fileContents = fileContents.replaceAll(oldRequestId,newRequestId);
        fileContents = fileContents.replaceAll(oldServiceCode,serCode);
        fileContents = fileContents.replaceAll(oldProviderId, proId);
        fileContents = fileContents.replaceAll(oldServiceType, serviceType);
        fileContents = fileContents.replaceAll(oldCustomerCode, customerCode);
        fileContents = fileContents.replaceAll(oldUserName, userName);
        fileContents = fileContents.replaceAll(oldAccountNumber, accountNumber);
        fileContents = fileContents.replaceAll(oldMerchantId, merchantId);
        fileContents = fileContents.replaceAll(oldAmount, amount);
        fileContents = fileContents.replaceAll(oldPhone, phone);
        fileContents = fileContents.replaceAll(oldtopupPlanCode, topupPlanCode);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I get \"([^\"]*)\" from the above request$")
    public void iGetFromTheAboveRequest(String field) throws Throwable {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'" + field + "')]/following-sibling::span[1]"));
        String item = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'" + field + "')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + item);
    }

    @And("^I pay the above bill with \"([^\"]*)\" serviceCode, \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone, \"([^\"]*)\" topupPlanCode from \"([^\"]*)\" api$")
    public void iPayTheAboveBillFromFile(String serCode, String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String topupPlanCode,String fileName) throws Throwable {
        String oldRequestId,oldServiceCode,oldproviderId, oldserviceType, oldcustomerCode, olduserName, oldaccountNumber, oldmerchantId, oldamount, oldphoneNumber,oldtopupPlanCode, oldlocalBillID, oldbillNo, oldbillSeries, oldbillDetail, oldbillValue;
        String fileContents = readFile(fileName);
        oldRequestId = getValueInLine(fileName,16,19,1);
        oldServiceCode = getValueInLine(fileName,18,31,3);
        oldproviderId = getValueInLine(fileName, 19, 22, 5);
        oldserviceType = getValueInLine(fileName, 20, 28, 6);
        oldcustomerCode = getValueInLine(fileName, 21, 34, 7);
        olduserName = getValueInLine(fileName, 17, 26, 8);
        oldaccountNumber = getValueInLine(fileName, 22, 37, 9);
        oldmerchantId = getValueInLine(fileName, 19, 22, 10);
        oldamount = getValueInLine(fileName,15,21 , 11);
        oldphoneNumber = getValueInLine(fileName,20 ,30, 12);
        oldtopupPlanCode = getValueInLine(fileName, 22, 32, 15);
        oldlocalBillID = getValueInLine(fileName,23,31 , 18);
        oldbillNo = getValueInLine(fileName, 18,23, 19);
        oldbillSeries = getValueInLine(fileName,22,28 , 20);
//        oldbillDetail = getValueInLine(fileName,22,27 , 21);
        oldbillValue = getValueInLine(fileName, 21,29, 21);

        String newRequestId = UUID.randomUUID().toString();
        fileContents = fileContents.replaceAll(oldRequestId,newRequestId);
        fileContents = fileContents.replaceAll(oldServiceCode, serCode);
        fileContents = fileContents.replaceAll(oldproviderId, proId);
        fileContents = fileContents.replaceAll(oldserviceType, serviceType);
        fileContents = fileContents.replaceAll(oldcustomerCode, customerCode);
        fileContents = fileContents.replaceAll(olduserName, userName);
        fileContents = fileContents.replaceAll(oldaccountNumber, accountNumber);
        fileContents = fileContents.replaceAll(oldmerchantId, merchantId);
        fileContents = fileContents.replaceAll(oldamount, amount);
        fileContents = fileContents.replaceAll(oldphoneNumber, phone);
        fileContents = fileContents.replaceAll(oldtopupPlanCode,topupPlanCode);
        fileContents = fileContents.replaceAll(oldlocalBillID, localBillID);
        fileContents = fileContents.replaceAll(oldbillNo,billNo );
        fileContents = fileContents.replaceAll(oldbillSeries,billSeries);
//        fileContents = fileContents.replaceAll(oldbillDetail, billDetail);
        fileContents = fileContents.replaceAll(oldbillValue, billValue);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I get localBillID from the above request$")
    public void iGetLocalBillIDFromTheAboveRequest()  throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')]/following-sibling::span[1]"));
        localBillID = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + localBillID);
    }

    @And("^I get localBillID1 from the above request$")
    public void iGetLocalBill1IDFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')][1]/following-sibling::span[1]"));
        localBillID1 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')][1]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + localBillID);
    }

    @And("^I get localBillID2 from the above request$")
    public void iGetLocalBill2IDFromTheAboveRequest()  throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')][2]/following-sibling::span[1]"));
        localBillID2 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'localBillID')][2]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + localBillID);
    }

    @And("^I get billNo from the above request$")
    public void iGetBillNoFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')]/following-sibling::span[1]"));
        billNo = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billNo);
    }

    @And("^I get billNo1 from the above request$")
    public void iGetBillNo1FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')][1]/following-sibling::span[1]"));
        billNo1 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')][1]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billNo);
    }

    @And("^I get billNo2 from the above request$")
    public void iGetBillNo2FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')][2]/following-sibling::span[1]"));
        billNo2 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billNo')][2]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billNo);
    }

    @And("^I get billSeries from the above request$")
    public void iGetBillSeriesFromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')]/following-sibling::span[1]"));
        billSeries = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billSeries);
    }

    @And("^I get billSeries1 from the above request$")
    public void iGetBillSeries1FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')][1]/following-sibling::span[1]"));
        billSeries1 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')][1]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billSeries);
    }

    @And("^I get billSeries2 from the above request$")
    public void iGetBillSeries2FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')][2]/following-sibling::span[1]"));
        billSeries2 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billSeries')][2]/following-sibling::span[1]")).getText();
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

    @And("^I get billValue1 from the above request$")
    public void iGetBillValue1FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')][1]/following-sibling::span[1]"));
        billValue1 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')][1]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billValue);
    }

    @And("^I get billValue2 from the above request$")
    public void iGetBillValue2FromTheAboveRequest() throws Exception {
        waitElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')][2]/following-sibling::span[1]"));
        billValue2 = driver.findElement(By.xpath("//div[@class='contrast responseDetails responseBody']//span[contains(.,'billValue')][2]/following-sibling::span[1]")).getText();
        System.out.println("******************* " + billValue);
    }

    @And("^I inquire service list with serviceType is \"([^\"]*)\" from \"([^\"]*)\" api$")
    public void iInquireServiceListWithServiceTypeIsFromFile(String serviceType, String fileName) throws Throwable {
        String oldServiceType;
        String fileContents = readFile(fileName);
        oldServiceType = getValueInLine(fileName, 18, 25, 2);
        fileContents = fileContents.replaceAll(oldServiceType, serviceType);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I inquire provider list with serviceType is \"([^\"]*)\" and serviceCode is \"([^\"]*)\" from \"([^\"]*)\" api$")
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

    @And("^I inquire code topup with providerId is \"([^\"]*)\" from \"([^\"]*)\" api$")
    public void iInquireCodeTopupWithProviderIdIsFromFile(String providerId, String fileName) throws Throwable {
        String oldproviderId;
        String fileContents = readFile(fileName);
        oldproviderId = getValueInLine(fileName, 17, 22, 2);
        fileContents = fileContents.replaceAll(oldproviderId, providerId);
        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }

    @And("^I (topup|pay loan) with \"([^\"]*)\" serviceCode, \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone, \"([^\"]*)\" topupPlanCode from \"([^\"]*)\" api$")
    public void iTopupTheAboveBillFromFile(String type, String serCode, String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String topupPlanCode,String fileName) throws Throwable {
        String oldRequestId,oldServiceCode, oldProviderId, oldServiceType, oldCustomerCode, oldUserName, oldAccountNumber, oldMerchantId, oldAmount, oldPhone,oldtopupPlanCode;
        String fileContents = readFile(fileName);
        switch (type){
            default:
            oldRequestId = getValueInLine(fileName,16,19,1);
            oldServiceCode = getValueInLine(fileName,18,25,3);
            oldProviderId = getValueInLine(fileName, 19, 22, 5);
            oldServiceType = getValueInLine(fileName, 20, 28, 6);
            oldCustomerCode = getValueInLine(fileName, 21, 34, 7);
            oldUserName = getValueInLine(fileName, 17, 26, 8);
            oldAccountNumber = getValueInLine(fileName, 22, 37, 9);
            oldMerchantId = getValueInLine(fileName, 19, 22, 10);
            oldAmount = getValueInLine(fileName, 15, 21, 11);
            oldPhone = getValueInLine(fileName, 20, 30, 12);
            oldtopupPlanCode = getValueInLine(fileName, 22, 32, 15);

            String newRequestId = UUID.randomUUID().toString();
            fileContents = fileContents.replaceAll(oldRequestId,newRequestId);
            fileContents = fileContents.replaceAll(oldServiceCode,serCode);
            fileContents = fileContents.replaceAll(oldProviderId, proId);
            fileContents = fileContents.replaceAll(oldServiceType, serviceType);
            fileContents = fileContents.replaceAll(oldCustomerCode, customerCode);
            fileContents = fileContents.replaceAll(oldUserName, userName);
            fileContents = fileContents.replaceAll(oldAccountNumber, accountNumber);
            fileContents = fileContents.replaceAll(oldMerchantId, merchantId);
            fileContents = fileContents.replaceAll(oldAmount, amount);
            fileContents = fileContents.replaceAll(oldPhone, phone);
            fileContents = fileContents.replaceAll(oldtopupPlanCode, topupPlanCode);

            waitElement(By.id("body"));
            driver.findElement(By.id("body")).sendKeys(fileContents);
        }

    }

    @And("^I pay all the above bill with with \"([^\"]*)\" serviceCode, \"([^\"]*)\" providerId, \"([^\"]*)\" serviceType, \"([^\"]*)\" customerCode, \"([^\"]*)\" userName, \"([^\"]*)\" accountNumber, \"([^\"]*)\" merchantId, \"([^\"]*)\" amount, \"([^\"]*)\" phone, \"([^\"]*)\" topupPlanCode from \"([^\"]*)\" api$")
    public void iPayAllTheAboveBillWithWithServiceCodeProviderIdServiceTypeCustomerCodeUserNameAccountNumberMerchantIdAmountPhoneTopupPlanCodeFromFile(String serCode, String proId, String serviceType, String customerCode, String userName, String accountNumber, String merchantId, String amount, String phone, String topupPlanCode, String fileName) throws Throwable {
        String oldRequestId,oldServiceCode,oldproviderId, oldserviceType, oldcustomerCode, olduserName, oldaccountNumber, oldmerchantId, oldamount, oldphoneNumber,oldtopupPlanCode, oldlocalBillID, oldbillNo, oldbillSeries, oldbillValue,oldlocalBillID2, oldbillNo2, oldbillSeries2, oldbillValue2;
        String fileContents = readFile(fileName);
        oldRequestId = getValueInLine(fileName,16,19,1);
        oldServiceCode = getValueInLine(fileName,18,21,3);
        oldproviderId = getValueInLine(fileName, 19, 22, 5);
        oldserviceType = getValueInLine(fileName, 20, 28, 6);
        oldcustomerCode = getValueInLine(fileName, 21, 34, 7);
        olduserName = getValueInLine(fileName, 17, 26, 8);
        oldaccountNumber = getValueInLine(fileName, 22, 37, 9);
        oldmerchantId = getValueInLine(fileName, 19, 22, 10);
        oldamount = getValueInLine(fileName,15,21 , 11);
        oldphoneNumber = getValueInLine(fileName,20 ,30, 12);
        oldtopupPlanCode = getValueInLine(fileName, 22, 32, 15);
        oldlocalBillID = getValueInLine(fileName,23,31 , 18);
        oldbillNo = getValueInLine(fileName, 18,23, 19);
        oldbillSeries = getValueInLine(fileName,22,28 , 20);
        oldbillValue = getValueInLine(fileName, 21,29, 21);
        oldlocalBillID2 = getValueInLine(fileName,23,31 , 26);
        oldbillNo2 = getValueInLine(fileName, 18,23, 27);
        oldbillSeries2 = getValueInLine(fileName,22,28 , 28);
        oldbillValue2 = getValueInLine(fileName, 21,29, 29);

        String newRequestId = UUID.randomUUID().toString();
        fileContents = fileContents.replaceAll(oldRequestId,newRequestId);
        fileContents = fileContents.replaceAll(oldServiceCode, serCode);
        fileContents = fileContents.replaceAll(oldproviderId, proId);
        fileContents = fileContents.replaceAll(oldserviceType, serviceType);
        fileContents = fileContents.replaceAll(oldcustomerCode, customerCode);
        fileContents = fileContents.replaceAll(olduserName, userName);
        fileContents = fileContents.replaceAll(oldaccountNumber, accountNumber);
        fileContents = fileContents.replaceAll(oldmerchantId, merchantId);
        fileContents = fileContents.replaceAll(oldamount, amount);
        fileContents = fileContents.replaceAll(oldphoneNumber, phone);
        fileContents = fileContents.replaceAll(oldtopupPlanCode,topupPlanCode);
        fileContents = fileContents.replaceAll(oldlocalBillID, localBillID1);
        fileContents = fileContents.replaceAll(oldbillNo,billNo1 );
        fileContents = fileContents.replaceAll(oldbillSeries,billSeries1);
        fileContents = fileContents.replaceAll(oldbillValue, billValue1);
        fileContents = fileContents.replaceAll(oldlocalBillID2, localBillID2);
        fileContents = fileContents.replaceAll(oldbillNo2,billNo2 );
        fileContents = fileContents.replaceAll(oldbillSeries2,billSeries2);
        fileContents = fileContents.replaceAll(oldbillValue2, billValue2);

        waitElement(By.id("body"));
        driver.findElement(By.id("body")).sendKeys(fileContents);
    }
}
