Feature: Verify Customer get any help or not with paying for NHS costs online service

  Background: Open the Cost Checker Tool
    Given Open the Cost Checker tool url
    And Click on Analytics Cookies Accept button
    And Click on Start Now button

   Scenario Outline: Customer lives in Ireland and verify that customer get any help or not
    Given Customer is living in Country as <country>
    Then Get outcome and verify customer receive any help or not with NHS cost pass parameter as <claimBenefits> and <taxCredit> and <careHome>

    Examples: 
      | country          | claimBenefits | taxCredit | careHome |
      | Northern_Ireland | NA            | NA        | NA       |

      
   Scenario Outline: Customer lives in England/Wales/Scotland and don't claim any benefits or tax credit and don't live in home care and enter all other fields randomly
    Given Customer is living in Country as <country>
    When I fill the form as GP practice in Scotland or live in Highland and Island
    And Select Country is your dental practise in
    And Enter Date of Birth
    And Enter Details about partner
    And Enter Details about claim as <claimBenefits> and universal credit as <taxCredit>
    And Enter Details about pregnant as <field>
    And Enter Details about injury or illness in armed forces as <war>
    And Enter Details about diabetes as <diabetes> and <country>
    And Enter Details about care home as <permanent> and <careHome>
    And Enter Details about savings or investment
    Then Get outcome and verify customer receive any help or not with NHS cost pass parameter as <claimBenefits> and <taxCredit> and <careHome>

    Examples: 
      | country | claimBenefits | taxCredit | field    | war     | permanent        | careHome | diabetes |
      | England | No            | No        | Yes      | Yes     | No               | No       | Yes      | 
      | England | No            | No        | No       | Yes     | Yes              | No       | Yes      | 
      | Wales   | No            | No        | Yes      | Yes     | No               | No       | Yes      |
      | Wales   | No            | No        | No       | Yes     | Yes              | No       | Yes      |
      | Scotland| No            | No        | No       | No      | No               | No       | NA       |
      | Scotland| No            | No        | Yes      | Yes     | Yes              | No       | NA       |
     
     
   Scenario Outline: Customer lives in England/Wales/Scotland and claim any benefits or tax credit and don't live in home care and enter all other fields randomly
    Given Customer is living in Country as <country>
    When I fill the form as GP practice in Scotland or live in Highland and Island
    And Select Country is your dental practise in
    And Enter Date of Birth
    And Enter Details about partner
    And Enter Details about claim as <claimBenefits> and universal credit as <taxCredit>
    Then Get outcome and verify customer receive any help or not with NHS cost pass parameter as <claimBenefits> and <taxCredit> and <careHome>

    Examples: 
      | country  | claimBenefits | taxCredit | careHome         |
      | Scotland | Yes           | No        | No               |
      | England  | Yes           | No        | No               |
      | Wales    | Yes           | No        | No               |
      | Scotland | Yes           | Yes       | No               |
      | England  | Yes           | Yes       | No               |
      | Wales    | Yes           | Yes       | No               |

  