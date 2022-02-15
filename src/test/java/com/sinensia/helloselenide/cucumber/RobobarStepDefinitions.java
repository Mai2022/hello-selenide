package com.sinensia.helloselenide.cucumber;

        import com.codeborne.selenide.Configuration;
        import com.sinensia.helloselenide.CartPage;
        import com.sinensia.helloselenide.CheckoutPage;
        import com.sinensia.helloselenide.OrderPage;
        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;


        import static com.codeborne.selenide.Condition.*;
        //import static com.codeborne.selenide.Condition.exactText;
        //import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selenide.open;

        import com.codeborne.selenide.logevents.SelenideLogger;
        import io.qameta.allure.selenide.AllureSelenide;
        import org.openqa.selenium.remote.DesiredCapabilities;

        public class RobobarStepDefinitions {
            CartPage cartPage;
            CheckoutPage checkoutPage;
            OrderPage orderPage;

        @Given("user opens robobar website")
        public void userOpensRobobarWebsite() {
        //open("http://localhost:3000");
           // open("https://robobar.sinensia.pw");

            //Configuration.browserSize = "1280x800";
            SelenideLogger.addListener("allure", new AllureSelenide()
                    .screenshots(true)
                    .savePageSource(false)
            );

            //Add VNC
            DesiredCapabilities capabilites = new DesiredCapabilities();
            capabilites.setCapability("enableVNC", true);
            capabilites.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilites;

            open("/");
            cartPage = new CartPage();
            checkoutPage = new CheckoutPage();
            orderPage = new OrderPage();
        }

        // Cola
        @When("user adds a cola")
        public void userAddsACola() {
        cartPage.addCola();
        }

            @Then("total should be €{double}")
            public void totalShouldBe€(Double total) {
                cartPage.total().shouldBe(exactText("€" + String.format("%.2f", total)));
        }


       // Beer
        @When("user adds a beer")
        public void userAddsABeer() {
                cartPage.addBeer();
        }

        //@Then("total should be €{double}")
        //public void totalShouldBe€(Double total) {
        //    cartPage.total().shouldBe(Condition.exactText("€" + String.format("%.2f", total)));
        //}


        // Wine
        @When("user adds a wine")
        public void userAddsAWine() {
                cartPage.addWine();
                }

                //@Then("total should be €{double}")
                //public void totalShouldBe€(Double total) {
                //    cartPage.total().shouldBe(Condition.exactText("€" + String.format("%.2f", total)));
                //}

                    @And("user checkout")
                    public void userCheckout() {
                        cartPage.checkout();
                    }

                    @And("user inputs age {string}")
                    public void userInputsAge(String age) {
                        checkoutPage.setAge(age);
                    }

                    @And("user order")
                    public void userOrder() {
                        checkoutPage.order();
                    }

                    @Then("message should be {string}")
                    public void messageShouldBe(String msg) {
                        orderPage.getSentMessage().shouldBe(text(msg));
                    }

                    @Then("alert should appear")
                    public void alertShouldAppear() {
                        orderPage.getAlertDiv().shouldNotBe(hidden);
                    }

            @When("user adds {int} cola")
            public void userAddsNCola(int n) {
                for(int i=0; i<n; ++i) {
                    cartPage.addCola();
                }
            }

            @When("user adds {int} beers")
            public void userAddsNBeers(int n) {
                for(int i=0; i<n; ++i) {
                    cartPage.addBeer();
                }
            }

            @When("user adds {int} wines")
            public void userAddsNWines(int n) {
                for(int i=0; i<n; ++i) {
                    cartPage.addWine();
                }
            }

            @When("user adds {int} cola {int} beer {int} wine")
            public void userAddsColaBeerWine(int cola, int beer, int wine) {
                userAddsNCola(cola);
                userAddsNBeers(beer);
                userAddsNWines(wine);
            }


            @When("user is {int} years old")
            public void userIsYearsOld(int age) {
                checkoutPage.setAge(String.valueOf(age));
            }

            @Then("robobar confirms order")
            public void robobarConfirmsOrder() {
                orderPage = checkoutPage.order();
                //orderPage.getAlertDiv().shouldBe(hidden);
                orderPage.getSentMessage().shouldBe(matchText("Coming right up"));
            }

            @Given("user is ready to check out with alcohol")
            public void userIsReadyToCheckOutWithAlcohol() {
                userOpensRobobarWebsite();
                userAddsABeer();
                userCheckout();
            }

            @Then("robobar does not allow checkout")
            public void robobarDoesNotAllowCheckout() {
                orderPage = checkoutPage.order();
                orderPage.getAlertDiv().shouldNotBe(hidden);
            }


        }



