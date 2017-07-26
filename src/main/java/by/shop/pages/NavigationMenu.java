package by.shop.pages;

import by.shop.decarator.AbstractPage;
import by.shop.enums.NavigationMenuItems;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class NavigationMenu extends AbstractPage {

    @FindBy(id = "cataloglink-944")
    public WebElement compNavItem;

    @FindBy(id = "cataloglink-1070")
    public WebElement laptopSubNavItem;

    public void getMenu(NavigationMenuItems menu){
        WebElement menuElement = null;
        switch (menu){
            case COMPUTERS:
                menuElement = compNavItem;
        }
        getMenu(menuElement);
    }

    public void openSubMenu(NavigationMenuItems submenu){
        WebElement subMenuElement = null;
        switch (submenu){
            case LAPTOP:
                subMenuElement = laptopSubNavItem;
        }
        opnSubMenu(subMenuElement);
    }

    private void getMenu(WebElement element){
        Actions selectNavitationMenu = new Actions(getDriver());
        selectNavitationMenu.moveToElement($(element.findElement(By.xpath("./a")))).build().perform();
    }

    private void opnSubMenu(WebElement element){
        $(element).waitUntilVisible();
        $(element.findElement(By.xpath("./a"))).click();
    }
}
