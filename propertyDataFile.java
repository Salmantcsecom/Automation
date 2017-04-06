package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by shahbaz on 12/22/2016.
 */
public class propertyDataFile {
    public String URL;
    public String USERNAME;
    public String PASSWORD;
    public String CHROMEDRIVERPATH;
    public String IEDRIVERPATH;
    public String FNAME;
    public  String LNAME;
    public  String  EMAIL;
    public  String ADDRESS;
    public  String MOBILE;
    public  String  CITY;
    public  String DISCOUNT;
    public  String MultipleProduct;
    public  String BinCode;
    public  String EasyPayMobile;
    public  String EasyPayEmail;
    public String JaazCashMobile;
    public  String JazzCashEmail;
    public  String ConfigurableProduct;
    public  String LoginID;
    public  String Password;
    public  String BackendLoginId;
    public  String BackendPassword;
    public  String BackhendURL;
    public String HomePageURL;
    public  String SearchResult;
    public propertyDataFile()
    {
        File file = new File("src/Utility/testData.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.URL = prop.getProperty("URL");
        this.USERNAME = prop.getProperty("USERNAME");
        this.PASSWORD = prop.getProperty("PASSWORD");
        this.FNAME = prop.getProperty("FNAME");
        this.LNAME = prop.getProperty("LNAME");
        this.EMAIL = prop.getProperty("EMAIL");
        this.ADDRESS = prop.getProperty("ADDRESS");
        this.MOBILE = prop.getProperty("MOBILE");
        this.CITY =prop.getProperty("CITY");
        this.DISCOUNT =prop.getProperty("DISCOUNT");
        // this.CHROMEDRIVERPATH = prop.getProperty("CHROMEDRIVERPATH");
        this.CHROMEDRIVERPATH = new File("drivers/chromedriver.exe").getAbsolutePath();
        this.IEDRIVERPATH = prop.getProperty("IEDRIVERPATH");
        this.MultipleProduct=prop.getProperty(("MultipleProduct"));
        this.BinCode=prop.getProperty("BinCode");
        this.EasyPayMobile=prop.getProperty(("EasyPayMobile"));
        this.EasyPayEmail=prop.getProperty(("EasyPayEmail"));
        this.JaazCashMobile=prop.getProperty(("JaazCashMobile"));
        this.JazzCashEmail =prop.getProperty(("JazzCashEmail"));
        this.ConfigurableProduct =prop.getProperty((("ConfigurableProduct")));
        this.LoginID=prop.getProperty(("LoginID"));
        this.Password=prop.getProperty(("Password"));
        this.BackendLoginId=prop.getProperty(("BackendLoginId"));
        this.BackendPassword=prop.getProperty(("BackendPassword"));
        this.BackhendURL=prop.getProperty(("BackhendURL"));
        this.HomePageURL=prop.getProperty(("HomePageURL"));
        this.SearchResult=prop.getProperty(("SearchResult"));
        //System.out.println( file1.getAbsoluteFile());
    }
}
