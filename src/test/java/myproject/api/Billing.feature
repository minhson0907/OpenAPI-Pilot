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
    And I inquire the bill with "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone from "inquireBilling" file
    Then I click "Send" button
    And I verify "resultMessage" "SUCCESS" is displayed in response
    And I logout with "minhson"
    Examples:
      | providerId | serviceType | customerCode  | userName  | accountNumber   | merchantId | amount | phone      |
#      | EVN        | ELECTRIC    | PA22050607100 | chungnq86 | 068704070012891 | EVNNPC     | 1000   | 0983234166 |
      | 190008@000002 | INTERNET    | ADSL_HCM      | chungnq86 | 068704070012891 | VNPAY      |   1000   | 0983234166 |
#      | 200000@000002 | CAP         | 1616221       | chungnq86 | 068704070012891 | VNPAY      |   1000   | 0983234166 |
#      | 109800@000003 | PHONE       | 0462511253    | chungnq86 | 068704070012891 | VNPAY      |  1000   | 0983234166 |
#      | 109800@000001 | PHONE       | 0982816517    | chungnq86 | 068704070012891 | VNPAY      |    1000   | 0983234166 |
#      | 199032@000010 | WATER       | 9022060       | chungnq86 | 068704070012891 | VNPAY      |     1000   | 0983234166 |

  @Billing-02
  Scenario Outline: Create Payment Bill
    Given I login with "minhson" and "Son112233!"
    When I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire the bill with "<providerId>" providerId, "<serviceType>" serviceType, "<customerCode>" customerCode, "<userName>" userName, "<accountNumber>" accountNumber, "<merchantId>" merchantId, "<amount>" amount, "<phone>" phone from "inquireBilling" file
    Then I click "Send" button
    And I verify "resultMessage" "SUCCESS" is displayed in response
    And I get providerId from the above request
    And I get serviceType from the above request
#    And I get customerCode from the above request
#    And I get userName from the above request
#    And I get accountNumber from the above request
#    And I get merchantId from the above request
#    And I get amount from the above request
#    And I get phoneNumber from the above request
#    And I get localBillID from the above request
#    And I get billNo from the above request
#    And I get billSeries from the above request
#    And I get billDetail from the above request
#    And I get billValue from the above request
    When I access into "API Products"
    And I access into "BillingService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createPaymentBill" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I pay the above bill from "createPaymentBill" file
    Then I click "Send" button
    And I verify "responseStatus" "Successful" is displayed in response
    Examples:
      | providerId | serviceType | customerCode  | userName  | accountNumber   | merchantId | amount | phone      |
#      | EVN        | ELECTRIC    | PA22050607100 | chungnq86 | 068704070012891 | EVNNPC     | 1000   | 0983234166 |
      | 190008@000002 | INTERNET    | ADSL_HCM      | chungnq86 | 068704070012891 | VNPAY      |   1000   | 0983234166 |

