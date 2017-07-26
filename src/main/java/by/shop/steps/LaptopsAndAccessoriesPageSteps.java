package by.shop.steps;

import by.shop.pages.LaptopsAndAccessoriesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

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
