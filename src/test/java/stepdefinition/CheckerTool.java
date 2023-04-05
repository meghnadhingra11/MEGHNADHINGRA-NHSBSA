package stepdefinition;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ConditionsPage;

public class CheckerTool {

	ConditionsPage conditionPage = new ConditionsPage();

	@Given("Open the Cost Checker tool url")
	public void open_the_cost_checker_tool_url() {
		conditionPage.openUrl();
	}

	@Given("Click on Analytics Cookies Accept button")
	public void click_on_analytics_cookies_accept_button() {
		conditionPage.clickAnalyticsCookies();
	}

	@Given("Click on Start Now button")
	public void click_on_start_now_button() {
		conditionPage.startNow();
	}

	@Given("^Customer is living in Country as (.*)$")
	public void customer_is_living_in_country_as_country(String country) {
		conditionPage.clickCountryRadioButton(country);
	}

	@When("I fill the form as GP practice in Scotland or live in Highland and Island")
	public void i_fill_the_form_as_gp_practice_in_scotland_or_live_in_highland_and_island() {
		conditionPage.selectGPPractiseOrHighLand();
	}
	
	@When("Select Country is your dental practise in")
	public void select_country_is_your_dental_practise_in() {
		conditionPage.selectDentalPractiseCountry();
	}

	@When("Enter Date of Birth")
	public void enter_date_of_birth() {
		conditionPage.enterDOB();
	}

	@When("Enter Details about partner")
	public void enter_details_about_partner() {
        conditionPage.clickLivePartnerRadioButton();
	}

	@When("^Enter Details about claim as (.*) and universal credit as (.*)$")
	public void enter_details_about_claim_as_claimBenefits_and_universal_credit_as_taxCredit(String claimBenefits, String taxCredit) throws InterruptedException {
		conditionPage.selectTaxClaimRadioButton(claimBenefits, taxCredit);
	}

	@When("^Enter Details about pregnant as (.*)$")
	public void enter_details_about_pregnant_as_yorn(String field) {
		conditionPage.selectPregnantRadioButton(field);
	}
	
	@When("^Enter Details about injury or illness in armed forces as (.*)$")
	public void enter_details_about_injury_or_illness_in_armed_forces_as_war(String war) {
	    conditionPage.selectInjuryOrIllnessRadioButton(war);
	}

	@When("^Enter Details about diabetes as (.*) and (.*)$")
	public void enter_details_about_diabetes_as_diabetes(String diabetes, String country) {
		conditionPage.selectCustomerIsDiabetesOrNotRadioButton(diabetes,country);
	}

	@When("^Enter Details about care home as (.*) and (.*)$")
	public void enter_details_about_care_home_as_permanent_and_careHome(String permanent, String careHome) {
		conditionPage.selectCareHomeOption(permanent, careHome);
	}

	@When("Enter Details about savings or investment")
	public void enter_details_about_savings_or_investment() {
		conditionPage.selectSavingsRadioButton();		
	}

		@Then("^Get outcome and verify customer receive any help or not with NHS cost pass parameter as (.*) and (.*) and (.*)$")
	public void get_outcome_and_verify_customer_receive_any_help_or_not_with_nhs_cost_pass_parameter_as_claimBenefits_and_taxCredit_and_careHome(
			String claimBenefits, String taxCredit, String careHome) {
		if (claimBenefits.equalsIgnoreCase("NA") && taxCredit.equalsIgnoreCase("NA") && careHome.equalsIgnoreCase("NA")) {
			Assertions.assertTrue(
					conditionPage.northernIrelandNHSCheckerCostHelpOutCome().trim()
							.equalsIgnoreCase("You cannot use this service because you live in Northern Ireland"),
					"Not Eligibile : " + conditionPage.northernIrelandNHSCheckerCostHelpOutCome().trim());
		}
		else if (claimBenefits.equalsIgnoreCase("No") && taxCredit.equalsIgnoreCase("No") && careHome.equalsIgnoreCase("No")) {
			Assertions.assertTrue(conditionPage.receiveCheckerCostToolOutput().size() >= 1, "You will get free :" + conditionPage.receiveCheckerCostToolOutput());
		}
		else if (claimBenefits.equalsIgnoreCase("Yes") && taxCredit.equalsIgnoreCase("No")) {
				Assertions.assertTrue(conditionPage.receiveNoCheckerCostToolOutput().trim().contains("Universal Credit decision"),
						"Don't get any help:" + conditionPage.receiveNoCheckerCostToolOutput().trim());
			} else if (claimBenefits.equalsIgnoreCase("Yes") && taxCredit.equalsIgnoreCase("Yes")) {
				Assertions.assertTrue(conditionPage.receiveCheckerCostToolUniversalCredit().size() >= 1,
						"You will get free :" + conditionPage.receiveCheckerCostToolUniversalCredit());
			}
		}
	}


