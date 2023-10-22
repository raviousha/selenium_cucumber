Feature: Sauce Demo Apps

 Scenario: Login as valid username
  Given user should be open https://www.saucedemo.com/ in web browser
  When user input valid username
   And user input valid password
   And user click button Login
  Then home page should be displayed

 Scenario: Login as invalid credentials
  Given user should be open https://www.saucedemo.com/ in web browser
  When user input invalid username
   And user input valid password
   And user click button Login
  Then error message should be displayed

 Scenario: Login as with empty username field
  Given user should be open https://www.saucedemo.com/ in web browser
   And user click button Login
  Then empty username message should be displayed

 Scenario: Login as with empty password field
  Given user should be open https://www.saucedemo.com/ in web browser
  When user input valid username
   And user click button Login
  Then empty password message should be displayed

 Scenario: Logout
  Given user login in https://www.saucedemo.com/
  When user click side menu button
   And user click logout
  Then login page should be displayed

 Scenario: Adding product to cart
  Given user login in https://www.saucedemo.com/
  When user click button Add to Cart in first list product
   And user click icon cart
  Then Your Item should be in cart

 Scenario: Checkout item in cart
  Given user login in https://www.saucedemo.com/
  When user click button Add to Cart in first list product
  And user click icon cart
  And user click checkout button
  Then Your Information page should be displayed

 Scenario: Removing product from cart
  Given user login in https://www.saucedemo.com/
  When user click button Add to Cart in first list product
  And user click icon cart
  And user click button remove in first list product
  Then product should be removed from cart

 Scenario: Input Information
  Given user login in https://www.saucedemo.com/
  When user click icon cart
   And user click checkout button
   And user input first name
   And user input last name
   And user input postal code
   And user click continue button
  Then checkout overview page should be displayed

