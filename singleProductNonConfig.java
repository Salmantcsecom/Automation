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

public class singleProductNonConfig {
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
       // driver.get("http://examine.yayvo.com/sony-gta-v-ps4.html");
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



//Single product non configurable cod
    @Test(priority=0)

    public void singleProdCod() throws Exception {
       // redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();
        redirectUrl();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.singleProductCod(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();
        //driver.close();
        driver.quit();



        /*String actualTitle = driver.getTitle();
        String expectedTitle = "Online Shopping in Pakistan at Discount Price Karachi, Lahore, Islamabad @ Yayvo";
        Assert.assertEquals(expectedTitle, actualTitle);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div/p[1]/span")));
        System.out.println(element);*/



        /*System.out.println(pdf.URL);
        System.out.println(pdf.USERNAME);
        System.out.println(pdf.PASSWORD);*/
    }
//Single Product non configurable COD discount apply
    @Test(priority=1)

    public void singleProdCoddiscount() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        Thread.sleep(1000);
        cp.singleProductCodeDiscount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.pageAssertion();

    }
    //Single Hazir prooduct non configurable COD
    @Test(priority=2)

    public void singleHazirProduct() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        Thread.sleep(1000);
        cp.singleHazirProduct(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(1000);
        cp.placeOrder();
        //Thread.sleep(10000);
        //typ.pageAssertion();


    }
//Single hazir product non configurable discount apply COD
    @Test(priority=3)

    public void singleHazirProductDiscount() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
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
        Thread.sleep(10000);
        typ.pageAssertion();
        //driver.quit();
    }

//Single product credit card
    @Test(priority=4)

      public void creditCard() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        //Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        wait.until(ExpectedConditions.visibilityOf(cp.creditCardSelection));
        //Thread.sleep(100000);
        cp.creditCard(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
//Single product credit card and bincodes
    @Test(priority=5)

    public void creditCardBINCode() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardBinCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.BinCode);
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();
        driver.quit();

    }
    //single product Easypay mobile account
    @Test(priority=6)

    public void easyPayMobileAccount() throws Exception {

        redirectUrl();


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=7)

    public void easyPayVoucher() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=8)

    public void jazzCashVoucher() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();


    }


    @Test(priority=9)

    public void jazzCashMobileAccount() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashMobileAccount(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(10000);
        cp.placeOrder();
       Thread.sleep(10000);
       typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=10)

    public void creditCardDiscountCode() throws Exception {



        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.creditCardApplyAfterDiscount();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();


    }


    @Test(priority=11)

    public void creditCardBINDiscountCode() throws Exception {



        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardBinCodeDiscountCoupon(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.creditCardBinApplyAfterDiscount(pdf.BinCode);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();


    }

    @Test(priority=12)

    public void easyPayMobileAccountDiscountCode() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        Thread.sleep(1000);
        cp.easyPayMobileAccountDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.easyPayMobileApplyAfterDiscount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=13)

    public void easyPayVoucherDiscountCode() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        Thread.sleep(1000);
        cp.easyPayMobileAccountDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.easyPayVoucherApplyAfterDiscount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();



    }


    @Test(priority=14)

    public void JaazCashMobileAccountDiscountCode() throws Exception {



        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
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

    public void JaazCashVoucherDiscountCode() throws Exception {

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();
        driver.quit();

    }

    @Test(priority=16)

    public void creditCardHazir() throws Exception {



        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCard(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();

    }
    @Test(priority=17)

    public void creditCardBINCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardBinCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.BinCode);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(10000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();


    }

    @Test(priority=18)

    public void easyPayMobileAccountHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=19)

    public void easyPayVoucherHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=20)

    public void jazzCashVoucherHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=21)

    public void jazzCashMobileAccountHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
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
    @Test(priority=22)

    public void creditCardDiscountCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(1000);
        cp.creditCardApplyAfterDiscount();
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();

        Thread.sleep(10000);
        typ.pageAssertionCreditCard();


    }
    @Test(priority=23)

    public void creditCardBINDiscountCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.creditCardBinCodeDiscountCoupon(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.creditCardBinApplyAfterDiscount(pdf.BinCode);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(100000);
        typ.pageAssertionCreditCard();


    }

    @Test(priority=24)

    public void easyPayMobileAccountDiscountCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayMobileAccountDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.easyPayMobileApplyAfterDiscount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }
    @Test(priority=25)

    public void easyPayVoucherDiscountCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.easyPayMobileAccountDiscountCode(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY,pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.easyPayVoucherApplyAfterDiscount(pdf.EasyPayMobile,pdf.EasyPayEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();

    }

    @Test(priority=26)

    public void JaazCashMobileAccountDiscountCodeHazir() throws Exception {



        redirectUrl();
        //lp =new loginPage(driver);
        //lp.get();

        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashMobileAccount(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
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
    @Test(priority=27)

    public void JaazCashVoucherDiscountCodeHazir() throws Exception {


        wait.until(ExpectedConditions.visibilityOf(pdp.buttonAddToCard));
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        pdp.addToCardActivity();
        wait.until(ExpectedConditions.visibilityOf(atcp.checkoutButton));
        atcp.proceedToCheckoutActivity();
        wait.until(ExpectedConditions.visibilityOf(lp.guestLogin));
        lp.guestActivity();
        wait.until(ExpectedConditions.visibilityOf(cp.city));
        //Thread.sleep(1000);
        cp.jazzCashVoucher(pdf.FNAME,pdf.LNAME,pdf.EMAIL,pdf.ADDRESS,pdf.MOBILE,pdf.CITY);
        Thread.sleep(10000);
        cp.LoginDiscount(pdf.DISCOUNT);
        Thread.sleep(10000);
        cp.payThroughJazzCashSelection();
        Thread.sleep(10000);
        cp.LoginJaazCashVoucher(pdf.JaazCashMobile,pdf.JazzCashEmail);
        Thread.sleep(1000);
        cp.hazirSelection();
        Thread.sleep(1000);
        cp.placeOrder();
        Thread.sleep(10000);
        typ.eassyPayMobileAccountVerfication();


    }




    @AfterClass
    public void afterClass()
    {
        try
        {
           // Thread.sleep(1000);
            driver.quit();
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

