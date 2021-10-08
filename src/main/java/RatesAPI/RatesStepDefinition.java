package RatesAPI;


import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RatesStepDefinition {

	private static Response response;
	private static String jsonString;

	@Given("Rates API for latest foreign exchange rate")
	public void rates_API_for_latest_foreign_exchange_rate() throws Throwable {
		RestAssured.baseURI = RatesApiVariables.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		response = request.get(RatesApiVariables.getBaseUrl() + "/latest?access_key=" + RatesApiVariables.getKey());
		System.out.println(
				request.get(RatesApiVariables.getBaseUrl() + "/latest?access_key=" + RatesApiVariables.getKey())
						+ "url provided");

	}

	@Then("Receive success HTTP response success {int}")
	public void receive_success_HTTP_response_success(Integer int1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("response is successful for  API");

	}

	@And("Receive exchange rates as response")
	public void receive_exchange_rates_as_response() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		jsonString = response.asString();
		System.out.println("latest foreign exchange values are " + jsonString);
		System.out.println("---------------------------------------------------");
	}

	@Given("Incorrect rates API url for Latest Foreign Exchange rates")
	public void incorrect_rates_API_for_Latest_Foreign_Exchange_rates() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = RatesApiVariables.getBaseUrl();
		;
		RequestSpecification request = RestAssured.given();
		response = request.get(RatesApiVariables.getBaseUrl() + "/latest?access=" + RatesApiVariables.getKey());
		System.out.println(response + "incorrect url provided");
	}

	@Then("I receive requested service point not exist HTTP response {int}")
	public void i_receive_requested_service_point_not_exist_HTTP_response(Integer int1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(401, response.getStatusCode());
		System.out.println("Getting error...");
		System.out.println("---------------------------------------------------");

	}

	@Given("Rates API for specific historic date foreign exchange rate")
	public void rates_API_for_specific_historic_date_foreign_exchange_rate() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = RatesApiVariables.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		RatesApiVariables.yesterday();
		response = request.get(RatesApiVariables.getBaseUrl() + RatesApiVariables.getYesterday() + "?access_key="
				+ RatesApiVariables.getKey());

	}

	@Given("Rates API for Future date foreign exchange rate")
	public void rates_API_for_Future_date_foreign_exchange_rate() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = RatesApiVariables.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		RatesApiVariables.future();
		response = request.get(RatesApiVariables.getBaseUrl() + RatesApiVariables.getFuture() + "?access_key="
				+ RatesApiVariables.getKey());

	}

	@Then("Receive Bad request error {int}  for future date foreign exchange rate")
	public void receive_Bad_request_error_for_future_date_foreign_exchange_rate(Integer int1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(400, response.getStatusCode());
		System.out.println("Getting error...");
		System.out.println("---------------------------------------------------");
	}



}
