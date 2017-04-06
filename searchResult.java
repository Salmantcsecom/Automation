package testcases;

/**
 * Created by Shahbaz.Qaiser on 1/9/2017.
 */

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utility.propertyDataFile;
import utility.sendAttachmentInEmail;
import utility.testPdfReport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchResult {
    public headerSection hs;
    private WebDriver driver;
    private homePage hp;
    private menuPage mp;
    private WebDriverWait wait;
    private sendAttachmentInEmail saie;
    private productDetailPage pdp;
    private addToCartPopup atcp;
    private  loginPage lp;
    private  checkoutPage cp;

    private testPdfReport tpf;
    private propertyDataFile pdf;

    List<String> resultList=new ArrayList<String>();
    //create an instance of PdfUtilityClass
    testPdfReport pdfUtility=new testPdfReport();

    @Parameters("browser")

    @BeforeClass
    public void beforeClass(String browser)

    {
        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
           /* hp=new homePage(driver);*/
            pdp =new productDetailPage(driver);
            atcp =new addToCartPopup(driver);
            //lp =new loginPage(driver);
            resultList.add("Step1 \n Open Chrome Browser \n Browser should open \n Browser Opened \n Result:Pass");
            wait = new WebDriverWait(driver, 70);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            /*hp.get();*/
            pdp.get();
            atcp.get();
            //lp.get();
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            pdf = new propertyDataFile();
            System.setProperty("webdriver.chrome.driver",pdf.CHROMEDRIVERPATH);
            driver = new ChromeDriver();
           hp=new homePage(driver);
            pdp =new productDetailPage(driver);
            atcp =new addToCartPopup(driver);
            lp =new loginPage(driver);
            cp =new checkoutPage(driver);
            resultList.add("Step1 \n Open Chrome Browser \n Browser should open \n Browser Opened \n Result:Pass");
            wait = new WebDriverWait(driver, 70);
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            pdp.get();
            atcp.get();
            //lp.get();
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            pdf = new propertyDataFile();
            System.setProperty("webdriver.ie.driver", pdf.IEDRIVERPATH);
            driver = new InternetExplorerDriver();
            hp=new homePage(driver);
            resultList.add("Step1 \n Open Chrome Browser \n Browser should open \n Browser Opened \n Result:Pass");
            wait = new WebDriverWait(driver, 70);
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            hp.get();
            driver.manage().window().maximize();
        }
        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

    }


    @Before
    public void redirectUrl()
    {
        //driver.get("https://corconnect-qa.corcentric.com/");
        propertyDataFile pdf = new propertyDataFile();

    }

  /*  @Test(priority=0)
    public void blankPwd() throws Exception
    {
        System.out.println("1st step .....");
        redirectUrl();
        wait.until(ExpectedConditions.visibilityOf(hp.loginButton));
        System.out.println(pdf.USERNAME);
        hp.loginActivity(pdf.USERNAME, "");
        wait.until(ExpectedConditions.visibilityOf(hp.passwordValidateMsg));
        Assert.assertEquals(hp.getPwdValMsg(), homePage.pwdValMsgText);
        resultList.add("Blank Password");
        resultList.add("Result: Pass");
    }*/


    @Test(priority=0)

    public void HomePageSearch() throws Exception {
        hp.homePageSearch(pdf.HomePageURL,pdf.SearchResult);
    }

    @Test(priority=1)

    public void ProductDetailSearch() throws Exception {
        hp. productDetailSearch(pdf.SearchResult);
    }






    @AfterClass
    public void afterClass()
    {
        try
        {
            //driver.quit();
            Thread.sleep(3000);
            //saie= new sendAttachmentInEmail(driver);
            // saie.sentemail();

        }
        catch (Exception e)
        {
            driver = null;
            System.out.println(e.toString());

        }
    }

}

