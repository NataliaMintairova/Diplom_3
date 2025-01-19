import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.UserApi;
import org.example.UserData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AuthorizationPage;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class LoginTest extends BaseClassTest {
    UserData user;
    @Before
    @Step("set Up")
    public void settUp(){
        RestAssured.baseURI = URL_MAIN_PAGE;
        userApi = new UserApi();
        user = new UserData(random + "@ya.ru", random, random);
        Response response = userApi.createUser(user);
    }

    @Test
    public void loginWithLoginAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLoginAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    public void loginWithPersonalAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    public void loginWithRegistrationFormLoginButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.clickLoginButton();
        objLoginPage.setInputData(random + "@ya.ru", random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    public void loginWithPasswordRecoveryButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickPasswordRecoveryButton();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.clickLoginButton();
        objLoginPage.setInputData(random + "@ya.ru", random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }
}
