package sample;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BULK {

	@Test
	public void bulkcreate() throws InterruptedException
	{
	Playwright playwright =Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
			BrowserContext context  = browser.newContext();
			 Page page = browser.newPage();
			 page.navigate("http://localhost:3000/");
			 page.fill("input[name='email']", "demo@local.com");
		      page.fill("input[name='password']", "demo123");
		      page.click("button[type='submit']");
		      page.waitForURL("http://localhost:3000/");
		      page.locator("button.btn.btn-secondary:has(svg.lucide-plus)").waitFor(
		    new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		     // page.locator("//input[@name='todos.0.description']").click();
		      page.locator("button.btn.btn-secondary:has(svg.lucide-plus)").click();	
		    //  page.wait(5000);
		      page.getByPlaceholder("Todo 1 title").fill("New user");
		      page.getByPlaceholder("Todo 1 description").fill("New user description");
		      page.getByPlaceholder("Todo 2 title").fill("New user2");
		      page.getByPlaceholder("Todo 2 description").fill("New user description2");
		      page.getByPlaceholder("Todo 3 title").fill("New user3");
		      page.getByPlaceholder("Todo 3 description").fill("New user description3");
		      page.locator("button[type='submit']:has-text('Create All')").click();
		      Thread.sleep(3000);
		      page.waitForURL("http://localhost:3000/");
		      Locator deleteBtn = page.locator("button.btn.btn-danger.w-full.flex.items-center.justify-center.space-x-2:has(svg.lucide-trash2)");
		      deleteBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		      deleteBtn.click();
		     // page.wait(5000);
		      page.locator("label:has(span:text('New user3')) input[type='checkbox']").first().click();
		      page.locator("div.flex.space-x-3 >> button.btn.btn-danger:has-text('Delete')").click();
		      Thread.sleep(3000);
		      page.locator("button:has-text('Select All')").click();
		      page.locator("div.flex.space-x-3 >> button.btn.btn-danger:has-text('Delete')").click();
		      Thread.sleep(3000);
		    //  page.wait(2000);
	}
}
