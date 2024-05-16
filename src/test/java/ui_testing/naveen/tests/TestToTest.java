package ui_testing.naveen.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui_testing.naveen.pages.HomePage;
import ui_testing.naveen.pages.RegisterAccount;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TestToTest {

    public WebDriver driver;
    public static ExtentTest test;
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

//    public static String captureScreen(WebDriver driver) throws IOException, IOException {
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
//        String errFlPath = Dest.getAbsolutePath();
//        FileUtils.copyFile(srcFile, Dest);
//        return errFlPath;
//    }


    public static String captureScreen(WebDriver driver, int width, int height) throws IOException {

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage originalImage = ImageIO.read(srcFile);
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, width, height, null);
        File destFile = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
        ImageIO.write(resizedImage, "png", destFile);
        return destFile.getAbsolutePath();
    }
    @Test
    public void HomePageToRegisterTest() throws InterruptedException, IOException {
        test = extent.createTest("Validate Home to Register", "initial Validate");
        HomePage.validateElements(driver);
        HomePage.clickRegisterLink(driver);
        RegisterAccount.regLegenda_verify(driver);





    }


    @AfterSuite
    public void cleaup() {
        extent.flush();
        driver.quit();
    }


}



