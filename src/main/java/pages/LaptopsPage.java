package pages;

import decarator.AbstractPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 */
public class LaptopsPage extends AbstractPage {

    @FindBy(xpath = "//span[@data-idgroup='prof_1000'][1]")
    private WebElement moreManufacturesLink;

    @FindBy(name = "price_before")
    private WebElement priceBeforeField;

    @FindBy(name = "price_after")
    private WebElement priceAfterField;

    @FindBy(id = "minnum_1401")
    private WebElement minDiagonalField;

    @FindBy(id = "maxnum_1401")
    private WebElement maxDiagonalField;

    @FindBy(id = "count_item")
    private WebElement numberOfItemsFound;

    @FindBy(xpath = "//div[@id='ModelFilter__NumModelWindow']/div[@data-type='podbor_parametrov']")
    private WebElement showFilterResultsButton;

    @FindBy(xpath = "//div[@class='PanelSetUp__SortItemCount']//span[@class='chzn-single']/span")
    private WebElement maxNumberOfItemsOnPage;

    @FindBy(xpath = "//a[@class='Paging__PageLink ']")
    private List<WebElement> searchPageResults;

    @FindBy(xpath = "//div[@class='ModelList__ModelBlockRow']//span[@itemprop='name']")
    private List<WebElement> itemsOnCurrentPage;

    @FindBy(xpath = "//div[@class='PanelSetUp__SortBlock']")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//span[@class='chzn-drop']//li[@class='active-result result-last']")
    private WebElement sortByPriceDescDropdownValue;

    @FindBy(xpath = "//span[@class='chzn-drop']//li[@class='active-result']")
    private WebElement sortByPriceAscDropdownValue;

    private static final String LAPTOP_MANUFACTURE_CHECKBOX = "//div[@id='Attr_prof_1000']//label[text()='%s']";

    public void selectManufacture(String company){
        if ($(String.format(LAPTOP_MANUFACTURE_CHECKBOX, company)).isCurrentlyVisible()){
            $(String.format(LAPTOP_MANUFACTURE_CHECKBOX, company)).click();
        } else {
            $(moreManufacturesLink).click();
            $(String.format(LAPTOP_MANUFACTURE_CHECKBOX, company)).click();
        }
    }

    private void clearAndSendKeysTo(String text, WebElement element){
        $(element).clear();
        $(element).sendKeys(text);
    }

    public void setPriceBefore(String priceBefore) {
        clearAndSendKeysTo(priceBefore, priceBeforeField);
    }

    public void setPriceAfter(String priceAfter) {
        clearAndSendKeysTo(priceAfter, priceAfterField);
    }

    public void setMinDiagonal(String minDiagonal) {
        clearAndSendKeysTo(minDiagonal, minDiagonalField);
    }

    public void setMaxDiagonal(String maxDiagonal) {
        clearAndSendKeysTo(maxDiagonal, maxDiagonalField);
    }

    public int getNumberOfItemsFound(){
        return Integer.valueOf($(numberOfItemsFound).getText());
    }

    public void clickShowFilterResultsButton(){
        $(showFilterResultsButton).click();
    }

    public int getNumberOfItems(){
        int totalNumberOfItems;
        if ($(maxNumberOfItemsOnPage).isCurrentlyVisible()){
            int maxNumberOfItems =  Integer.valueOf($(maxNumberOfItemsOnPage).getText());
            openLastPageOfResults();
            int numberOfItemsOnLastPage = itemsOnCurrentPage.size();
            totalNumberOfItems = maxNumberOfItems * searchPageResults.size() + numberOfItemsOnLastPage;
            $(searchPageResults.get(0)).click();
        } else {
            totalNumberOfItems = itemsOnCurrentPage.size();
        }
        return totalNumberOfItems;
    }

    public void sortTheResultsByPriceAsc(){
        $(sortByDropdown).click();
        $(sortByPriceAscDropdownValue).click();
    }

    public void sortTheResultsByPriceDesc(){
        $(sortByDropdown).click();
        $(sortByPriceDescDropdownValue).click();
    }

    public String getFirstItemNameOnPage(){
        return $(itemsOnCurrentPage.get(0)).getText();
    }

    public String getLastItemNameOnPage(){
        return $(itemsOnCurrentPage.get(itemsOnCurrentPage.size() - 1)).getText();
    }

    public void openLastPageOfResults(){
        $(searchPageResults.get(searchPageResults.size() - 1)).click();
    }
}
