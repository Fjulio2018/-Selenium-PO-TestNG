package ui_testing.naveen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static String logo = "a[title='My Account']";
    public static String menuMyAccount = "a[title='My Account']";
    public static String registerMenuLink = "a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']";

    public static String getLogo() {
        return logo;
    }

    public static String getRegisterLink() {
        return registerMenuLink;
    }

    public static String getMenuMyAccount() {
        return menuMyAccount;
    }

    public static void clickMyAccount(WebDriver driver) {
        WebElement myAccountElement = driver.findElement(By.cssSelector(menuMyAccount));
        myAccountElement.click();
    }

    public static RegisterAccount clickRegisterLink(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement myAccountElement = driver.findElement(By.cssSelector(menuMyAccount));
        myAccountElement.click();

        WebElement registerLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(registerMenuLink)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerLink);
        return new RegisterAccount(driver);
    }



    public static void validateElements(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logoElement = driver.findElement(By.cssSelector(logo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(logo)));

        WebElement myAccountLink = driver.findElement(By.cssSelector(menuMyAccount));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(menuMyAccount)));
        myAccountLink.click();
        WebElement registerLink = driver.findElement(By.cssSelector(registerMenuLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(registerMenuLink)));
    }
}
