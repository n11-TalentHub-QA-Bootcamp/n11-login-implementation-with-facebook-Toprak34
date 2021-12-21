package n11.tasks;

import n11.pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theN11HomePage() {
        return Task.where("{0} opens the n11 home page",
                Open.browserOn().the(HomePage.class));
    }
}
