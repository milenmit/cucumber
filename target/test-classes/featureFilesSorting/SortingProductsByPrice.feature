@SortingProductsByPrice
Feature: Successful sorting by price

  Background:
    Given User is logged in
    Then Sorting menu is available

  Scenario Outline: Successful sort by ascending and descending order

    And User choose "NAME_A_TO_Z" of products

    Then All products are sorted in "NAME_A_TO_Z" alphabetically order


    Examples:
      | NAME_A_TO_Z |
      | NAME_Z_TO_A |




