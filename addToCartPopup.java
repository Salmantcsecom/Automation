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
public class addToCartPopup extends LoadableComponent<addToCartPopup> {


    private WebDriver driver;
    private propertyDataFile pdf;


//non config product url
    public String title="Buy Game Sony GTA V - PS4 Online|Yayvo";
    //config product url
   /* public String title="Buy Purple Cotton Floral Top & Capris - PJ-099-P - Nighty4U| Yayvo";
*/
    @FindBy(xpath="//*[@id=\'j2t_ajax_progress\']/div/div[2]/div/div[4]/div[3]/ul/li[2]/button/span/span")
    public WebElement checkoutButton;

    @FindBy(xpath=".//*[@id='j2t_ajax_progress']/div/div[2]/div/div[4]/div[3]/ul/li[1]/button")
    public WebElement continueShoppingButton;

    @FindBy(xpath=".//*[@id='j2t_ajax_progress']/div/div[2]/div/div[4]/button")
    public WebElement updateShoppingCardButton;

    @FindBy (xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[6]/a")
    public WebElement crossproductButton;

    @FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[4]/div/div/input[3]")
    public WebElement increaseProductQuantity;

    @FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[4]/div/div/input[2]")
    public WebElement decreaseProductQuantity;

    @FindBy(xpath="/html/body/div[4]/div/div[2]/div[1]/div/div/div[4]/div/div[4]/div[3]/ul/li[2]/button/span/span")
    public WebElement checkoutMultipleProduct;




    public addToCartPopup(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void proceedToCheckoutActivity()
    {
        checkoutButton.click();

    }

    public void proceecToCheckoutActivity1()
    {
        checkoutMultipleProduct.click();
    }
    public void proceedToContinueShopping()
    {
        continueShoppingButton.click();

    }


    public void setButtonAddToCard()
    {
        checkoutButton.click();
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
