@api @CustomerOnboard
Feature: Customer Onboard Service

#  @CustomerOnboard-01
#  Scenario: I verify iMoney card is created successfully
#    Given I login with "minhson" and "abc123"
#    When I access into "CustomerOnboardService_Product" on portal at 1 page
#    And I choose version "1.0.0"
#    Then I access into "createImoneyRegistration" api
#    And I click on "Try it" tab
#    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
#    And I create iMoney card with "QC HDBANK" name and "qcteam@hdbank.com.vn" email from "createImoneyRegistration" api
#    Then I click "Send" button
#    And I verify "resultMessage" "Success" is displayed in response
#    And I logout with "minhson"

  @CustomerOnboard-02
  Scenario: I verify card information is inquired after creating successfully
    Given I login with "minhson" and "abc123"
    When I access into "CustomerOnboardService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createImoneyRegistration" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I create iMoney card with "QC HDBANK" name and "qcteam@hdbank.com.vn" email from "createImoneyRegistration" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I get cardNumber from the above request
    Then I access into "API Products"
    When I access into "CustomerOnboardService" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "inquireImoneyInfo" api
    And I click on "Try it" tab
    And I input "296a6063c99cf8a01ec1232546f91512" Client Secret
    And I inquire with the above cardNumber from "inquireImoneyInfo" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "fullName" "QC HDBANK" is displayed in response
    And I verify "email" "qcteam@hdbank.com.vn" is displayed in response
    And I logout with "minhson"

  @CustomerOnboard-03
  Scenario Outline: I verify debit & credit card can not inquire
    Given I login with "minhson" and "abc123"
    When I access into "CustomerOnboardService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createImoneyRegistration" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire with "<cardNum>" cardNumber from "inquireImoneyInfo" api
    Then I click "Send" button
    And I verify "resultMessage" "<msg>" is displayed in response
    And I logout with "minhson"
    Examples:
      | cardNum      | msg                   |
      | 217891350150 | Card number not exist |
      | 800001220726 | Card number not exist |

  @CustomerOnboard-04
  Scenario: I verify iMoney card info is inquired successfully
    Given I login with "minhson" and "abc123"
    When I access into "CustomerOnboardService_Product" on portal at 1 page
    And I choose version "1.0.0"
    Then I access into "createImoneyRegistration" api
    And I click on "Try it" tab
    And I input "22f20a7ccf140a86008f120bf1fb27c8" Client Secret
    And I inquire with "510773533440" cardNumber from "inquireImoneyInfo" api
    Then I click "Send" button
    And I verify "resultMessage" "Success" is displayed in response
    And I verify "fullName" "QC TEAM" is displayed in response
    And I verify "email" "test@hdbank.com.vn" is displayed in response
    And I verify "phoneNumber" "0983234164" is displayed in response
    And I verify "cardNo" "510773533440" is displayed in response
    And I logout with "minhson"

