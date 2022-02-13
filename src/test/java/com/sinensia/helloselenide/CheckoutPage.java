package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class CheckoutPage {

    private SelenideElement ageInput = $("#ageInput" );

    private SelenideElement orderButton = $(".btn-success");

    public void setAge(String age){

        ageInput.click();
        ageInput.setValue(age);

    }

    public SelenideElement getAgeInput(){
        return ageInput;
    }

    public String getAge(){
        return ageInput.getValue();
    }

    public OrderPage order() {
        orderButton.click();
        return page(OrderPage.class);
    }

}
