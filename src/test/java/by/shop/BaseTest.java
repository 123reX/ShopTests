package by.shop;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import by.shop.steps.LaptopsAndAccessoriesPageSteps;
import by.shop.steps.LaptopsPageSteps;
import by.shop.steps.MainPageSteps;

/**
 *
 */

@RunWith(SerenityRunner.class)
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
