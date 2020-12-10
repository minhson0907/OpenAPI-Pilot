@api @Card
Feature: Card Serive

  @Card-01
  Scenario: I verify VJA Payment History is inquired successfully
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJAPaymentHis" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    And I inquire VJA payment history with "9704379778511517" card number from "inquireVJAPaymentHis" file within a month
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Card-02
  Scenario: Inquire VJA Card Information
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    Then I access into "inquireVJACardInfo" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    And I inquire VJA card information with "510354531860" card number from "inquireVJACardInfo" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Card-03
  Scenario: Credit Payment
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    Then I access into "creditPayment" api
    And I click on "Try it" tab
    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
    And I top up from "002704070001867" to "4987676866354992" with "10000" amount from "creditPayment" file
    Then I click "Send" button
    And I verify "responseMessage" "Success" is displayed in response
    And I logout with "minhson"

#  @Card-04
#  Scenario: Create VJA Payment Request
#    Given I access into "CardService" on portal at 1 page
#    Then I access into "createVJAPaymentRequest" api
#    And I click on "Try it" tab
#    And I click Generate on "transactionId"
##      And I click Generate on "Authorization"
#    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
#    And I click Generate for request body
#    Then I click "Send" button
#    And I verify "responseStatus" "Successful" is displayed in response

#  @Card-05
#  Scenario: Create VJA Payment Confirm
#    Given I access into "CardService" on portal at 1 page
#    Then I access into "createVJAPaymentConfirm" api
#    And I click on "Try it" tab
#    And I click Generate on "transactionId"
##      And I click Generate on "Authorization"
#    And I input "d8a5c6ec-df96-4210-8828-f23343d9a0e0" into Authorization
#    And I click Generate for request body
#    Then I click "Send" button
#    And I verify "responseStatus" "Successful" is displayed in response