Feature: POST rest requests from CSV file

  Scenario: Generate CSV file
    Given new CSV file is opened
    When data entry is started
    And I add id
    And I add firstName
    And I add lastName
    And I add eMail
    And I add companyId
    Then CSV file is generated