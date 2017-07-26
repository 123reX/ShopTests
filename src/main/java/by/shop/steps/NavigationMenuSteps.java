package by.shop.steps;

import by.shop.enums.NavigationMenuItems;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import by.shop.pages.NavigationMenu;

/**
 *
 */

public class NavigationMenuSteps extends ScenarioSteps {

    private NavigationMenu onNavigationMenu() {
        return pages().get(NavigationMenu.class);
    }

    @Step
    public void openCompAndLaptop(){
        getDriver().manage().window().maximize();
        onNavigationMenu().open();
    }

    @Step
    public NavigationMenuSteps getMenu(NavigationMenuItems menu){
        onNavigationMenu().getMenu(menu);
        return this;
    }

    @Step
    public void openSubMenu(NavigationMenuItems submenu){
        onNavigationMenu().openSubMenu(submenu);
    }

}
