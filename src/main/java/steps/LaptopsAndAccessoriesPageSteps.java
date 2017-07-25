package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LaptopsAndAccessoriesPage;

/**
 *
 */
public class LaptopsAndAccessoriesPageSteps extends ScenarioSteps {
    private LaptopsAndAccessoriesPage onLaptopsAndAccessoriesPage() {
        return pages().get(LaptopsAndAccessoriesPage.class);
    }

    @Step
    public void clickNetbooksAndLaptopsLink(){
        onLaptopsAndAccessoriesPage().clickNetbooksAndLaptopsLink();
    }
}
