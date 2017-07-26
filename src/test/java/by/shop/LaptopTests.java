package by.shop;

import by.shop.enums.NavigationMenuItems;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class LaptopTests extends BaseTest {

    @Before
    public void setup(){
        mainPage.openMainPage();
        mainPage.navMenu.getMenu(NavigationMenuItems.COMPUTERS).openSubMenu(NavigationMenuItems.LAPTOP);
        laptopsAndAccessoriesPage.clickNetbooksAndLaptopsLink();
    }

    @Test
    public void filtering_by_manufacture_price_and_diagonal(){
        laptopPage.selectManufactures("Lenovo", "HP", "Dell")
                .specifyPricesRange("700", "2500")
                .specifyDiagonalRange("12", "13.4")
                .clickShowTheResult();
                //.shouldSeeTotalItemsFound(72);
        String theCheapestItemName = laptopPage.getCheapestItemAfterAscSortingByPrice();
        laptopPage.shouldSeeTheCheapestItemLastDescSorting(theCheapestItemName);
    }

}
