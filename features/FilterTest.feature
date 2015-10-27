@Suite
Feature: Filter search results
  As user
  I want to filter the search results
  So that did not have long to find the right product

  Background:
    Given I am on start page "http://pn.com.ua"
    When I select category "Компьютеры"
    And I select subcategory "Игровые приставки"

  Scenario Outline: Check filter by price
    And I set minimum "<min>" and maximum "<max>" prices
    Then I see results matching search parameters "<min>" "<max>"
    Examples:
      | min  | max  |
      | 4000 | 5000 |
      | 2000 | 4000 |

  Scenario: Check filter by manufacturer name
    And I select manufacturer:
      | Ergo      |
      | Microsoft |
    Then the number of products equals to the number next to the manufacturer
    And product names begin with the selected products
      | Ergo      |
      | Microsoft |

  Scenario: Check search by product name
    And I sort product by price
    And I get the name of the cheapest product
    And enter product name into the search field and submit
    Then Search Results Page has 1 product
    And product name is equal to specified name

  @ignore
  Scenario: This scenario will never run
    And because of @wip

