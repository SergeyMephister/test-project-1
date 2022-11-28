package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GoogleMainPage {
    private final SelenideElement searchField =  $("[name=q]");

    @Step("Ввести поисковой запрос в поле 'Поиск' и нажать Enter")
    public void fillInputSearch(String search) {
        //TODO: Сделать проверку на то что элемент существует
        searchField.click();
        searchField.clear();
        searchField.setValue(search).pressEnter();
    }
}
