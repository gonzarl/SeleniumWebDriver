import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//h3[contains(text(), 'Bienvenido a OSTH On-Line')]")
    private WebElement welcome;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage(){
        return welcome.getText();
    }

}
