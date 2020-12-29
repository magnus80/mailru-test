package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.MailPage.composeMail;

public class MainPage {

    private final SelenideElement inputName = $("input.email-input");
    private final SelenideElement inputPassword = $("input.password-input");
    private final SelenideElement enterPassBtn = $("button.button.svelte-no02r");
    private final SelenideElement enterBtn = $("button.second-button");

    @Step("Opening page")
    public MainPage open() {
        return Selenide.open("/", MainPage.class);
    }

    @Step("Login into mail using login {login} and password {pass}")
    public void loginIntoMail(String login, String pass) {
        inputName.val(login);
        enterPassBtn.click();
        executeJavaScript("document.querySelector('input.password-input').style.opacity = '100'");
        inputPassword.click();
        inputPassword.val(pass);
        enterBtn.click();
        composeMail.waitUntil(visible, 5000);
    }
}
