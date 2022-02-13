package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/
public class CartPage {

    private SelenideElement btnAddCola = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement btnAddBeer = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement btnAddWine = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement txtTotal = $("th[class='ng-binding']");

    private SelenideElement btnCheckout = $(".btn-success");

    public void addCola() {
        btnAddCola.click();
    }

    public void addBeer() {
        btnAddBeer.click();
    }

    public void addWine() {
        btnAddWine.click();
    }

    public void checkout() {
        btnCheckout.click();
    }
    public SelenideElement getCheckout() {
        return btnCheckout;
    }

    public SelenideElement total() {
        return txtTotal;
    }

}