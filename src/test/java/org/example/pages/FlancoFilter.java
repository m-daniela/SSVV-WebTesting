package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.flanco.ro/catalogsearch/result/?q=tastatura")
public class FlancoFilter extends PageObject {

    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/aside/div/div[2]/div[1]/ul/ul/li[1]/a/div")
    private WebElementFacade filterButton;

    public void filterLookup() {
        filterButton.click();
    }

    public String getProducts() {
        WebElementFacade products = find(By.xpath("//*[@id=\"product-title\"]"));
        return products.getText();
    }

}