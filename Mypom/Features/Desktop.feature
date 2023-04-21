#Author: sachinjoshi.cr@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Desktops testing
  This feature contains the acceptance criterions for testing of the Desktops tab

  @desktops
  Scenario: I want to be able view all desktops
    Given User opens opencart 
    Then Desktops tab should be displayed
    When User clicks on Show all Desktops
    Then All desktops are displayed
  
  @desktops
  	Scenario Outline: I want to be able click on Desktop and go to desktopproduct
  	Given User opens opencart
  	Then Desktops tab should be displayed
  	When User clicks on Show all Desktops
  	Then User clicks "<desktopname>"
  	And  User can see the product opened "<desktopname>"
    Examples: 
      | desktopname     | 
      | Apple Cinema    | 
      |	HP LP3065				|
