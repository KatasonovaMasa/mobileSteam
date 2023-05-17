package tests;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("SteamMobileTests")
public class FindDifferentTicketsTests extends TestBase{
 
 @Test
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
}
