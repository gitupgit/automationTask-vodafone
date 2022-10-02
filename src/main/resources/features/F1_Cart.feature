
Feature:task1 add items to cart

  Scenario: add item to cart by search

    Given  write search keyword as "car accessories"
    When  select item
    Then  click add to cart
    Then  notification img visible

  Scenario: add item to cart by Today deal

    Given  go  to  today'sDeal
    When  select headphone category
    And   select grocery
    And   select discount part
    Then  select item add to cart
    And  check if added items