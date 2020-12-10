@api @CustomerOnboard
Feature: Customer Onboard Service

  @CustomerOnboard-01
  Scenario: I verify iMoney card is created successfully
    Given I login with "minhson" and "Son112233!"
    When I access into "CustomerOnboardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createImoneyRegistration" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I create iMoney card with "QC HDBANK" name from "createImoneyRegistration" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I logout with "minhson"

  @CustomerOnboard-02
  Scenario: I verify card information is inquired successfully
    Given I login with "minhson" and "Son112233!"
    When I access into "CustomerOnboardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createImoneyRegistration" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I create iMoney card with "QC HDBANK" name from "createImoneyRegistration" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I get cardNumber from the above request
    Then I access into "API Products"
    When I access into "CustomerOnboardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireImoneyInfo" api
    And I click on "Try it" tab
    And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
    And I inquire with the above cardNumber from "inquireImoneyInfo" file
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "fullName" "QC HDBANK" is displayed in response
    And I logout with "minhson"

