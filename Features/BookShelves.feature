Feature: UrbanLadder validation

  Scenario: BookShelves and GiftCards
    Given the user is directed to the UrbanLadder homepage
    And the user searches for "Bookshelves"
    Then the user should be able to see BookShelves products
    And the user must select KidsBookshelves in the dropdown
    Then the user must select the Price range of the products
    And the user must select Exclude Out of Box
    When the user selects the product range from Recommended
    Then the user prints the first three products available
    When the user moves to Living Sub Menu
    Then the user prints all the options available in Living
    And the user scrolls up and clicks on the Gift Card options
    Given the user is navigated to Gift Card page
    Then the user selects Birthday Gift Card
    And the user selects the Price
    Then the user selects the date
    And the user selects Next
    Then the user enters the details of To and From
      | rName    | Jam              |
      | rEmail   | Jam@gmail.com    |
      | rMobile  |       9443644863 |
      | sName    | Thanuj           |
      | sEmail   | thanuj@gmail.com |
      | sMobile  |       9786923316 |
      | sAddress | Trichy           |
      | sPincode |           603103 |
    And the user clicks on the Confirm details
