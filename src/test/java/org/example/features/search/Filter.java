package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/filter.csv")
public class Filter {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    @ManagedPages(defaultUrl = "https://www.flanco.ro/catalogsearch/result/?q=tastatura")
    public Pages pages;
    public String name;
    public String firstProduct;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EndUserSteps endUser;

//    @Issue("#WIKI-1")
    @Test
    public void searchWikiByKeywordTestDDT() {
        endUser.is_the_home_page();
        endUser.filter();
        endUser.shouldSeeProduct(getDefinition());
    }

    public String getDefinition() {
        return firstProduct;
    }

    public void setDefinition(String firstProduct) {
        this.firstProduct = firstProduct;
    }
}

