package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {
    static String deviceHost = System.getProperty("devicehost", "browserstackHost");

    @BeforeAll
    public static void setup() {

        if (Objects.equals(deviceHost, "browserstackHost")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
            Configuration.browserSize = null;
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
            Configuration.browserSize = null;
            }
        }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
        Attach.video(sessionId);
        if (Objects.equals("deviceHost", "localHost")) {
            Attach.video(sessionId);
        }
    }
}
