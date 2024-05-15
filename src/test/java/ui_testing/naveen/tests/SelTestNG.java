package ui_testing.naveen.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui_testing.naveen.pages.HomePage;
import ui_testing.naveen.pages.RegisterAccount;




public class SelTestNG {

    public WebDriver driver;
    public static ExtentTest test;
    ExtentReports extent = new ExtentReports();
    String actualText;

    @BeforeSuite
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    @Test
    public void testHomePageToRegister() throws InterruptedException {
        test = extent.createTest("Validate Flow Home to Register", "This a initial Validate");


        WebElement logoElement = driver.findElement(By.cssSelector(HomePage.getLogo()));
        assert logoElement.isDisplayed() : "O logotipo não está visível";

        WebElement myAccountMenu = driver.findElement(By.cssSelector(HomePage.getMenuMyAccount()));
        assert myAccountMenu.isDisplayed() : "O Menu 'My Account' não está visível";
        myAccountMenu.click();


        WebElement registerLink = driver.findElement(By.cssSelector(HomePage.getRegisterLink()));
        assert registerLink.isDisplayed() : "O link 'Register' não está visível";
        HomePage.navigateToRegisterPage(driver);


        WebElement h1LocatorRegister = driver.findElement(By.xpath(RegisterAccount.getH1Locator()));
        assert h1LocatorRegister.isDisplayed() : "O título da página de registro não está visível";

        WebElement legendeRegister = driver.findElement(By.xpath(RegisterAccount.getRegisterLegendLocator()));
        assert legendeRegister.isDisplayed() : "O legenda da página de registro não está visível";
        actualText = legendeRegister.getText();




    }


    @Test
    public void testRegisterFlow() {
        test = extent.createTest("Validate Fake Register", "This a second Validate");

        String expectedText = "Your Personal Details";

        try {
            Assert.assertEquals(actualText, expectedText);
            test.log(Status.PASS, "Teste Passou");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "NÃO PASSOU NÃO : " + e.getMessage());
            Assert.assertEquals(actualText, expectedText, "Texto na página de registro não corresponde ao esperado");
        }
    }










    @AfterSuite
    public void cleaup() {
        extent.flush();
        driver.quit();
    }
}
