package ui_testing.naveen.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;
import static ui_testing.naveen.tests.TestToTest.*;
import utils.ScreenShot;


public class RegisterAccount {

    @Getter
    public static String h1Locator = "//*[@id='content']/h1";
    @Getter
    public static String registerLegendLocator = "//*[@id='account']/legend";




    private static final ScreenShot screenShot = new ScreenShot();


    public static String getActualText(WebDriver driver) {
        WebElement registerLegendElement = driver.findElement(By.xpath(registerLegendLocator));
        return registerLegendElement.getText();

    }

    public static void regLegenda_verify(WebDriver driver) throws IOException {

        String expectedTextRegLegend = "Your Personal Details";

        String actualTextRegLegemd = getActualText(driver);
        try {
            Assert.assertEquals(actualTextRegLegemd, expectedTextRegLegend);
            test.log(Status.PASS, "Test Sucesseful");
            test.log(Status.PASS, (Markup) test.addScreenCaptureFromBase64String(screenShot.captureScreen(driver, 800, 600)+ "test Passed"));
        } catch (AssertionError e) {
            test.log(Status.FAIL, "The test was not successful. : " + e.getMessage());
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot.captureScreen(driver, 800, 600)).build());
            //test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
            Assert.assertEquals(actualTextRegLegemd, expectedTextRegLegend, "The text on the registration page does not match what was expected.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}