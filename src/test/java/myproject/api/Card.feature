@api @Card
Feature: Card Service

  @Card-01
  Scenario: Inquire VJA Card Information
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJACardInfo" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    And I inquire VJA card information with "513838773150" card number and "0983234167" user name from "inquireVJACardInfo" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "userName" "0983234167" is displayed in response
    And I verify "fullName" "VO SON" is displayed in response
    And I verify "email" "sonvm3@hdbank.com.vn" is displayed in response
    And I verify "phone" "0983234167" is displayed in response
    And I logout with "minhson"

  @Card-02
  Scenario: I pay VJA ticket (request otp and payment)
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createVJAPaymentRequest" api
    And I click on "Try it" tab
    And I input "d8a5c6eca-df96-4210-8828-f23343d9a0e0" into Authorization
    And I send a request otp with "513838773150" cardNumber, "20000" amount and "0983234167" userName from "createVJAPaymentRequest" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    Then I access into "API Products"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createVJAPaymentConfirm" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    Then I pay VJA ticket with the above otp, "513838773150" cardNumber, "20000" amount and "0983234167" userName from "createVJAPaymentConfirm" file
    And I wait for "60" seconds
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response

  @Card-03
  Scenario: I verify VJA Payment History is inquired successfully
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJAPaymentHis" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    And I inquire VJA payment history with "513838773150" card number from "inquireVJAPaymentHis" file within a month
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "debitor" "513838773150" is displayed in response
    And I verify "transType" "PAYMENT" is displayed in response
    And I logout with "minhson"

  @Card-04
  Scenario: I pay credit card
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "creditPayment" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I top up from "002704070001867" to "318443496960" with "30000" amount from "creditPayment" file
    Then I click "Send" button
    And I verify "responseMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Card-05
  Scenario: inquireListCreditCard
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireListCreditCard" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    Then I inquire credit card list with "00271690" clientIdentifier from "inquireListCreditCard" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
