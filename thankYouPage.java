package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utility.propertyDataFile;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by HP on 3/29/2017.
 */
public class thankYouPage extends LoadableComponent<productDetailPage>
{


    public String title="Online Shopping in Pakistan at Discount Price Karachi, Lahore, Islamabad @ Yayvo";
    private WebDriver driver;
    private propertyDataFile pdf;
    @FindBy(xpath="//*[@id=\'username\']")
    public WebElement backendUsername;
    @FindBy(xpath="//*[@id=\'login\']")
    public WebElement backendPassword;
    @FindBy(xpath="//*[@id=\'loginForm\']/div/div[5]/input")
    public WebElement backendLogin;
    @FindBy(xpath="//*[@id=\'filter_real_order_id\']")
    public WebElement orderSearchField;
    @FindBy(xpath="//*[@id=\'id_ad0d23ae74f288e10f08166d82e9774d\']/span")
    public WebElement orderSearchButton;
    @FindBy(xpath="/html/body/div[4]/div/div[1]/div[2]/ul/li[5]/div/div[2]/div/ul/li[4]/a")
    public WebElement logout;





    public thankYouPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void pageAssertion()
    {
       String actualTitle = driver.getTitle();
        String expectedTitle = "Online Shopping in Pakistan at Discount Price Karachi, Lahore, Islamabad @ Yayvo";
        Assert.assertEquals(expectedTitle, actualTitle);

        String Actualtext = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div/h2")).getText();
        String Expectedtext ="Thank you for your purchase!";
        Assert.assertEquals(Expectedtext,Actualtext);



    }
    public void eassyPayMobileAccountVerfication()
    {
        String Actualtext = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div[1]/div[4]/h1")).getText();
        String Expectedtext ="An error occurred in the process of payment";
        Assert.assertEquals(Expectedtext,Actualtext);
    }
    public void BackendVerification(String login,String password)
    {
        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div/p[1]/span"));
        String strng = element.getText();
        System.out.println(strng);
        //driver.get(backendURL);
        driver.get("https://examine.yayvo.com/index.php/nimda");
        backendUsername.sendKeys(login);
       backendPassword.sendKeys(password);
        backendLogin.click();
        orderSearchField.sendKeys(strng);
        orderSearchButton.click();

    }
    public void logout()
    {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/ul/li[5]/a"));
        builder.moveToElement(element).build().perform();
        logout.click();

    }

    public void pageAssertionCreditCard()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle ="Easypay";
        Assert.assertEquals(expectedTitle, actualTitle);
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div/p[1]/span")));
        System.out.println(element);*/

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
