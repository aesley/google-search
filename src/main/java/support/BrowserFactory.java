package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public static enum Browser {
        CHROME,
        CHROME_HEADLESS,
    }

    public static WebDriver getBrowser() {
        return getBrowser(Browser.CHROME_HEADLESS);
    }

    public static WebDriver getBrowser(Browser nav) {
        WebDriver navegador;
        ChromeOptions options;

        // Reduzindo a saída do webdriver
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        switch(nav) {
            case CHROME:
                // Reduzindo a saída do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");

                // Configuração de preferências de download chromelocal
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.prompt_for_download", false);
                options.setExperimentalOption("prefs", prefs);

                navegador = new ChromeDriver(options);
                navegador.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                // Reduzindo a saída do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--lang=pt-BR");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");

                // Configuração de preferências de download no Headless
                Map<String, Object> prefsHeadless = new HashMap<>();
                prefsHeadless.put("download.prompt_for_download", false);
                options.setExperimentalOption("prefs", prefsHeadless);

                navegador = new ChromeDriver(options);
                break;
            default:
                navegador = null;
                new Exception("Browser Não Suportado");
        }
        return navegador;
    }
}
