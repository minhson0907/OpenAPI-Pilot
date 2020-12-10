@api @Ewallet
  Feature: EwalletService

    @Ewallet-01
    Scenario: Create Ewallet
      Given I access into EwalletService on portal at 1 page
      When I access into EwalletService version "2.0.0"
      Then I access into "ewalletlink" api
      And I click on "Try it" tab
      And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
#      Then I click "Send" button
#      And I verify "responseMessage" "Success" is displayed in response