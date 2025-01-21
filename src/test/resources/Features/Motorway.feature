Feature: Car Valuation Validation
  As a user
  I want to verify car valuations based on registration numbers
  So that I can ensure the data matches the expected output

  Background:
    Given user navigates to the car valuation website

  Scenario Outline: Validate car valuation for a given registration number
    When user enters the registration number "<registration_number>"
    And user clicks on value your car
    Then the car details should match "<expected_make_model>" and "<expected_year>"

    Examples:
      | registration_number | expected_make_model                   | expected_year |
      | SG18 HTN            | Volkswagen Golf SE Navigation TSI EVO | 2018          |
      | AD58 VNF            | BMW 120D M Sport                      | 2008          |
      | BW57 BOF            | Toyota Yaris T2                       | 2008          |
      | KT17 DLX            | Skoda Superb Sportline TDI S-A        | 2017          |