@api @Billing
Feature: Billing Service

  @Billing-01
  Scenario Outline: Inquire Bill (ELECTRIC,VNTOPUP,WATER,LOAN,INTERNET,CAP,PHONE)
    Given I login with "minhson" and "abc123"
    When I access into "BillingService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireBill" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" api
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "vatValue" "0" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode    | userName    | accountNumber   | merchantId | amount | phone      | topupPlanCode |
      | billing     | EVN           | ELECTRIC    | PE10000166666   | minhson0907 | 002704070016025 | EVN        | 1000   | 0983234167 |               |
      | topup       | VNTOPUP-VNPAY | VNTOPUP     | ED017747416     | minhson0907 | 002704070016025 | VNPAY      | 100000 | 0983234167 | TPVNPAY100    |
      | billing     | 199009@000010 | WATER       | 15011500647     | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |
      | billing     | 109800@000006 | LOAN        | 201811070002426 | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |
      | billing     | 190008@000002 | INTERNET    | HCM008806947    | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |
      | billing     | 200000@000002 | CAP         | 95506/DNA       | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |
      | billing     | 109100@000001 | PHONE       | 0856034243      | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |


  @Billing-02
  Scenario: inquireServiceList
    Given I login with "minhson" and "abc123"
    When I access into "BillingService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireServiceList" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire service list with serviceType is "BILLING" from "inquireServiceList" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "serviceCode" "WATER" is displayed in response
    And I verify "serviceCode" "ELECTRIC" is displayed in response
    And I verify "serviceCode" "CAP" is displayed in response
    And I verify "serviceCode" "INTERNET" is displayed in response
    And I verify "serviceCode" "PHONE" is displayed in response
    And I logout with "minhson"

  @Billing-03
  Scenario Outline: inquireProviderList
    Given I login with "minhson" and "abc123"
    When I access into "BillingService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireProviderList" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire provider list with serviceType is "<serviceType>" and serviceCode is "<serviceCode>" from "inquireProviderList" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "providerName" "<name>" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceType | serviceCode | name                                                 |
      | BILLING     | WATER       | Công Ty Cổ Phần Cấp Nước Nhà Bè                      |
      | BILLING     | ELECTRIC    | Công ty Điện lực TP Hồ Chí Minh                      |
      | BILLING     | CAP         | SCTV Hồ Chí Minh                                     |
      | BILLING     | INTERNET    | FPT- Thanh toán cước dịch vụ Internet ADSL           |
      | BILLING     | PHONE       | Viettel - Thanh toán cước điện thoại di động trả sau |

  @Billing-04
  Scenario: inquireTopupCodes
    Given I login with "minhson" and "abc123"
    When I access into "BillingService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireTopupCodes" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire code topup with providerId is "VNPAY" from "inquireTopupCodes" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "topupCode" "TPVNPAY10" is displayed in response
    And I verify "topupCode" "TPVNPAY20" is displayed in response
    And I verify "topupCode" "TPVNPAY30" is displayed in response
    And I verify "topupCode" "TPVNPAY50" is displayed in response
    And I verify "topupCode" "TPVNPAY100" is displayed in response
    And I verify "topupCode" "TPVNPAY200" is displayed in response
    And I verify "topupCode" "TPVNPAY300" is displayed in response
    And I verify "topupCode" "TPVNPAY500" is displayed in response
    And I logout with "minhson"

#  @Billing-05
#  Scenario Outline: Payment Bill - Pay One
#    Given I login with "minhson" and "abc123"
#    When I access into "BillingService_Product" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "inquireBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" api
#    Then I click "Send" button
#    And I verify "resultMessage" "Success" is displayed in response
#    And I get localBillID from the above request
#    And I get billNo from the above request
#    And I get billSeries from the above request
#    And I get billValue from the above request
#    When I access into "API Products"
#    And I access into "BillingService" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "createPaymentBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I pay the above bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createPaymentBill" api
#    Then I click "Send" button
#    And I verify "resultCode" "00000" is displayed in response
#    And I verify "resultMessage" "Success" is displayed in response
#    And I logout with "minhson"
#    Examples:
#      | serviceCode | providerId    | serviceType | customerCode | userName    | accountNumber   | merchantId | amount | phone      | topupPlanCode |
#      | billing     | 199009@000010 | WATER       | 15011500647  | minhson0907 | 002704070016025 | VNPAY      | 1000   | 0983234167 |               |
#
#  @Billing-06
#  Scenario Outline: Payment Bill - Pay All
#    Given I login with "minhson" and "abc123"
#    When I access into "BillingService_Product" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "inquireBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" api
#    Then I click "Send" button
#    And I verify "resultMessage" "Success" is displayed in response
#    And I get localBillID1 from the above request
#    And I get billNo1 from the above request
#    And I get billSeries1 from the above request
#    And I get billValue1 from the above request
#    And I get localBillID2 from the above request
#    And I get billNo2 from the above request
#    And I get billSeries2 from the above request
#    And I get billValue2 from the above request
#    When I access into "API Products"
#    And I access into "BillingService" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "createPaymentBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I pay all the above bill with with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createPaymentBillPayAll" api
#    Then I click "Send" button
#    And I verify "resultMessage" "Success" is displayed in response
#    And I logout with "minhson"
#    Examples:
#      | serviceCode | providerId | serviceType | customerCode  | userName    | accountNumber   | merchantId | amount | phone      | topupPlanCode |
#      | billing     | EVN        | ELECTRIC    | PE10000166666 | minhson0907 | 002704070016025 | EVN        | 1000   | 0983234167 |               |
#
#  @Billing-07
#  Scenario Outline: Topup mobile
#    Given I login with "minhson" and "abc123"
#    When I access into "BillingService_Product" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "createPaymentBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I topup with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createTopup" api
#    Then I click "Send" button
#    And I verify "resultCode" "00000" is displayed in response
#    And I verify "resultMessage" "Success" is displayed in response
#    And I logout with "minhson"
#    Examples:
#      | serviceCode | providerId    | serviceType | customerCode | userName    | accountNumber   | merchantId | amount | phone      | topupPlanCode |
#      | topup       | VNTOPUP-VNPAY | VNTOPUP     | 9022060      | minhson0907 | 002704070016025 | VNPAY      | 10000  | 0983234167 | TPVNPAY10     |
#
#  @Billing-08
#  Scenario Outline: Payment loan
#    Given I login with "minhson" and "abc123"
#    When I access into "BillingService_Product" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "createPaymentBill" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I pay loan with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createTopup" api
#    Then I click "Send" button
#    And I verify "resultCode" "00000" is displayed in response
#    And I verify "resultMessage" "Success" is displayed in response
#    And I logout with "minhson"
#    Examples:
#      | serviceCode | providerId    | serviceType | customerCode     | userName  | accountNumber   | merchantId | amount | phone      | topupPlanCode |
#      | billing     | 109800@000006 | LOAN        | 20180723-9956732 | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |

