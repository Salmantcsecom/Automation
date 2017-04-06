package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.propertyDataFile;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by HP on 3/29/2017.
 */
public class checkoutPage  extends LoadableComponent<checkoutPage>  {
    private WebDriver driver;
    private propertyDataFile pdf;

    public String title="Online Shopping in Pakistan at Discount Price Karachi, Lahore, Islamabad @ Yayvo";
    //public String title="Yayvo - Online Shopping in Pakistan | Home Shopping Pakistan";

    @FindBy(xpath="//*[@id=\'billing:firstname\']")
    public WebElement firstName;

    @FindBy(xpath="//*[@id=\'billing:lastname\']")
    public WebElement lastName;

    @FindBy(xpath="//*[@id=\'billing:email\']")
    public WebElement emailID;

    @FindBy (xpath="//*[@id=\'billing:street1\']")
    public WebElement streetAdress;

    @FindBy(xpath="//*[@id=\'billing:city\']")
    public WebElement city;

    @FindBy(xpath="//*[@id=\'billing:telephone\']")
    public WebElement mobileNumber;


    @FindBy(xpath="//*[@id=\'review-buttons-container\']/button")
    public WebElement Buy;

    @FindBy(xpath="//*[@id=\'coupon-code\']")
    public WebElement discountCodeInput;

    @FindBy(xpath="//*[@id=\'coupon-apply\']/span/span")
    public WebElement applyDiscountCode;

    @FindBy(xpath="//*[@id=\'s_method_tcs_hazir_large\']")
    public WebElement hazirSelection;

    @FindBy(xpath="//*[@id=\'validationEasypay\']")
    public WebElement creditCardSelection;

    @FindBy(xpath="//*[@id=\'jazzcash_bincode\']")
    public WebElement binCodeTextField;

    @FindBy(xpath="//*[@id=\'apply-bincode\']")
    public WebElement binCodeApply;

    @FindBy(xpath="//*[@id=\'validationEasypay_MA\']")
    public WebElement easyPayMobileAccountSelection;

    @FindBy(xpath="//*[@id=\'Easypay_MA_easypay_mobaccount_mobile\']")
    public WebElement easyPayMobileAccountMobile;

    @FindBy(xpath="//*[@id=\'Easypay_MA_easypay_mobaccount_email\']")
    public WebElement easyPayMobileAccountEmail;

    @FindBy(xpath="//*[@id=\'validationeasypay_voucher\']")
    public WebElement easyPayVoucherSelection;

    @FindBy(xpath="//*[@id=\'easypay_voucher_easypay_voucher_mobile\']")
    public WebElement easyPayVoucherMobile;

    @FindBy(xpath="//*[@id=\'easypay_voucher_easypay_voucher_email\']")
    public WebElement easyPayVoucherEmail;


    @FindBy(xpath="//*[@id=\'checkout-payment-method-load\']/div/div[1]/div[2]/div[1]/i")
    public WebElement payThroughJaazCashSelection;

    @FindBy(xpath="//*[@id=\'validationjazzvoucher\']")
    public WebElement jazzCashVoucherSelection;

    @FindBy(xpath="//*[@id=\'jazzvoucher_jazz_mobile\']")
    public WebElement jaazCashVoucherMobile;

    @FindBy(xpath="//*[@id=\'jazzvoucher_jazz_email\']")
    public WebElement jazzCashVoucherEmail;


    @FindBy(xpath="//*[@id=\'validationjazzwallet\']")
    public WebElement jazzCashMobileAccountSelection;

    @FindBy(xpath="//*[@id=\'jazzwallet_jazz_mobile_wallet\']")
    public WebElement jaazCashMobileAccountM;

    @FindBy(xpath="//*[@id=\'jazzwallet_jazz_email_wallet\']")
    public WebElement jazzCashMobileAccountEmail;

    @FindBy(xpath="//*[@id=\'validationcustomercredit\']")
    public WebElement internalCredit;



    public checkoutPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void singleProductCodeDiscount  (String name,String Lname ,String email,String address,String mobile,String City,String Discount)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();


        /*WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }


    public void singleProductCod(String name,String Lname ,String email,String address,String mobile,String City)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);


        /*WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }


    public void singleHazirProduct  (String name,String Lname ,String email,String address,String mobile,String City)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        hazirSelection.click();


        /*WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }


    public void singleHazirProductDiscount  (String name,String Lname ,String email,String address,String mobile,String City,String Discount)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();
        hazirSelection.click();




        /*WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }

    public void creditCard(String name,String Lname ,String email,String address,String mobile,String City)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        creditCardSelection.click();




        /*WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }

    public void creditCardBinCode(String name,String Lname ,String email,String address,String mobile,String City,String Bin)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        creditCardSelection.click();
        binCodeTextField.sendKeys(Bin);
        binCodeApply.click();
        /*String actual_msg=driver.findElement(By.id("notice-jazzcash_bincode")).getText();
        System.out.println(actual_msg);
        String expectedmsg ="Discount of Rs. 2500 has been applied";
        Assert.assertEquals(actual_msg, expectedmsg);*/


    }
    public void easyPayMobileAccount(String name,String Lname ,String email,String address,String mobile,String City,String easypaymobile,String easypayemail)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        easyPayMobileAccountSelection.click();
        easyPayMobileAccountMobile.sendKeys(easypaymobile);
        easyPayMobileAccountEmail.sendKeys(easypayemail);

    }

    public void easyPayVoucher(String name,String Lname ,String email,String address,String mobile,String City,String easypaymobile,String easypayemail)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        easyPayVoucherSelection.click();
        easyPayVoucherMobile.sendKeys(easypaymobile);
       easyPayVoucherEmail.sendKeys(easypayemail);

    }


    public void jazzCashVoucher(String name,String Lname ,String email,String address,String mobile,String City)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);

    }


    public void jazzCashMobileAccount(String name,String Lname ,String email,String address,String mobile,String City)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);


    }

    public void creditCardDiscountCode(String name,String Lname ,String email,String address,String mobile,String City,String Discount)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();





        /*WebElement element = (new WebDriverWait(driver, 10))
             .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();*/


    }

    public void creditCardApplyAfterDiscount()
    {
        creditCardSelection.click();
    }

    public void creditCardBinCodeDiscountCoupon(String name,String Lname ,String email,String address,String mobile,String City,String Discount)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();

        /*String actual_msg=driver.findElement(By.id("notice-jazzcash_bincode")).getText();
        System.out.println(actual_msg);
        String expectedmsg ="Discount of Rs. 2500 has been applied";
        Assert.assertEquals(actual_msg, expectedmsg);*/


    }

    public void creditCardBinApplyAfterDiscount(String Bin)
    {
        creditCardSelection.click();
        binCodeTextField.sendKeys(Bin);
        binCodeApply.click();
    }

    public void easyPayMobileAccountDiscountCode(String name,String Lname ,String email,String address,String mobile,String City,String Discount)
    {


        firstName.sendKeys(name);
        lastName.sendKeys(Lname);
        emailID.sendKeys(email);
        streetAdress.sendKeys(address);
        Select dropdown = new Select(city);
        dropdown.selectByVisibleText(City);
        mobileNumber.sendKeys(mobile);
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();


    }
    public void easyPayMobileApplyAfterDiscount(String easypaymobile,String easypayemail)
    {

        easyPayMobileAccountSelection.click();
        easyPayMobileAccountMobile.sendKeys(easypaymobile);
        easyPayMobileAccountEmail.sendKeys(easypayemail);

    }
    public void easyPayVoucherApplyAfterDiscount(String easypaymobile,String easypayemail){

        easyPayVoucherSelection.click();
        easyPayVoucherMobile.sendKeys(easypaymobile);
        easyPayVoucherEmail.sendKeys(easypayemail);
    }

    public  void LoginDiscount(String Discount)
    {
        discountCodeInput.sendKeys(Discount);
        applyDiscountCode.click();
    }
    public void LoginHazirSelection()
    {
        hazirSelection.click();
    }
    public  void LoginCreditCardSelection()
    {
        creditCardSelection.click();
    }
    public void LoginCreditCardBinCodes(String Bin)
    {
        creditCardSelection.click();
        binCodeTextField.sendKeys(Bin);
        binCodeApply.click();
    }

    public void LoginEasyPayMobileAccount(String easypaymobile,String easypayemail)
    {
        easyPayMobileAccountSelection.click();
        easyPayMobileAccountMobile.sendKeys(easypaymobile);
        easyPayMobileAccountEmail.sendKeys(easypayemail);
    }
    public void  LoginEasyPayVoucher(String easypaymobile,String easypayemail){
        easyPayVoucherSelection.click();
        easyPayVoucherMobile.sendKeys(easypaymobile);
        easyPayVoucherEmail.sendKeys(easypayemail);

    }

    public void  payThroughJazzCashSelection ()
    {
        payThroughJaazCashSelection.click();
    }

    public  void LoginJaazCashMobileAccount(String jazzcashmobile,String jaazcashemail){
        jazzCashMobileAccountSelection.click();
        jaazCashMobileAccountM.sendKeys(jazzcashmobile);
        jazzCashMobileAccountEmail.sendKeys(jaazcashemail);
    }
    public  void LoginJaazCashVoucher(String jazzcashmobile,String jaazcashemail)
    {
        jazzCashVoucherSelection.click();
        jaazCashVoucherMobile.sendKeys(jazzcashmobile);
        jazzCashVoucherEmail.sendKeys(jaazcashemail);
    }
    public void hazirSelection()
    {
        hazirSelection.click();
    }

    public  void CreditCardSelection()
    {
        creditCardSelection.click();
    }




    public  void internalCreditLogin()
    {
        internalCredit.click();
    }





    public  void placeOrder ()
    {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(Buy));
        element.click();
    }

    public void setButtonAddToCard()
    {
        Buy.click();
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
