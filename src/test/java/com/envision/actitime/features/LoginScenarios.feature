@Regression
Feature: Login Screen Test
  As a user I want to login to the application

  Background: required browser is opened
      And user launches the url "https://demo.actitime.com/login.do"

   @high
  Scenario Outline: Valid user test
      Given user enters "<username>" as user id
      And user enters "<password>" as password
      When user click on login button
      Then User  should see the home page title as "actiTIME - Enter Time-Track"

      Examples:
        | username  | password |
        | admin     |   manager |
        | trainee   | trainee |


    @low
    Scenario: InValid user test
           Given user enters "admin123" as user id
           And user enters "manager123" as password
           When user click on login button
           Then User should see the error message as "User name or password is wrong"

