import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.UserApi;
import org.example.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AuthorizationPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class AuthorizationTest extends BaseClassTest {

    @Before
    @Step("beginning")
    public void beginning() {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.clickPersonalAccountButton();
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.clickRegisterButton();
    }

    @Test
    public void checkSuccessfulRegistrationTest(){
        LoginPage objLoginPage = new LoginPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.setInputData(random,random + "@ya.ru", random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//main/div/h2")));
        Assert.assertTrue(objLoginPage.checkLoadingLoginPage());
    }

    @Test
    public void checkBadPasswordErrorRegistrationTest(){
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.setInputData(random,random + "@ya.ru", random1);
        Assert.assertTrue(objAuthorizationPage.isVisibleUncorrectPassInscription());
    }
}
