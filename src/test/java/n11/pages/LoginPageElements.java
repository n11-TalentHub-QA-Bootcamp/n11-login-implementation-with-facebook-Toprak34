package n11.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPageElements {

    public static Target facebookButton = Target.the("login with facebook button")
            .locatedBy("div[class*='facebook_large']");

}
