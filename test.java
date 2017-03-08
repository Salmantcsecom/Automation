package jenkins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) {
		
		
System.setProperty("webdriver.chrome.driver","D:\\TCS\\Selenium\\chromedriver.exe"); 
		
WebDriver driver = new ChromeDriver(); 				
driver.get("http://examine.yayvo.com/vr-box-with-remote-nationwide.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[5]/div[4]/button")).click();
driver.findElement(By.xpath("//*[@id='j2t_ajax_progress']/div/div[2]/div/div[4]/div[3]/ul/li[2]/button")).click();
//driver.findElement(By.xpath("//*[@id='email']")).sendKeys("salman.zaheer.test@hotmail.com");
//driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("tcsecom");
//driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[6]/div/div[1]/div/div/a")).click();
driver.findElement(By.className("sel-new-account-create-button")).click();
List<WebElement> List_inputs = driver.findElements(By.tagName("input"));
ArrayList<String> AllFormInputIDs = new ArrayList<String>() ;
for(WebElement inputID: List_inputs){
    if(!inputID.getAttribute("id").equals(""))
        AllFormInputIDs.add(inputID.getAttribute("id"));
}
int i=1;
for(String id: AllFormInputIDs){
    System.out.println("ID "+(i++)+": "+id);
}
ArrayList<String> a = new ArrayList<>();
a.add("email_name");
a.add("email_us_email");
a.add("email_url");
a.add("contact");
a.add("url");
a.add("email");
a.add("pass");
a.add("email_address");
a.add("billingcityfound");
a.add("billing:address_id");
a.add("billing:firstname");
a.add("billing:lastname");
a.add("billing:email");
for(int j = 0; j < a.size(); j++){
    System.out.println(j+": "+a.get(j));
}
Collection<String> similar = new HashSet<String>( AllFormInputIDs );
Collection<String> different = new HashSet<String>();
different.addAll( AllFormInputIDs );
different.addAll( a );

similar.retainAll( a );
different.removeAll( similar );

System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", AllFormInputIDs, a, similar, different);



if(List_inputs.size()>35)
{
	System.out.println("New Field is added");
	
}
 String to = "qa.team@tcs-e.com";

    // Sender's email ID needs to be mentioned
    String from = "salman.zaheer@tcs-e.com";

    final String username = "salman.zaheer.test@gmail.com";//change accordingly
    final String password = "salmancs123";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "smtp.gmail.com";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    //props.put("mail.debug", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");
    //props.put("mail.smtp.socketFactory.class",
            //"javax.net.ssl.SSLSocketFactory");

    // Get the Session object.
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

        // Set Subject: header field
        message.setSubject("Testing Subject");

        // Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();

        // Now set the actual message
        String string1 = "The following fields are new \n";
        String string2 = "Regards \n";
        String string3 = "Salman zaheer";
        System.out.println(string1 + string2 + string3 + different);
        messageBodyPart.setText(string1 + string2 + string3 + different);

        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        //messageBodyPart = new MimeBodyPart();
        //String filename = "E:\\Selenium\\selenium.txt";
        // C:/Users/Sami/Desktop/corConnectV1.0/test-output/emailable-report.html
        //C:/Users/Sami/workspace/corconnectv2/test-output/Suite/ChromeTest.html
        // C:\\Users\\Sami\\workspace\\corconnectv2\\test-output\\index.html
       // DataSource source = new FileDataSource(filename);
       // messageBodyPart.setDataHandler(new DataHandler(source));
        //messageBodyPart.setFileName(filename);
        //multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);

        // Send message
        Transport.send(message);

        System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@id='billing:firstname']")).sendKeys("Salman");



		
//driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[6]/div/div[1]/div/div/a")).click();
driver.quit();
		
		
		
		
		
		
		
		 
	}
	 
		// TODO Auto-generated method stub

	}


