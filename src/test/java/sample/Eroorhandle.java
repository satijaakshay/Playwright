package sample;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Eroorhandle {
  @Test
  public void test401and404() throws InterruptedException {
    try (Playwright pw = Playwright.create()) {
      Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page = browser.newPage();
      
      // Retry 
      String url = "http://localhost:3000/api/todos/invalid";

      for (int i = 1; i <= 3; i++) {
        APIResponse r = page.request().get(url);
        System.out.println("Try " + i + ": " + r.status());
        if (r.ok()) break;
      }

      // 🧩 1️⃣ Test 401 — redirect to login
      page.navigate("http://localhost:3000/");
      page.waitForURL("**/login");
      Assert.assertTrue(page.url().contains("/login"), "401 not handled properly");
      System.out.println(" 401 handled — redirected to login page.");

      // 🧩 2️⃣ Login with valid credentials
      page.fill("input[name='email']", "demo@local.com");
      page.fill("input[name='password']", "demo123");
      page.click("button[type='submit']");
      page.waitForURL("http://localhost:3000/");
      System.out.println(" Logged in successfully.");

      // 🧩 3️⃣ Test 404 — open invalid page
      page.navigate("http://localhost:3000/todo/invalid-id");

      // Wait for the 404 message to appear
      Locator notFoundMsg = page.locator("text=This page could not be found.");
      notFoundMsg.waitFor(new Locator.WaitForOptions().setTimeout(5000));

      // Assert 404 handled correctly
      Assert.assertTrue(notFoundMsg.isVisible(), " 404 message not displayed properly.");
      System.out.println("404 handled — user sees 'This page could not be found.'");

      browser.close();
    }
  }
}
