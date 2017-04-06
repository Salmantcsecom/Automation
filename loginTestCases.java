package testcases;

/**
 * Created by Shahbaz.Qaiser on 1/9/2017.
 */

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utility.propertyDataFile;
import utility.sendAttachmentInEmail;
import utility.testPdfReport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginTestCases {
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
          /*  hp=new homePage(driver);*/
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

    public void Cod() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
       atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.singleHazirProductDiscount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.placeOrder();
        System.out.println(pdf.URL);
        System.out.println(pdf.USERNAME);
        System.out.println(pdf.PASSWORD);
    }


    @Test(priority=1)
    public void blankUser()
    {
        redirectUrl();
        wait.until(ExpectedConditions.visibilityOf(hp.loginButton));
        hp.loginActivity("", pdf.PASSWORD);
        wait.until(ExpectedConditions.visibilityOf(hp.userIdValidateMsg));
        Assert.assertEquals(hp.getUserIdValMsg(), homePage.userIdValMsgText);
        resultList.add("Blank User Id");
        resultList.add("Result: Pass");
    }

    @Test(priority=2)
    public void blankUserPwd() {
        redirectUrl();
        wait.until(ExpectedConditions.visibilityOf(hp.loginButton));
        hp.loginActivity("", "");
        wait.until(ExpectedConditions.visibilityOf(hp.userIdValidateMsg));
        wait.until(ExpectedConditions.visibilityOf(hp.passwordValidateMsg));
        Assert.assertEquals(hp.getUserIdValMsg(), homePage.userIdValMsgText);
        Assert.assertEquals(hp.getPwdValMsg(), homePage.pwdValMsgText);
        resultList.add("Blank User Id and Password");
        resultList.add("Result: Pass");
    }

    @Test(priority=3)
    public void login() throws Exception {
        redirectUrl();
        wait.until(ExpectedConditions.visibilityOf(hp.loginButton));
        hp.loginActivity(pdf.USERNAME, pdf.PASSWORD);
    //    hs = new headerSection(driver);
      //  wait.until(ExpectedConditions.visibilityOf(hs.linkLogOut));
     //   mp = new menuPage(driver);
       // wait.until(ExpectedConditions.visibilityOf(mp.homePageLabel));
        // hs.clickLinkLogout();
        wait.until(ExpectedConditions.visibilityOf(hp.logoutValidateMsg));
        Assert.assertEquals(hp.getlogoutValMsgText(), homePage.logoutValMsgText);
        resultList.add("Login Cases");
        resultList.add("Expected: User should be able to login");
        resultList.add("Actual: User logged in and Logout");
        resultList.add("Result: Pass");
    }

    @AfterMethod
    public void TearDown() throws COSVisitorException, IOException {
        String timeStamp = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        //add time stamp to the resultList
        resultList.add("Test Ends: " + timeStamp);
        //write the test result pdf file with file name TestResult
        pdfUtility.WriteTestResultToPdfFile("TestResult.pdf", resultList);
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

