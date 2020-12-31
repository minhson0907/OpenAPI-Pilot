@api @InhouseFT
Feature: Inhouse FT

  @InhouseFT-01
  Scenario: Inhouse FT
    Given I login with "minhson" and "abc123"
    When I access into "InhouseFTService_Product" on portal at 1 page
    Then I choose version "1.0.0"
    And I access into "createInhouseFT" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I transfer from "002704070016025" to "002704070011069" with "1" amount from "inhouseFT" api
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @InhouseFT-02
  Scenario: Inquire Inhouse FT Status
    Given I login with "minhson" and "abc123"
    When I access into "InhouseFTProduct" on portal at 2 page
    Then I choose version "1.0.0"
    And I access into "createInhouseFT" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I transfer from "002704070016025" to "002704070011069" with "1" amount from "inhouseFT" api
    Then I click "Send" button
    And I verify "resultCode" "00" is displayed in response
    And I verify "resultMessage" "Success" is displayed in response
    And I get trace number from the above response
    When I access into "API Products"
    When I access into "InhouseFTProduct" on portal at 2 page
    Then I choose version "1.0.0"
    And I access into "inquireInhouseFTStatus" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I transfer from "002704070016025" with the above trace number from "inhouseFTStatus" api
    Then I click "Send" button
    And I verify "message" "SUCCESS" is displayed in response
    And I logout with "minhson"
