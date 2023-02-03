@SortingProductsByName
Feature: Successful sorting by price

  Background:
    Given User is logged in
    Then Sorting menu is available

  Scenario Outline: Successful sort by ascending and descending order

    And User choose "PRICE_LOW_TO_HIGH" of products

    Then All products are sorted in "PRICE_LOW_TO_HIGH" price order


    Examples:
      | PRICE_LOW_TO_HIGH |
      | PRICE_HIGH_TO_LOW |


