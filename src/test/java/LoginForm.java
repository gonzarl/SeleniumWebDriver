import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    private final String EMPTY_USERNAME = "";
    private final String EMPTY_PASSWORD = "";
    private final String VALID_USERNAME = "dumbridge";
    private final String VALID_PASSWORD = "tomriddle";

    private final String INVALID_PASSWORD = "harry";

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button")
    private WebElement login_button;

    @FindBy(id = "estado")
    private WebElement message;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmptyUsername(){
        this.username.sendKeys(EMPTY_USERNAME);
    }

    public void enterValidUsername(){
        this.username.sendKeys(VALID_USERNAME);
    }

    public void enterEmptyPassword(){
        this.password.sendKeys(EMPTY_PASSWORD);
    }

    public void enterValidPassword(){
        this.password.sendKeys(VALID_PASSWORD);
    }

    public void enterInvalidPassword(){
        this.password.sendKeys(INVALID_PASSWORD);
    }

    public void pressLoginButton(){
        this.login_button.click();
    }

    public String getMessage(){
        return message.getText();
    }
}
