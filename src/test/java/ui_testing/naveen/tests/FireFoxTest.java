package ui_testing.naveen.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui_testing.naveen.pages.HomePage;
import ui_testing.naveen.pages.RegisterAccount;
import java.io.IOException;

public class FireFoxTest {

    public WebDriver driver;
    public static ExtentTest test;
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void setUp() {


        // Inicializa o WebDriver do Firefox
        driver = new FirefoxDriver();

        // Navega para a página desejada
        driver.get("https://naveenautomationlabs.com/opencart/");

        // Maximiza a janela do navegador
        driver.manage().window().maximize();

        // Inicializa o relatório de testes com ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    @Test
    public void HomePageToRegisterTest() throws InterruptedException, IOException {
        test = extent.createTest("Validate Home to Register", "initial Validate");

        HomePage.validateElements(driver);
        HomePage.clickRegisterLink(driver);
       // RegisterAccount.regLegenda_verify(driver);
    }


    @AfterSuite
    public void cleaup() {
        extent.flush();
        driver.quit();
    }
}
