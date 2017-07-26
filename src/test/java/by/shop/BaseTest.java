package by.shop;

import by.shop.steps.LaptopsAndAccessoriesPageSteps;
import by.shop.steps.LaptopsPageSteps;
import by.shop.steps.MainPageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.openqa.selenium.WebDriver;

/**
 *
 */

public class BaseTest {

    @Managed
    WebDriver driver;

    @Steps
    MainPageSteps mainPage;

    @Steps
    LaptopsPageSteps laptopPage;

    @Steps
    LaptopsAndAccessoriesPageSteps laptopsAndAccessoriesPage;

    @After
    public void quitDriver() {
        driver.quit();
    }

}
