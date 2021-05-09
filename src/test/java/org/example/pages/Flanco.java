package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.flanco.ro/")
public class Flanco extends PageObject {

    @FindBy(id="searchingfield")
    private WebElementFacade searchTerms;

    @FindBy(id="searching")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getProducts() {
        WebElementFacade products = find(By.className("produs"));
        return products.findElements(By.className("produs-title")).stream()
                .map( element -> element.findElement(By.tagName("a"))
                        .getAttribute("title") )
                .collect(Collectors.toList());
    }

}