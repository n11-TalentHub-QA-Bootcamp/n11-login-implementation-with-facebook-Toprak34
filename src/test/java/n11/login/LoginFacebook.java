package n11.login;

import n11.pages.FBPageElement;
import n11.pages.HomePageElements;
import n11.pages.LoginPageElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LoginFacebook implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageElements.loginButton)
        );
    }

    public <T extends Actor> void performAsFacebook(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPageElements.facebookButton, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(LoginPageElements.facebookButton)
        );
    }

    public <T extends Actor> void performAsHandleFacebook(T actor, String emailStr, String passwordStr) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!currentWindowHandle.equals(handle)) {
                driver.switchTo().window(handle);

                actor.attemptsTo(
                        Click.on(FBPageElement.usernameInput),
                        SendKeys.of(emailStr).into(FBPageElement.usernameInput),

                        Click.on(FBPageElement.passwordInput),
                        SendKeys.of(passwordStr).into(FBPageElement.passwordInput),

                        Click.on(FBPageElement.loginButton)
                );
            }
            driver.switchTo().window(currentWindowHandle);
        }

    }

}


