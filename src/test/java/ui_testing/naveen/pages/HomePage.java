package ui_testing.naveen.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @Getter
    public static String logo = "a[title='My Account']";
    @Getter
    public static String menuMyAccount = "a[title='My Account']";
    public static String registerMenuLink = "a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']";

    public static void clickRegisterLink(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement myAccountElement = driver.findElement(By.cssSelector(menuMyAccount));
        myAccountElement.click();

        WebElement registerLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(registerMenuLink)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerLink);
    }


    public static void validateElements(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(logo)));
        WebElement myAccountLink = driver.findElement(By.cssSelector(menuMyAccount));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(menuMyAccount)));
        myAccountLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(registerMenuLink)));
    }
}
