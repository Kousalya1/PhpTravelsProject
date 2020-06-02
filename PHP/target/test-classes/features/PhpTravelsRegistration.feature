@Regression
Feature: Amazon Shopping feauture

  Background: 
    Given Launch PHP Travels page and validate page header

  Scenario: Complete the registration form in registration page
    When Click on register button in the header
    Then Enter personal info firstname: "Kousalya" lastname: "K" email id: "kousalyakanikannan@gmail" phone num: ""
    And Enter billing address Company name: "ssa" AddressOne: "address1" AddressTwo: "address2" City: "Chennai" State: "Tamil Nadu" Postcode: "123456" Country: "India"
    And Enter additional required info, How did you find: "Google", Mobile num: "123456789"
    Then Validate password text weak, moderate, strong
    And Enter account security info Password: "1fh$$" Confirm password: "1fh$$"
    And Validate and verify email invalid field
    And Verify mobile number missing error
    Then Enter personal info firstname: "Kousalya" lastname: "K" email id: "kousalyakanikannan@gmail.com" phone num: "123456789"
    And Enter billing address Company name: "ssa" AddressOne: "address1" AddressTwo: "address2" City: "Chennai" State: "Tamil Nadu" Postcode: "123456" Country: "India"
    And Enter additional required info, How did you find: "Google", Mobile num: "123456789"
    And Enter account security info Password: "1fh$$" Confirm password: "1fh$$"
    And Disable join our mailing list option
    And Select the captcha checkbox
    And Click on Register button

  Scenario: Logout and Login Page
    When Enter username, password to login and ensure login success
    Then Click on Logout button and ensure user logged out successfully

  Scenario: Verify all registration values are correct from my details page
    When Enter username, password to login and ensure login success
    Then Navigate to my details page
    And Verify personal info firstname: "Kousalya" lastname: "K" email id: "kousalyakanikannan@gmail.com" phone num: "123456789"
    And Verify billing address Company name: "ssa" AddressOne: "address1" AddressTwo: "address2" City: "Chennai" State: "Tamil Nadu" Postcode: "123456" Country: "India"
    And Verify additional required info, How did you find: "Google", Mobile num: "123456789"
    And Verify job mailing list option is disabled
