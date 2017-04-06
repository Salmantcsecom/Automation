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
public class productDetailPage extends LoadableComponent<productDetailPage> {



    private WebDriver driver;
    private propertyDataFile pdf;
//non config product url
    public String title="Buy Game Sony GTA V - PS4 Online|Yayvo";
   //config product url

    /*public String title="Buy Purple Cotton Floral Top & Capris - PJ-099-P - Nighty4U| Yayvo";*/

    @FindBy(xpath="//*[@id=\'1650\']")
    public WebElement sizeField;

    @FindBy(xpath="//*[@id=\'product_addtocart_form\']/div[3]/div[4]/div[4]/div/div/input[2]")
    public WebElement quantityField;

    @FindBy(xpath="//*[@id='product_addtocart_form']/div[3]/div[5]/div[4]/button")
    public WebElement buttonAddToCard;

    @FindBy(xpath="//*[@id='product_addtocart_form']/div[3]/div[5]/div[4]/button")
    public WebElement buttonAddToCard1;

    @FindBy (xpath=".//*[@id='product_addtocart_form']/div[3]/div[2]/div[2]")
    public WebElement productStock;

    @FindBy(xpath=".//*[@id='product_addtocart_form']/div[3]/div[1]/h1")
    public WebElement productName;

    @FindBy(xpath=".//*[@id='product_addtocart_form']/div[3]/div[2]/div[1]/div[1]/span")
    public WebElement brandName;

    @FindBy(xpath=".//*[@id='product_addtocart_form']/div[3]/div[2]/div[1]/div[2]/span/a")
    public WebElement vendorName;

    @FindBy(xpath=".//*[@id='product-options-wrapper']/p[1]")
    public WebElement validationMessage;



    public static  String validationMessageText="Please select product option";

    public String getValidationMessage()

    {
        return validationMessage.getText();
    }
    public void configProductUrl(String Url)
    {
        driver.get(Url);
    }


    public productDetailPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }




   public void addToCardActivity()
    {
   /*     sizeField.click();*/
        buttonAddToCard.click();

    }

    public  void addToCardActivityConfig()
    {
        //driver.findElement(By.cssSelector("#\\31 650")).click();
        sizeField.click();
      //  buttonAddToCard.click();

    }

    public void multipleProductUrl(String multipleProduct)
    {
        driver.get(multipleProduct);
    }



   public void setButtonAddToCard()
    {
        buttonAddToCard.click();
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
