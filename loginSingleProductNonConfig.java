package testcases;

/**
 * Created by Shahbaz.Qaiser on 1/9/2017.
 */

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class loginSingleProductNonConfig {
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
    private thankYouPage typ;

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
            pdp =new productDetailPage(driver);
            atcp =new addToCartPopup(driver);
            resultList.add("Step1 \n Open Chrome Browser \n Browser should open \n Browser Opened \n Result:Pass");
            wait = new WebDriverWait(driver, 70);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            pdp.get();
            atcp.get();
            //driver.manage().window().maximize();
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
            typ = new thankYouPage(driver);
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
       // driver.get(pdf.URL);

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



    //Single product non configurable cod
    @Test(priority=0)

    public void singleProdCodLogin() throws Exception {
       // redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();

        //typ.logout();
       /* Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/ul/li[5]/a"));
        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(By.xpath(""));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
*/

    }
    //Single Product non configurable COD discount apply
    @Test(priority=1)

    public void singleProdCoddiscountLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.applyDiscountCode));
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }
    //Single Hazir prooduct non configurable COD
    @Test(priority=2)

    public void singleHazirProductLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
       cp.LoginHazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }
    //Single hazir product non configurable discount apply COD
    @Test(priority=3)

    public void singleHazirProductDiscountLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.applyDiscountCode));
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginHazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }

    //Single product credit card
    @Test(priority=4)

    public void creditCardLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        //Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(cp.creditCardSelection));
        cp.LoginCreditCardSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    //Single product credit card and bincodes
    @Test(priority=5)

    public void creditCardBINCodeLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginCreditCardBinCodes(pdf.BinCode);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    //single product Easypay mobile account
    @Test(priority=6)

    public void easyPayMobileAccountLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
            }

    @Test(priority=7)

    public void easyPayVoucherLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }

    @Test(priority=8)

    public void jazzCashMobileAccountLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
       cp.LoginJaazCashMobileAccount(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }


    @Test(priority=9)

    public void jazzCashVoucherLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }

    @Test(priority=10)

    public void creditCardDiscountCodeLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        //Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(cp.creditCardSelection));
        cp.LoginCreditCardSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }


    @Test(priority=11)

    public void creditCardBINDiscountCodeLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginCreditCardBinCodes(pdf.BinCode);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }

    @Test(priority=12)

    public void easyPayMobileAccountDiscountCodeLogin() throws Exception {


        redirectUrl();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=13)

    public void easyPayVoucherDiscountCodeLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=14)

    public void JaazCashMobileAccountDiscountCodeLogin() throws Exception {


        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashMobileAccount(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=15)

    public void jazzCashVoucherDiscountCodeLogin() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=16)

    public void singleProdCodInternalCreditLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertion();

    }

    @Test(priority=17)

    public void singleProdCoddiscountInternalCreditLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.applyDiscountCode));
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }

    @Test(priority=18)

    public void singleHazirProductInternalCreditLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.LoginHazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }

    @Test(priority=19)

    public void singleHazirProductInternalCreditDiscountLogin() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.applyDiscountCode));
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.LoginHazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
    }
    @Test(priority=20)

    public void creditCardLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        //Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(cp.creditCardSelection));
        cp.LoginCreditCardSelection();
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }

    @Test(priority=21)

    public void creditCardBINCodeLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginCreditCardBinCodes(pdf.BinCode);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    @Test(priority=22)

    public void easyPayMobileAccountLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }

    @Test(priority=23)

    public void easyPayVoucherLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }

    @Test(priority=24)

    public void jazzCashMobileAccountLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashMobileAccount(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }
    @Test(priority=25)

    public void jazzCashVoucherLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
    }
    @Test(priority=26)

    public void creditCardDiscountCodeLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        //Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(cp.creditCardSelection));
        cp.LoginCreditCardSelection();
        Thread.sleep(1000);
        cp.hazirSelection();
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    @Test(priority=27)

    public void creditCardBINDiscountCodeLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginCreditCardBinCodes(pdf.BinCode);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    @Test(priority=28)

    public void easyPayMobileAccountDiscountCodeLoginHazir() throws Exception {


        redirectUrl();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=29)

    public void easyPayVoucherDiscountCodeLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.LoginEasyPayMobileAccount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=30)

    public void JaazCashMobileAccountDiscountCodeLoginHazir() throws Exception {


        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashMobileAccount(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=31)

    public void jazzCashVoucherDiscountCodeLoginHazir() throws Exception {

        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=32)

    public void singleProdCodInternalCreditLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertion();

    }
    @Test(priority=33)

    public void singleProdCoddiscountInternalCreditLoginHazir() throws Exception {
        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.loginButton));
        lp.loginActivity(pdf.LoginID,pdf.Password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.applyDiscountCode));
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.internalCreditLogin();
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
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

