@api @InhouseFT
Feature: Inhouse FT

  @InhouseFT-01
  Scenario: Inhouse FT
    Given I login with "minhson" and "Son112233!"
    When I access into "InhouseFTProduct" on portal at 2 page
    Then I choose version "1.0.0"
    And I access into "createInhouseFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070000217" to "068704070000254" with "5000" amount from "inhouseFT" file
    Then I click "Send" button
    And I verify "resultCode" "000" is displayed in response
    And I logout with "minhson"

  @InhouseFT-02
  Scenario: Inquire Inhouse FT Status
    Given I login with "minhson" and "Son112233!"
    When I access into "InhouseFTProduct" on portal at 2 page
    Then I choose version "1.0.0"
    And I access into "createInhouseFT" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070000217" to "068704070000254" with "5000" amount from "inhouseFT" file
    Then I click "Send" button
    And I verify "resultCode" "000" is displayed in response
    And I get trace number from the above response
    When I access into "API Products"
    When I access into "InhouseFTProduct" on portal at 2 page
    Then I choose version "1.0.0"
    And I access into "inquireInhouseFTStatus" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I transfer from "002704070000217" with the above trace number from "inhouseFTStatus" file
    Then I click "Send" button
    And I verify "message" "SUCCESS" is displayed in response
    And I logout with "minhson"
