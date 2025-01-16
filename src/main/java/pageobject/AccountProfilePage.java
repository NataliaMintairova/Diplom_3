package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private WebDriver driver;

    //кнопка Профиль
    private By profileButton = By.xpath(".//a[contains(text(),'Профиль')]");
    //кнопка Выход
    private By exitButton = By.xpath(".//button[contains(text(),'Выход')]");
    //кнопка Конструктор
    private By constructorButton = By.xpath(".//p[contains(text(),'Конструктор')]");
    //логотип
    private By logo = By.xpath(".//div[contains(@class, 'header__logo')]");

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("click Exit Button")
    public void clickExitButton(){
        driver.findElement(exitButton).isEnabled();
        driver.findElement(exitButton).click();
    }

    @Step("check Loading Profile Page")
    public boolean checkLoadingProfilePage(){
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("click Constructor Button")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).isEnabled();
        driver.findElement(constructorButton).click();
    }

    @Step("click Logo")
    public void clickLogo(){
        driver.findElement(logo).isEnabled();
        driver.findElement(logo).click();
    }
}
