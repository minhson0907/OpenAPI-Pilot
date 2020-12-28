@api @Citad
Feature: Citad

  @Citad-01
  Scenario: Citad with feePayer is receiver
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticCitadFTProduct" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "createDomesticCitadFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070000217" to "068704070000254" with "313000" amount, "89203002" bankId and "receiver" feePayer from "createDomesticCitadFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "transactionFee" "6600" is displayed in response
    And I logout with "minhson"

  @Citad-02
  Scenario: Citad with feePayer is sender
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticCitadFTProduct" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "createDomesticCitadFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070000217" to "068704070000254" with "313000" amount, "89203002" bankId and "sender" feePayer from "createDomesticCitadFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "transactionFee" "6600" is displayed in response
    And I logout with "minhson"

  @Citad-03
  Scenario Outline: Verify citad with fields: fromAccount, toAccount, amount, bankId, feePayer
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticCitadFTProduct" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "createDomesticCitadFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "<fromAccount>" to "<toAccount>" with "<amount>" amount, "<bankId>" bankId and "<feePayer>" feePayer from "createDomesticCitadFT" file
    Then I click "Send" button
    And I verify "resultCode" "<resultCode>" is displayed in response
    And I verify "resultMessage" "<resultMessage>" is displayed in response
    And I logout with "minhson"
    Examples:
      | fromAccount     | toAccount       | amount      | bankId   | feePayer | resultCode | resultMessage                |
      | 123457894101    | 068704070000254 | 1           | 89203002 | receiver | 301228     | fromAccountNumber is invalid |
      | 002704070000217 | 068704070000254 | 1           | 89203002 | receiver | 302001     | transferAmount is invalid    |
      | 002704070000217 | 068704070000254 | 12345678910 | 89203002 | receiver | 301110     | transferAmount is invalid    |
      | 002704070000217 | 068704070000254 | 100000      | 12345678 | receiver | 999990     | toBankId is invalid          |

  @Citad-04
  Scenario Outline: Verify citad with fields: fromAccount, toAccount, amount, bankId, feePayer
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticCitadFTProduct" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "createDomesticCitadFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "<fromAccount>" to "<toAccount>" with "<amount>" amount, "<bankId>" bankId and "<feePayer>" feePayer from "createDomesticCitadFT" file
    Then I click "Send" button
    And I verify "resultCode" "<resultCode>" is displayed in response
    And I verify "resultMessage" "<resultMessage>" is displayed in response
    And I logout with "minhson"
    Examples:
      | fromAccount     | toAccount       | amount      | bankId   | feePayer | resultCode | resultMessage                |
      | 123457894101    | 068704070000254 | 1           | 89203002 | sender   | 301228     | fromAccountNumber is invalid |
      | 002704070000217 | 068704070000254 | 1           | 89203002 | sender   | 00         | Success                      |
      | 002704070000217 | 068704070000254 | 12345678910 | 89203002 | sender   | 301110     | transferAmount is invalid    |
      | 002704070000217 | 068704070000254 | 100000      | 12345678 | sender   | 999990     | toBankId is invalid          |

  @Citad-05
  Scenario: inquireCitadBank
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticCitadFTProduct" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "inquireCitadBank" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire citad bank from "inquireCitadBank" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "branchName" "NAM A BANK CN DONG NAI" is displayed in response
    And I verify "bankId" "75306001" is displayed in response
    And I verify "branchName" "ABBank CN Gia Lai" is displayed in response
    And I verify "bankId" "64323001" is displayed in response
    And I verify "branchName" "BIDV CN TP HCM" is displayed in response
    And I verify "bankId" "79202002" is displayed in response
    And I verify "branchName" "NH Nha Nuoc CN Bac Kan" is displayed in response
    And I verify "bankId" "06101001" is displayed in response
    And I verify "branchName" "SHB CN Vinh Long" is displayed in response
    And I verify "bankId" "86348001" is displayed in response
    And I logout with "minhson"