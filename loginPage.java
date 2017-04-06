package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utility.propertyDataFile;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by HP on 3/29/2017.
 */
public class loginPage  extends LoadableComponent<loginPage> {

    private WebDriver driver;
    private propertyDataFile pdf;

    public String title="Checkout";
    //public String title="Yayvo - Online Shopping in Pakistan | Home Shopping Pakistan";

    @FindBy(className="sel-new-account-create-button")
    public WebElement guestLogin;

    @FindBy(xpath=".//*[@id='email']")
    public WebElement emailAddressField;

    @FindBy(xpath=".//*[@id='pass']")
    public WebElement passwordField;

    @FindBy (xpath=".//*[@id='send2']")
    public WebElement loginButton;






    public loginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void guestActivity()
    {
        guestLogin.click();

    }

    public void loginActivity(String loginid,String password)
    {
        emailAddressField.sendKeys(loginid);
        passwordField.sendKeys(password);
        loginButton.click();


    }

    public void setButtonAddToCard()
    {
        guestLogin.click();
    }

    @Override
    protected void isLoaded() throws Error
    {
        assertTrue(driver.getTitle().equals(title));
    }

    @Override
    protected void load()
    {
        pdf = new propertyDataFile();
        driver.get(pdf.URL);
        //System.out.println(propertyDataFile.URL);
    }
   /* protected void load(){}
      driver.get("https://corconnect-qa.corcentric.com/");
    }*/
}
