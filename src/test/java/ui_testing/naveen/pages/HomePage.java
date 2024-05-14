package ui_testing.naveen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static String logo = "a[title='My Account']";
    public static String menuMyAccount = "a[title='My Account']";
    public static String registerLink = "a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']";

    public static String getLogo() {
        return logo;
    }

    public static String getRegisterLink() {
        return registerLink;
    }

    public static void setRegisterLink(String registerLink) {
        HomePage.registerLink = registerLink;
    }

    public static void setLogo(String logo) {
        HomePage.logo = logo;
    }

    public static String getMenuMyAccount() {
        return menuMyAccount;
    }

    public static void setMenuMyAccount(String menuMyAccount) {
        HomePage.menuMyAccount = menuMyAccount;
    }

    public static void clickMyAccount(WebDriver driver) {
        WebElement myAccountElement = driver.findElement(By.cssSelector(menuMyAccount));
        myAccountElement.click();
    }

    public static RegisterAccount clickRegisterLink(WebDriver driver) {
        WebElement registerElement = driver.findElement(By.cssSelector(registerLink));
        registerElement.click();
        return new RegisterAccount(driver);
    }
}
