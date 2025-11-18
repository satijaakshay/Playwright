package sample;

import com.microsoft.playwright.*;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.options.WaitForSelectorState;
public class Interview {
	
	@Test
	public void First() throws InterruptedException
	{

Playwright playwright = Playwright.create();
BrowserType browsertype = playwright.chromium();
	Browser browser = browsertype.launch(
		    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)
	);
BrowserContext browsercontext = browser.newContext(); // if  needed same browser multiple tab use browsercontext variable but if want multiple browser every time create new variable
Page page = browsercontext.newPage();
page.navigate("https://www.alterainstitute.com");

String title = page.title();
System.out.println(title);
assert title.equals("Altera Institute: Industry Backed Specialist B-School") ;
Locator wait1 = page.locator("id=pgp-in-applied-marketing-navbar");
wait1.waitFor(new Locator.WaitForOptions().setTimeout(5000));
page.locator("id=pgp-in-applied-marketing-navbar").click();
//Thread.sleep(15000);
page.waitForURL("https://alterainstitute.com/pgp");
String url = page.url();
assert url.equals("https://alterainstitute.com/pgp") ;   
Locator wait2 = page.locator("id=Apply_Now");
wait2.waitFor(new Locator.WaitForOptions().setTimeout(5000));
page.locator("id=Apply_Now").click();
Locator wait3 = page.locator("id=full_name_field");
wait3.waitFor(new Locator.WaitForOptions().setTimeout(5000));
page.locator("id=full_name_field").fill("Akshay");   
page.locator("id=email_field").fill("a@gmail.com"); 
page.locator("id=mobile_number_field").fill("9999999999"); 
page.selectOption("#highest_education_field", "Graduate");
String selectedValue = page.inputValue("#highest_education_field");
assert selectedValue.equals("Graduate");  
Locator wait4 = page.locator("id=continue_field");
wait4.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
Thread.sleep(2000);
page.locator("id=continue_field").click();
}
}
