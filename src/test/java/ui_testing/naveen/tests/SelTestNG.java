package ui_testing.naveen.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui_testing.naveen.pages.HomePage;
import ui_testing.naveen.pages.RegisterAccount;


public class SelTestNG {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageToRegister() throws InterruptedException {

        WebElement logoElement = driver.findElement(By.cssSelector(HomePage.getLogo()));
        assert logoElement.isDisplayed() : "O logotipo não está visível";

        WebElement myAccountMenu = driver.findElement(By.cssSelector(HomePage.getMenuMyAccount()));
        assert myAccountMenu.isDisplayed() : "O Menu 'My Account' não está visível";
        myAccountMenu.click();


        WebElement registerLink = driver.findElement(By.cssSelector(HomePage.getRegisterLink()));
        assert registerLink.isDisplayed() : "O link 'Register' não está visível";
        HomePage.clickRegisterLink(driver);


        WebElement h1LocatorRegister = driver.findElement(By.xpath(RegisterAccount.getH1Locator()));
        assert h1LocatorRegister.isDisplayed() : "O título da página de registro não está visível";

        WebElement legendeRegister = driver.findElement(By.xpath(RegisterAccount.getRegisterLegendLocator()));
        assert legendeRegister.isDisplayed() : "O título da página de registro não está visível";


    }
}
