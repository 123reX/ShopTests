package pages;

import decarator.AbstractPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class LaptopsAndAccessoriesPage extends AbstractPage {

    @FindBy(xpath = "//span[@id='cataloglink-1054']/a")
    private WebElement netbooksAndLaptopsLink;

    public void clickNetbooksAndLaptopsLink(){
        $(netbooksAndLaptopsLink).click();
    }
}
