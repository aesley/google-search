package base_class;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.BrowserFactory;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseSteps {
    public static WebDriver browser;
    public static Scenario scenario;

    public static void OpenBrowser() {
        if (browser != null) return;
        browser = BrowserFactory.getBrowser();
    }

    public static void CloseBrowser() {
        if (browser == null) return;
        browser.quit();
        browser = null;
    }

    public static void screenshot() {
        try {
            String dataHora = (new SimpleDateFormat("yyyy-MM-dd_-_HH-mm-ss-SSS")).format(new Date());
            byte[] screenshot = ((TakesScreenshot) BaseSteps.browser).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", dataHora + "_screenshot.png");
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    public static void downloadFile(String fileUrl, String downloadPath) {
        try {
            browser.get(fileUrl);

            WebDriverWait wait = new WebDriverWait(browser, 30);
            WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Download")));

            downloadButton.click();

            // Aguardar o download ser concluído
            File downloadedFile = new File(downloadPath);
            while (!downloadedFile.exists()) {
                Thread.sleep(1000);
            }

            // Anexar ao cenário o arquivo baixado
            byte[] fileBytes = Files.readAllBytes(downloadedFile.toPath());
            scenario.attach(fileBytes, "application/octet-stream", downloadedFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
