import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class JumpToSectionsTest extends BaseClassTest{

    @Test
    public void jumpToSectionSauces(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        assertEquals("Не сработал переход к разделу Соусы", "Соусы", objMainPage.getButtonText());
    }

    @Test
    public void jumpToSectionFillings(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        assertEquals("Не сработал переход к разделу Начинки", "Начинки", objMainPage.getButtonText());
    }

    @Test
    public void jumpToSectionBuns(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        objMainPage.clickBunsButton();
        assertEquals("Не сработал переход к разделу Булки", "Булки", objMainPage.getButtonText());
    }
}
