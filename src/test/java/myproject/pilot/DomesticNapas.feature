@api @Napas
Feature: Napas

  @Napas-00
  Scenario: Napas
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireDomesticNapasFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire to "0129837294" with "970406" cardCode from "inquireDomesticNapasFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "toAccountName" "NGUYEN VAN NAPAS" is displayed in response
    And I logout with "minhson"

  @Napas-01
  Scenario: Napas
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createDomesticNapasFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070004747" to "0129837294" with "10000" amount and "970406" cardCode from "createDomesticNapasFT" file
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
#    And I verify "transactionFee" "8250" is displayed in response
    And I logout with "minhson"

  @Napas-02
  Scenario: Napas
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticNapasFTProduct" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireNapasBank" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
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
