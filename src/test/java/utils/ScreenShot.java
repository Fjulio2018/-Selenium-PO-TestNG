package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static String capture(WebDriver driver, int width, int height) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage originalImage = ImageIO.read(srcFile);
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, width, height, null);
        File destFile = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
        ImageIO.write(resizedImage, "png", destFile);
        return destFile.getAbsolutePath();
    }

    public String captureScreen(WebDriver driver, int width, int height) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage originalImage = ImageIO.read(srcFile);
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, width, height, null);
        File destFile = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
        ImageIO.write(resizedImage, "png", destFile);
        return destFile.getAbsolutePath();
    }
}

