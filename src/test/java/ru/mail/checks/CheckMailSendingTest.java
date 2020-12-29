package ru.mail.checks;

import base.BaseTest;
import helpers.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ComposeMailPage;
import pages.MailPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.exactText;

class CheckMailSendingTest extends BaseTest {

    private final TestConfig config = ConfigFactory.create(TestConfig.class);

    @Tag("checkMail")
    @DisplayName("checkMailSending")
    @Test()
    void checkMailSendingTest() {
        new MainPage().open()
                .loginIntoMail(config.login(), config.password());
        new MailPage().composingMail();
        new ComposeMailPage()
                .fillReceiver(config.receiver())
                .fillSubject("theme")
                .fillBody("body")
                .sendMail()
                .sentTitle.shouldHave(exactText("Письмо отправлено"));
    }
}
