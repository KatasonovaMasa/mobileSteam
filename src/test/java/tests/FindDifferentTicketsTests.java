package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.qameta.allure.Allure.step;
import static java.time.temporal.ChronoUnit.MILLIS;

@Tag("SteamMobileTests")
public class FindDifferentTicketsTests extends TestBase{
 
 @Test
 @Order(1)
 void openApp() {
     step("Open Steam", () -> {
         $$(AppiumBy.className("android.widget.EditText")).get(0).click();
         $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(" ");
         $$(AppiumBy.className("android.widget.EditText")).get(1).click();
         $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(" ");
         $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
         sleep(15000);
         $$(AppiumBy.className("android.view.ViewGroup")).get(3).shouldHave(visible);
     });
 }
    @Test
    @Order(2)
    void searchJobApi() {
        step("Open Steam", () -> {
                    sleep(15000);
                    $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
                    $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead" + "\n");
                    $(AppiumBy.className("android.widget.ImageView")).click(); //нажать на вопрос
                    $$(AppiumBy.className("android.view.ViewGroup")).get(2).click(); // нажать назад
                    $$(AppiumBy.className("android.view.ViewGroup")).get(1).click(); //нажать на поиск
                    $(AppiumBy.xpath("//android.view.View[@content-desc=\"Cuphead 29 Sep, 2017 419 pуб.\"]")).shouldHave(visible);
        });
    }
    @Test
    @Order(3)
    void potentialBuyGames() {
        step("Open Steam", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead" + "\n");
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
            sleep(1000);
            swipeUpQuick(12000);
            swipeUpQuick(12000);
            $(AppiumBy.xpath("(//android.view.View[@content-desc=\"Add to Cart\"])[1]/android.widget.TextView")).click();
            $(AppiumBy.className("android.view.View")).shouldHave(text("YOUR SHOPPING CART"));
        });
    }

    public void swipeUp(int timeOfSwipeMs) {
        TouchAction action = new TouchAction((PerformsTouchActions) getWebDriver());
        Dimension size = getWebDriver().manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);


        action
                .press(point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.of(timeOfSwipeMs, MILLIS)))
                .moveTo(point(x, end_y))
                .release()
                .perform();
    }

    public void swipeUpQuick(int i) {
        swipeUp(2000);
    }

}
