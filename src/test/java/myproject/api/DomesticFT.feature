@api @DomesticFT
Feature: Dometic FT

  @DomesticFT-01
  Scenario: Citad
    Given I login with "minhson" and "Son112233!"
    When I access into "DomesticFTService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createDomesticFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I click Generate on transactionId
    And I transfer from "002704070004747" to "01018737883383" with "10000" amount and "92203001" bankId from "createDomesticFT" file
    Then I click "Send" button
    And I verify "responseStatus" "Successful" is displayed in response
    And I logout with "minhson"