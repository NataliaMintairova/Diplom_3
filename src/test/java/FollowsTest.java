import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.UserApi;
import org.example.UserData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AccountProfilePage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class FollowsTest extends BaseClassTest{
    UserData user;
    @Before
    @Step("set Up")
    public void setUp(){
        RestAssured.baseURI = URL_MAIN_PAGE;
        userApi = new UserApi();
        user = new UserData(random + "@ya.ru", random, random);
        userApi.createUser(user);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLoginAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
    }

    @Test
    public void followPersonalAccountButtonTest() {
    MainPage objMainPage = new MainPage(driver);
    objMainPage.clickPersonalAccountButton();
    AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
    new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'Профиль')]")));
    Assert.assertTrue(objAccountProfilePage.checkLoadingProfilePage());
    }

    @Test
    public void followConstructorButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickConstructorButton();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[contains(text(),'Соберите бургер')]")));
        Assert.assertTrue(objMainPage.isInscriptionCollectBurgerVisible());
    }

    @Test
    public void followLogoTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickLogo();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[contains(text(),'Соберите бургер')]")));
        Assert.assertTrue(objMainPage.isInscriptionCollectBurgerVisible());
    }

    @Test
    public void followExitButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickExitButton();
        LoginPage objLoginPage = new LoginPage(driver);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//main/div/h2")));
        Assert.assertTrue(objLoginPage.checkLoadingLoginPage());
    }
}
