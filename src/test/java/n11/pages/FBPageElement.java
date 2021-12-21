package n11.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FBPageElement {
    public static Target usernameInput = Target.the("facebook email input")
            .located(By.id("email"));

    public static Target passwordInput = Target.the("facebook pass input")
            .located(By.id("pass"));

    public static Target loginButton = Target.the("facebook login button")
            .located(By.name("login"));
}
