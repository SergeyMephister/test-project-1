package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GoogleMainPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;

public class SearchSelenideTest extends BaseSelenideTest {

    @Test
    @Owner("Sergey Mephister")
    @Description("Search for one word and checking results")
    @DisplayName("Search for one word and checking results")
    public void searchBySelenide() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        open("https://google.com");
        googleMainPage.fillInputSearch("Selenide");
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.checkingResults("selenide.org");
    }

}