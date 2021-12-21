package n11.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageElements {

    public static Target loginButton = Target.the("login button")
            .located(By.className("btnSignIn"));

    public static Target usernameButton = Target.the("username button")
            .locatedBy(".menuLink.user");

}
