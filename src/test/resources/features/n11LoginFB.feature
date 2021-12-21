Feature: Login n11.com with facebook
@facebook
  Scenario:users login to n11 with facebook
    Given user launch browser and open the n11 homepage
    And   user click to sign in button
    When  user login the n11 valid credentials with facebook
    Then  user verify the logged in successfully
