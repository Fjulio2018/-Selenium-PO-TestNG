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
    String actualTextTest;

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
    public void HomePageToRegisterTest() throws InterruptedException {
        test = extent.createTest("Validate Home to Register", "initial Validate");
        HomePage.validateElements(driver);
        HomePage.clickRegisterLink(driver);

        String expectedTextRegLegend = "Your Personal Details";
        String actualTextRegLegemd = RegisterAccount.getActualText(driver);


        try {
            Assert.assertEquals(actualTextRegLegemd, expectedTextRegLegend);
            test.log(Status.PASS, "Test Sucesseful");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "The test was not successful. : " + e.getMessage());
            Assert.assertEquals(actualTextRegLegemd, expectedTextRegLegend, "The text on the registration page does not match what was expected.");
        }


    }


    @AfterSuite
    public void cleaup() {
        extent.flush();
        driver.quit();
    }
}