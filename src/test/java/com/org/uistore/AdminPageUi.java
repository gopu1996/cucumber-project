package com.org.uistore;

import org.openqa.selenium.By;

public class AdminPageUi {
	
	public static By btnAdd=By.cssSelector("[name^='btnAdd']");
    public static By empName = By.cssSelector("[name^='systemUser[employeeName][empName]']");
    public static By userName = By.cssSelector("[name^='systemUser[userName]']");
    public static By password = By.cssSelector("[name='systemUser[password]']");
    public static By cnfPassword = By.cssSelector("[name='systemUser[confirmPassword]']");
    public static By btnSave = By.cssSelector(".addbutton");
    public static By txtSearch = By.cssSelector("[name='searchSystemUser[userName]']");
    public static By btnSearch = By.cssSelector("[name='_search']");
    public static By verifyUser = By.cssSelector("#resultTable .odd a"); 
}
