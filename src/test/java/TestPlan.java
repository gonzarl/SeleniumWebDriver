import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Test 1: Usuario y contraseña vacias")
    public static void loginEmptyFields(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterEmptyUsername();
        loginForm.enterEmptyPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String message = loginForm.getMessage();
        Assert.assertEquals("Atención: Debe ingresar un nombre de usuario", message);
    }

    @Test(testName = "Test 2: Usuario valido y contraseña vacia")
    public static void loginEmptyPassword(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterValidUsername();
        loginForm.enterEmptyPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String message = loginForm.getMessage();
        Assert.assertEquals("Atención: El password no puede estar vacío", message);
    }

    @Test(testName = "Test 3: Login exitoso")
    public static void successfullLogin(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterValidUsername();
        loginForm.enterValidPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(driver);
        String welcome = homePage.getWelcomeMessage();
        Assert.assertEquals("Bienvenido a OSTH On-Line", welcome);
    }

    @Test(testName = "Test 4: Usuario valido y contraseña incorrecta")
    public static void unsuccessfullLogin(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterValidUsername();
        loginForm.enterInvalidPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String message = loginForm.getMessage();
        Assert.assertEquals("Atención: El password ingresado no es válido", message);
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
    }
}
