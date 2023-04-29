package org.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	static WebDriver driver;

	@Given("User enters to the Adactin hotel page")
	public void user_enters_to_the_adactin_hotel_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");

	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		driver.findElement(By.id("login")).click();
	}

	@Then("User shoud see the {string} text")
	public void user_shoud_see_the_text(String string) {
		boolean displayed = driver.findElement(By.partialLinkText(string)).isDisplayed();
		Assert.assertTrue(displayed);
	}

	@Given("User sees {string} text")
	public void user_sees_text(String string) {
		WebElement searchHotel = driver
				.findElement(By.xpath("//table//tbody//tr//td//td[contains(text(),'Search Hotel ')]"));
		Assert.assertTrue(searchHotel.getText().contains(string));

	}

	@When("User selects {string} location")
	public void user_selects_location(String string) {
		WebElement location = driver.findElement(By.id("location"));
		Select s = new Select(location);
		s.selectByVisibleText(string);

	}

	@When("User selects {string} hotel")
	public void user_selects_hotel(String string) {
		WebElement location = driver.findElement(By.id("hotels"));
		Select s = new Select(location);
		s.selectByVisibleText(string);
	}

	@When("User selects {string} room")
	public void userselects_room(String string) {
		WebElement location = driver.findElement(By.id("room_type"));
		Select s = new Select(location);
		s.selectByVisibleText(string);
	}

	@When("User selects {string} no of rooms")
	public void user_selects_no_of_rooms(String string) {
		WebElement location = driver.findElement(By.id("room_nos"));
		Select s = new Select(location);
		s.selectByVisibleText(string);
	}

	@When("Users enters {string} check in date")
	public void users_enters_check_in_date(String string) {
		WebElement checkIn = driver.findElement(By.id("datepick_in"));
		checkIn.clear();
		checkIn.sendKeys(string);
	}

	@When("Users enters {string} check out date")
	public void users_enters_check_out_date(String string) {
		WebElement checkOut = driver.findElement(By.id("datepick_out"));
		checkOut.clear();
		checkOut.sendKeys(string);
	}

	@When("Users selects {string} nos of adults")
	public void users_selects_nos_of_adults(String string) {
		WebElement location = driver.findElement(By.id("adult_room"));
		Select s = new Select(location);
		s.selectByVisibleText(string);
	}

	@When("User Selects {string} nos of childrens")
	public void user_selects_nos_of_childrens(String string) {
		WebElement location = driver.findElement(By.id("child_room"));
		Select s = new Select(location);
		s.selectByVisibleText(string);
	}

	@When("User clicks Search button")
	public void user_clicks_search_button() {
		driver.findElement(By.id("Submit")).click();
	}

	@Then("User should see {string} text")
	public void user_should_see_text(String string) {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(string));
	}
}
  