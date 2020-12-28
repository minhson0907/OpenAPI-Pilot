@api @Card
Feature: Card Service

  @Card-01
  Scenario: Inquire VJA Card Information
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJACardInfo" api
    And I click on "Try it" tab
    And I input "aabb8010-2ce1-4fb9-90e6-a182b3a2c8c8" into Authorization
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
    And I input "a7ef291c-f7ae-41cd-9c9a-8805ffcb48b9" into Authorization
    And I send a request otp with "513838773150" cardNumber, "20000" amount and "0983234167" userName from "createVJAPaymentRequest" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    Then I access into "API Products"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createVJAPaymentConfirm" api
    And I click on "Try it" tab
    And I input "a7ef291c-f7ae-41cd-9c9a-8805ffcb48b9" into Authorization
    Then I pay VJA ticket with the above otp, "513838773150" cardNumber, "20000" amount and "0983234167" userName from "createVJAPaymentConfirm" file
    And I wait for "60" seconds
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Card-03
  Scenario: I verify VJA Payment History is inquired successfully
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJAPaymentHis" api
    And I click on "Try it" tab
    And I input "aabb8010-2ce1-4fb9-90e6-a182b3a2c8c8" into Authorization
    And I inquire VJA payment history with "0983234167" user name, "513838773150" card number from "inquireVJAPaymentHis" file within a month
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "debitor" "513838773150" is displayed in response
    And I verify "transType" "PAYMENT" is displayed in response
    And I logout with "minhson"

  @Card-04
  Scenario Outline: I verify VJA Payment History is inquired unsuccessful with iMoney, debit, credit
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireVJAPaymentHis" api
    And I click on "Try it" tab
    And I input "aabb8010-2ce1-4fb9-90e6-a182b3a2c8c8" into Authorization
    And I inquire VJA payment history with "<userName>" user name, "<cardNumber>" card number from "inquireVJAPaymentHis" file within a month
    Then I click "Send" button
    And I verify "resultMessage" "<msg>" is displayed in response
    And I logout with "minhson"
    Examples:
      | userName   | cardNumber   | msg                    |
      | 0982627415 | 513294993900 | Card number is invalid |
      | 0982627415 | 21191519990  | Card number is invalid |
      | 0982627415 | 31007295490  | Card number is invalid |

  @Card-05
  Scenario Outline: I pay credit card (318443496960/9704377310093028 - 001-Local VCCS Credit Silver Main Card)
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "creditPayment" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I top up from "<fromAccount>" to "<toAccount>" with "<amount>" amount from "creditPayment" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"
    Examples:
      | fromAccount     | toAccount        | amount |
      | 002704070001867 | 318443496960     | 30000  |
      | 002704070001867 | 9704377310093028 | 30000  |

  @Card-06
  Scenario Outline: I pay prepaid card (513838773150/9704379855682918 - 001-Local Prepaid Default Active Card)
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "creditPayment" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I top up from "<fromAccount>" to "<toAccount>" with "<amount>" amount from "creditPayment" file
    Then I click "Send" button
    And I verify "resultCode" "3035" is displayed in response
    And I verify "resultMessage" "Product card type invalid" is displayed in response
    And I logout with "minhson"
    Examples:
      | fromAccount     | toAccount        | amount |
      | 002704070001867 | 513838773150     | 30000  |
      | 002704070001867 | 9704379855682918 | 30000  |

  @Card-07
  Scenario Outline: I pay debit card (229618818160/5321371111433682 - 001-MC Debit VJA Reward Main Card)
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "creditPayment" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I top up from "<fromAccount>" to "<toAccount>" with "<amount>" amount from "creditPayment" file
    Then I click "Send" button
    And I verify "resultCode" "3035" is displayed in response
    And I verify "resultMessage" "Product card type invalid" is displayed in response
    And I logout with "minhson"
    Examples:
      | fromAccount     | toAccount        | amount |
      | 002704070001867 | 229618818160     | 30000  |
      | 002704070001867 | 5321371111433682 | 30000  |

  @Card-08
  Scenario Outline: Verify inquireListCreditCard with cif = credit/debit/prepaid
    Given I login with "minhson" and "Son112233!"
    When I access into "CardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireListCreditCard" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    Then I inquire credit card list with "<cif>" clientIdentifier from "inquireListCreditCard" file
    Then I click "Send" button
    And I verify "resultMessage" "<msg>" is displayed in response
    And I logout with "minhson"
    Examples:
      | cif      | msg           |
      | 00271690 | Success       |
      | 00011505 | No data found |
      | 00004693 | No data found |
