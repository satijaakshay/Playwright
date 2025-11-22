package sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Interview2 {

	@Test
	public void first() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\satij\\Downloads\\chromedriver-win64\\chromedriver.exe");
		// 2️⃣ Headless mode for Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.alterainstitute.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 String title = driver.getTitle();
	        System.out.println("Page Title: " + title);
	        Assert.assertEquals(title, "Altera Institute: Industry Backed Specialist B-School");
	        WebElement marknav = wait.until(ExpectedConditions.elementToBeClickable(By.id("pgp-in-applied-marketing-navbar")));
	        marknav.click();
	        wait.until(ExpectedConditions.urlToBe("https://alterainstitute.com/pgp"));
	        String url = driver.getCurrentUrl();
	        Assert.assertEquals(url, "https://alterainstitute.com/pgp");
	        WebElement app = wait.until(ExpectedConditions.elementToBeClickable(By.id("Apply_Now")));
	        app.click();
	        WebElement full = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full_name_field")));
	        full.sendKeys("Akshay");
	        driver.findElement(By.id("email_field")).sendKeys("a@gmail.com");
	        driver.findElement(By.id("mobile_number_field")).sendKeys("9999999999");
	        WebElement education = driver.findElement(By.cssSelector("#highest_education_field"));
	        Select select = new Select(education);
	        select.selectByValue("Graduate");
	        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue_field")));
	        Thread.sleep(2000);
	        continueBtn.click();
	        driver.quit();
	}
}
