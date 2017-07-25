package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

/**
 *
 */
public class MainPageSteps extends ScenarioSteps {

    private MainPage onMainPage() {
        return pages().get(MainPage.class);
    }

    @Steps
    public NavigationMenuSteps navMenu;

    @Step
    public void openMainPage(){
        getDriver().manage().window().maximize();
        onMainPage().open();
    }

}
