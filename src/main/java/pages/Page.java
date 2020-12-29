package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {

    public Page setTextInField(String cssSelector, String text) {
        SelenideElement element = $(cssSelector);
        element.clear();
        element.val(text);
        return this;
    }
}
