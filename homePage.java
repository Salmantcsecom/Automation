package pages;

/**
 * Created by Shahbaz.Qaiser on 1/9/2017.
 */

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utility.propertyDataFile;

import static org.testng.AssertJUnit.assertTrue;

//import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class homePage extends LoadableComponent<homePage>
{
    private WebDriver driver;
    private propertyDataFile pdf;

    public String title="corconnect-qa.corcentric.com | Login";
    //public String title="Yayvo - Online Shopping in Pakistan | Home Shopping Pakistan";

    @FindBy(id="txtuserID_I")
    public WebElement loginIdField;

    @FindBy(id="txtPassword_I")
    public WebElement loginPwdField;

    @FindBy (id="btnSubmit_CD")
    public WebElement loginButton;

    @FindBy(id="txtuserID_ETC")
    public WebElement userIdValidateMsg;

    @FindBy(id="txtPassword_ETC")
    public WebElement passwordValidateMsg;

    @FindBy(id="lblMessageLogin")
    public WebElement logoutValidateMsg;
    @FindBy(xpath="/html/body/div[4]/div/div[1]/div[1]/div[1]/form/div[1]/div[1]/input")
    public WebElement searchField;

    @FindBy(xpath="/html/body/div[4]/div/div[1]/div[1]/div[1]/form/div[2]/button")
    public WebElement searchButton;


    /*  @FindBy(xpath ="//label[@for='id']")
      public WebElement IdValidateMsg;

      @FindBy (xpath ="//div[contains(.,'You have successfully logged out')][@class='alert alert-success fade in']")
      public WebElement logoutValidation;

      @FindBy(id="user_remember_me")
      public WebElement loginRememberCheck;*/

    public static  String userIdValMsgText="User ID is required";

    public String getUserIdValMsg()

    {
        return userIdValidateMsg.getText();
    }
    public static  String pwdValMsgText="Password is required";

    public String getPwdValMsg()

    {
        return passwordValidateMsg.getText();
    }

    public static  String logoutValMsgText="Logged out successfully.";

    public String getlogoutValMsgText()

    {
        return logoutValidateMsg.getText();
    }



    // id ='lblMessageLogin'
    // text ='Logged out successfully.'

    public homePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void homePageSearch(String homepage,String searchresult)
    {
        driver.get(homepage);
        searchField.sendKeys(searchresult);
        searchButton.click();

        String Actualtext = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div[3]/div[4]/h1")).getText();
        String Expectedtext ="Search results for 'qmobile'";
        Assert.assertEquals(Expectedtext,Actualtext);

    }

    public void productDetailSearch(String searchresult)
    {
        searchField.sendKeys(searchresult);
        searchButton.click();

        String Actualtext = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div[3]/div[4]/h1")).getText();
        String Expectedtext ="Search results for 'qmobile'";
        Assert.assertEquals(Expectedtext,Actualtext);

    }
    public void loginActivity(String userId, String password)
    {
        loginIdField.clear();
        loginPwdField.clear();
        loginIdField.sendKeys(userId);
        loginPwdField.sendKeys(password);
        loginButton.click();
    }

    public void clickLoginBtn()
    {
        loginButton.click();
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