package com.sinensia.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CartSuiteTest {
    CartPage cartPage =  new CartPage();

    @BeforeAll
    public static void setUpAll() {
        //Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());

        //Add VNC
        DesiredCapabilities capabilites = new DesiredCapabilities();
        capabilites.setCapability("enableVNC", true);
        capabilites.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilites;
    }

    @BeforeEach
    public void setUp() {
        //open("http://localhost:3000/");
        //open("http://10.250.2.4:3000");
        open("/");
    }

    @Test
    public void colaTest() {
        cartPage.addCola();
        cartPage.total().shouldBe(text("€1.25"));
    }
}
