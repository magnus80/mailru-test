package driverprovider;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static java.io.File.separator;
import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        ChromeOptions opts = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "build" + separator + "downloadFiles");
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("select_file_dialogs.allowed", false);
        opts.setExperimentalOption("prefs", prefs);

        opts.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--incognito");
        opts.addArguments("--disable-infobars");
        opts.addArguments("--disable-notifications");
        opts.addArguments("--safebrowsing-disable-download-protection");

        capabilities.setCapability(CAPABILITY, opts);
        opts.merge(capabilities);

        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver(opts);
    }
}
