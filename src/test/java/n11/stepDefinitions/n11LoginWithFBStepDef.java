package n11.stepDefinitions;

import io.cucumber.java.en.*;
import n11.login.LoginFacebook;
import n11.pages.HomePageElements;
import n11.tasks.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class n11LoginWithFBStepDef {

    Actor actor = Actor.named("Hamza");
    LoginFacebook loginFacebook = new LoginFacebook();


    @Managed
    WebDriver webDriver;


    @Given("user launch browser and open the n11 homepage")
    public void user_launch_browser_and_open_the_n11_homepage() {
        webDriver.manage().window().maximize();
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theN11HomePage());


    }

    @Given("user click to sign in button")
    public void user_click_to_sign_in_button() {
        loginFacebook.performAs(actor);
    }

    @When("user login the n11 valid credentials with facebook")
    public void user_login_the_n11_valid_credentials_with_facebook() {
        loginFacebook.performAsFacebook(actor);
        String email = "bedrajatru@vusra.com";
        String password = "testautomation1234";
        loginFacebook.performAsHandleFacebook(actor, email, password);


    }

    @Then("user verify the logged in successfully")
    public void user_verify_the_logged_in_successfully() {
        actor.attemptsTo(WaitUntil.the(
                HomePageElements.usernameButton, isClickable()).forNoMoreThan(5).seconds()
        );

        actor.should(

                GivenWhenThen.seeThat(the(HomePageElements.usernameButton),
                        containsText("TestAutomation"))

        );

    }

}
