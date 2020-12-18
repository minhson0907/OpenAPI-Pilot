@api @Billing
Feature: Billing Service

  @Billing-01
  Scenario Outline: Inquire Bill
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode     | userName  | accountNumber   | merchantId | amount | phone      | topupPlanCode |
      | billing     | EVN           | ELECTRIC    | PA25SL0061320    | chungnq86  | 068704070012891 | EVNNPC     | 1000   | 0983234166 |               |
#      | billing     | 190008@000002 | INTERNET    | ADSL_HCM         | chungnq86  | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 200000@000002 | CAP         | 1616221          | chungnq86  | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 109800@000003 | PHONE       | 0462511253       | chungnq86  | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 109800@000001 | PHONE       | 0982816517       | chungnq86  | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 199032@000010 | WATER       | 9022060          | chungnq86  | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 109800@000006 | LOAN        | 20180723-9956732 | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | topup       | VNTOPUP-VNPAY | VNTOPUP     | 9022060      | tranducnam | 186704070000673 | VNPAY      | 100000 | 0965765473 | TPVNPAY100    |

  @Billing-02
  Scenario Outline: Payment Bill - Pay One
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I get localBillID from the above request
    And I get billNo from the above request
    And I get billSeries from the above request
    And I get billValue from the above request
    When I access into "API Products"
    And I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createPaymentBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I pay the above bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createPaymentBill" file
    Then I click "Send" button
    And I verify "resultCode" "00000" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode | userName  | accountNumber   | merchantId | amount | phone      | topupPlanCode |
#      | billing     | EVN           | ELECTRIC    | PA22050625824 | chungnq86 | 068704070012891 | EVNNPC     | 1000   | 0983234166 |               |
#      | billing     | 199032@000010 | WATER       | 9022060       | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 190008@000002 | INTERNET    | ADSL_HCM      | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
#      | billing     | 109800@000003 | PHONE       | 0462511252    | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |
      | billing     | 200000@000002 | CAP         | 1616226      | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |

  @Billing-03
  Scenario Outline: Payment Bill - Pay All
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire the bill with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "inquireBilling" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I get localBillID1 from the above request
    And I get billNo1 from the above request
    And I get billSeries1 from the above request
    And I get billValue1 from the above request
    And I get localBillID2 from the above request
    And I get billNo2 from the above request
    And I get billSeries2 from the above request
    And I get billValue2 from the above request
    When I access into "API Products"
    And I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createPaymentBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I pay all the above bill with with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createPaymentBillPayAll" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode  | userName  | accountNumber   | merchantId | amount | phone      | topupPlanCode |
      | billing     | EVN           | ELECTRIC    | PA25SL0056456 | chungnq86 | 068704070012891 | EVNNPC     | 1000   | 0983234166 |               |
#      | billing     | 200000@000002 | CAP         | 1616226       | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |

  @Billing-04
  Scenario: inquireServiceList
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireServiceList" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire service list with serviceType is "BILLING" from "inquireServiceList" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "serviceCode" "WATER" is displayed in response
    And I verify "serviceCode" "ELECTRIC" is displayed in response
    And I verify "serviceCode" "CAP" is displayed in response
    And I verify "serviceCode" "INTERNET" is displayed in response
    And I verify "serviceCode" "PHONE" is displayed in response
    And I logout with "minhson"

  @Billing-05
  Scenario Outline: inquireProviderList
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireProviderList" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire provider list with serviceType is "<serviceType>" and serviceCode is "<serviceCode>" from "inquireProviderList" file
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

  @Billing-06
  Scenario: inquireTopupCodes
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireTopupCodes" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire code topup with providerId is "VNPAY" from "inquireTopupCodes" file
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

  @Billing-07
  Scenario Outline: Topup mobile
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createPaymentBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I topup with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createTopup" file
    Then I click "Send" button
    And I verify "resultCode" "00000" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode | userName   | accountNumber   | merchantId | amount | phone      | topupPlanCode |
      | topup       | VNTOPUP-VNPAY | VNTOPUP     | 9022060      | tranducnam | 186704070000673 | VNPAY      | 100000 | 0965765473 | TPVNPAY100    |

  @Billing-08
  Scenario Outline: Payment loan
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createPaymentBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I pay loan with "<serviceCode>" serviceCode, "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone, "<topupPlanCode>" topupPlanCode from "createTopup" file
    Then I click "Send" button
    And I verify "resultCode" "00000" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | serviceCode | providerId    | serviceType | customerCode     | userName  | accountNumber   | merchantId | amount | phone      | topupPlanCode |
      | billing     | 109800@000006 | LOAN        | 20180723-9956732 | chungnq86 | 068704070012891 | VNPAY      | 1000   | 0983234166 |               |

