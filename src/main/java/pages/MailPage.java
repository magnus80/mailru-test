package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static pages.ComposeMailPage.app;


public class MailPage {

    public static final SelenideElement composeMail = $(".compose-button__txt");

    @Step("Click on button 'Написать письмо'")
    public void composingMail() {
        composeMail.click();
        $(app).waitUntil(visible, 5000, 100);
    }
}
