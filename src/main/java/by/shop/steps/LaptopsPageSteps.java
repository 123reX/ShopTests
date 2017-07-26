package by.shop.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import by.shop.pages.LaptopsPage;

/**
 *
 */
public class LaptopsPageSteps extends ScenarioSteps {

    private LaptopsPage onLaptopsPage() {
        return pages().get(LaptopsPage.class);
    }

    @Step
    public LaptopsPageSteps selectManufactures(String...companies){
        for (String company:companies) {
            onLaptopsPage().selectManufacture(company);
        }
        return this;
    }

    @Step
    public LaptopsPageSteps specifyPricesRange(String priceBefore, String priceAfter){
        onLaptopsPage().setPriceBefore(priceBefore);
        onLaptopsPage().setPriceAfter(priceAfter);
        return this;
    }

    @Step
    public LaptopsPageSteps specifyDiagonalRange(String minDiagonal, String maxDiagonal) {
        onLaptopsPage().setMinDiagonal(minDiagonal);
        onLaptopsPage().setMaxDiagonal(maxDiagonal);
        return this;
    }

    @Step
    public LaptopsPageSteps clickShowTheResult(){
        onLaptopsPage().clickShowFilterResultsButton();
        return this;
    }

    @Step
    public LaptopsPageSteps shouldSeeTotalItemsFound(int totalItems){
        Assert.assertEquals(onLaptopsPage().getNumberOfItems(), totalItems);
        return this;
    }

    @Step
    public LaptopsPageSteps sortTheResultByPriceAsc(){
        onLaptopsPage().sortTheResultsByPriceAsc();
        return this;
    }

    @Step
    public LaptopsPageSteps sortTheResultByPriceDesc(){
        onLaptopsPage().sortTheResultsByPriceDesc();
        return this;
    }

    @Step
    public String getCheapestItemAfterAscSortingByPrice() {
        sortTheResultByPriceAsc();
        return onLaptopsPage().getFirstItemNameOnPage();
    }

    public void shouldSeeTheCheapestItemLastDescSorting(String theCheapestItem) {
        sortTheResultByPriceDesc();
        onLaptopsPage().openLastPageOfResults();
        Assert.assertEquals(onLaptopsPage().getLastItemNameOnPage(), theCheapestItem);
    }
}
