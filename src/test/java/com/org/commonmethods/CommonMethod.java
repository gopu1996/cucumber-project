package com.org.commonmethods;

import static com.org.hooks.hooks.driver;

import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.org.utlity.FileReader;

import static com.org.hooks.hooks.log;

/**
 * @author Gopal Pandey
 *
 */
public class CommonMethod {

	@SuppressWarnings("deprecation")
	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static boolean click(WebElement click) {
		try {
			click.click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static boolean navigateToUrl(WebDriver driver, String url, Logger log) {

		try {
			driver.get(url);
			log.debug("Navigate to "+ FileReader.getEnv() +"  url");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static boolean sendElement(String data, WebElement send) {
		try {
			send.sendKeys(data);
			log.info("Entering a text "+data);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static WebElement getElement(By selector, WebDriver driver) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static List<WebElement> fetchElements(By selector, WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.findElements(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static List<WebElement> getElements(By selector, WebDriver driver) {
		try {
			return driver.findElements(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static String getPageTitle(WebDriver driver) {

		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String getCurrentUrl(WebDriver driver) {

		try {
			System.out.println(driver.getCurrentUrl());
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public static boolean selectByValue(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean selectByVisibleText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select month = new Select(element);
			month.selectByVisibleText(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean ratioButtonSelector(List<WebElement> element, String Value) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getAttribute("value").equalsIgnoreCase(Value)) {
					if (element.get(i).isEnabled()) {
						element.get(i).click();
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void selectByIndex(WebElement element, int index) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Select droplist = new Select(element);
		for (int i = 0; i < droplist.getOptions().size(); i++) {
			if (index == i) {
				droplist.getOptions().get(i).click();
			}
		}
	}

	public static String randomString(String numchar) {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String alphaNumericString = fakeValuesService.regexify("[a-z1-9]{" + numchar + "}");
		return alphaNumericString;
	}

	public static int randomNumber(String numchar) {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String alphaNumericString = fakeValuesService.regexify(numchar); // ex [1-9]{numchar }
		return Integer.parseInt(alphaNumericString);
	}

	public static String randomEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@abcd.com");
		return email;
	}

	public static String randomFirstName() {
		String randfirstName = new Faker().name().firstName();
		return randfirstName;
	}

	public static String randomLastName() {
		String randlastName = new Faker().name().lastName();
		return randlastName;
	}

	public static String randomMiddleName() {
		String randmiddleName = new Faker().name().nameWithMiddle();
		return randmiddleName;
	}

	public static String randnameTitle() {
		String randnameTitle = new Faker().name().title();
		return randnameTitle;
	}

	public static String randAddrstreetName() {
		String randAddrstreetName = new Faker().address().streetName();
		return randAddrstreetName;
	}

	public static String randAddrbuildingNumber() {
		String randAddrbuildingNumber = new Faker().address().buildingNumber();
		return randAddrbuildingNumber;
	}

	public static String randomCity() {
		String randAddrcity = new Faker().address().city();
		return randAddrcity;
	}

	public static String randomCountry() {
		String randAddrcountry = new Faker().address().country();
		return randAddrcountry;
	}

	public static String randomZipcode() {
		String randPostCode = new Faker().address().zipCode();
		return randPostCode;
	}

}
