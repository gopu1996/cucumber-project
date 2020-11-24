package com.org.uistore;

import org.openqa.selenium.By;

public class LoginPageUi {
	
	 public static By userName=By.cssSelector("[name^='txtUsername']");
	 public static By password=By.cssSelector("[name^='txtPassword']");
	 public static By btnLogin=By.cssSelector("[name^='Submit']");
	 public static By dashBoard = By.cssSelector(".head h1");
	 public static By errMsg =By.cssSelector("#frmLogin #spanMessage ");
}
