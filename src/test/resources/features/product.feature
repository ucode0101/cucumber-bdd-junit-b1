Feature: Product feature

  @product
  Scenario: verify add new product in api
    When User provides name as "Apple" and price 3.99 in body sends post request to "https://fruitshop2-predic8.azurewebsites.net/shop/v2/products"
    Then Product should be created
    Then Status code should 201
    Then Response body should contain newly added product
