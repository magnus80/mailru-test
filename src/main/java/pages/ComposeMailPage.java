package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComposeMailPage extends Page {

    static final SelenideElement app = $("div[class^='scrollview']");
    private static final String RECEIVER_FIELD = "div[class^='contactsContainer'] input";
    //private final SelenideElement receiverField = app.$("div[class^='contactsContainer'] input");
    private static final String SUBJECT_FIELD = "input[name='Subject']";
    //private final SelenideElement subjectField = app.$("input[name='Subject']");

    private final SelenideElement editor = $("div[class^='editor_container']");
    private final SelenideElement bodyField = editor.$("div[class$='cke_show_borders']>div");
    private static final String BODY_FIELD = "div[class$='cke_show_borders']>div";

    private final SelenideElement footer = $(".compose-app__footer");
    private final SelenideElement sendBtn = footer.$("span[data-title-shortcut='Ctrl+Enter']");

    public final SelenideElement sentTitle = $(".layer__header>a");

    @Step("Fill receiver: {receiver}")
    public ComposeMailPage fillReceiver(String receiver) {
        setTextInField(RECEIVER_FIELD, receiver);
        return this;
    }

    @Step("Click on Send button")
    public ComposeMailPage sendMail() {
        sendBtn.click();
        sentTitle.waitUntil(visible, 5000, 100);
        return this;
    }

    @Step("Fill subject: {subject}")
    public ComposeMailPage fillSubject(String subject) {
        setTextInField(SUBJECT_FIELD, subject);
        return this;
    }

    @Step("Fill body: {body}")
    public ComposeMailPage fillBody(String body) {
        $$(BODY_FIELD).first().val(body);
        return this;
    }
}

