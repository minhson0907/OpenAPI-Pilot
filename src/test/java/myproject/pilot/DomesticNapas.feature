@api @Napas
Feature: Napas

  @Napas-01
  Scenario: inquire Napas
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireDomesticNapasFT" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire to "249515269" with "970406" cardCode from "inquireDomesticNapasFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "toAccountName" "NGUYEN VAN NAPAS" is displayed in response
    And I logout with "minhson"

  @Napas-02
  Scenario: Napas by account number
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createDomesticNapasFT" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I transfer from "002704070016025" to "249515269" with "1" amount and "970406" cardCode from "createDomesticNapasFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Napas-03
  Scenario: Napas by card number
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createDomesticNapasFT" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I transfer from "002704070016025" to "9704366814567141015" with "1" amount and "" cardCode from "createDomesticNapasFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @Napas-04
  Scenario: Napas
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireNapasBank" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire citad bank from "inquireNapasBank" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "cardCode" "970415" is displayed in response
    And I verify "bankName" "VIETINBANK" is displayed in response
    And I verify "cardCode" "970436" is displayed in response
    And I verify "bankName" "VIETCOMBANK" is displayed in response
    And I verify "cardCode" "970414" is displayed in response
    And I verify "bankName" "OCEANBANK" is displayed in response
    And I verify "cardCode" "970406" is displayed in response
    And I verify "bankName" "DONGA BANK" is displayed in response
    And I logout with "minhson"
