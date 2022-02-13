package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class OrderPage {

    private SelenideElement alertDiv = $(".alert-danger");

    private SelenideElement sentMessage = $("p");

    public SelenideElement getAlertDiv() {
        return alertDiv;
    }

    public SelenideElement getSentMessage() {
        return sentMessage;
    }
}
