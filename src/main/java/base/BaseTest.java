package base;

import com.codeborne.selenide.Configuration;
import driverprovider.ChromeDriverProvider;
import helpers.TestConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.codeborne.selenide.logevents.SelenideLogger.removeAllListeners;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        TestConfig config = ConfigFactory.create(TestConfig.class);
        Configuration.browser = ChromeDriverProvider.class.getName();
        Configuration.baseUrl = config.url();
        Configuration.timeout = config.timeout();
        //Configuration.fileDownload = HTTPGET;
        addListener("AllureSelenide", new AllureSelenide().includeSelenideSteps(false)
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterAll()
    static void tearDown() {
        removeAllListeners();
        closeWebDriver();
    }
}
