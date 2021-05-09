package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.Flanco;
import org.example.pages.FlancoFilter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    Flanco dictionaryPage;
    FlancoFilter flancoFilter;


    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getProducts(), hasItem(containsString(definition)));
    }

    @Step
    public void shouldSeeProduct(String definition) {
        assertThat(flancoFilter.getProducts(), containsString(definition));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void openFilterPage() {
        flancoFilter.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void filter() {
        flancoFilter.filterLookup();
    }
}