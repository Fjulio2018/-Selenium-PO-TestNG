package ui_testing.naveen.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui_testing.naveen.pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestToTest {

    public WebDriver driver;
    public static ExtentTest test;
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void setUp() {
        // Define o caminho para o chromedriver
        String chromeDriverPath = "resources/driver/chromedriver.exe";
        // Verifica se o chromedriver existe no caminho especificado
        File chromedriver = new File(chromeDriverPath);
        if (!chromedriver.exists()) {
            System.out.println("Erro: chromedriver não encontrado no caminho especificado: " + chromeDriverPath);
            return; // Aborta a execução se o chromedriver não for encontrado
        }
        // Define a propriedade do sistema para o caminho do chromedriver
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        // Inicializa o WebDriver do Chrome
        driver = new ChromeDriver();

        // Abre uma página da web
        driver.get("https://naveenautomationlabs.com/opencart/");

        // Maximiza a janela do navegador
        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    @Test
    public void HomePageToRegisterTest() throws InterruptedException, IOException {
        test = extent.createTest("Validate Home to Register", "initial Validate");
        // Chamadas para os métodos de teste devem ser adicionadas aqui
        // Exemplo:
        // HomePage.validateElements(driver);
        // HomePage.clickRegisterLink(driver);
        // RegisterAccount.regLegenda_verify(driver);
    }

    // Este método pode ser usado para limpar recursos após a execução dos testes
    // @AfterSuite
    // public void cleaup() {
    //    extent.flush();
    //    driver.quit();
    // }
}
