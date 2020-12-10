@api @OnlineDomesticFTProduct

@OnlineDomesticFTProduct-01
  Feature: Online DomesticFT Product
    Scenario: Napas
      Given I login with "minhson" and "Son112233!"
      When I access into "OnlineDomesticFTProduct" on portal at 2 page
      Then I choose version "1.0.0"
      And I access into "inquireOnlineDomesticFT" api
      And I click on "Try it" tab
      And I input "f6ac5b8aa8e6d566f7e634d0fda4a356" Client Secret
      And I click Generate on transactionId
      And I inquire from "002704070000217" to "068704070000254" with "313000" amount and "970436" bankCode from "inquireOnlineDomesticFT" file
      Then I click "Send" button