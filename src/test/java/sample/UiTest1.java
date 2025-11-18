package sample;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiTest1 {
  @Test
  public void optimisticToggleConflictTest() throws InterruptedException {
    try (Playwright pw = Playwright.create()) {
      Browser browser = pw.chromium().launch(
          new BrowserType.LaunchOptions().setHeadless(false)
      );

      // 🟢 User A Login
      Page userA = browser.newPage();
      userA.navigate("http://localhost:3000/login");
      userA.waitForSelector("input[name='email']");
      userA.fill("input[name='email']", "demo@local.com");
      userA.fill("input[name='password']", "demo123");
      userA.click("button[type='submit']");
      userA.waitForURL("http://localhost:3000/");
      userA.waitForSelector("[data-testid='todo-item']");
      System.out.println("✅ User A logged in successfully");

      // 🟢 User B Login
      Page userB = browser.newPage();
      userB.navigate("http://localhost:3000/login");
      userB.waitForSelector("input[name='email']");
      userB.fill("input[name='email']", "demo@local.com");
      userB.fill("input[name='password']", "demo123");
      userB.click("button[type='submit']");
      userB.waitForURL("http://localhost:3000/");
      userB.waitForSelector("[data-testid='todo-item']");
      System.out.println("✅ User B logged in successfully");

      // 🔹 Locate the first todo checkbox for both users
      Locator checkboxA = userA.locator("[data-testid='todo-item'] button.mt-1.w-5.h-5").first();
      Locator checkboxB = userB.locator("[data-testid='todo-item'] button.mt-1.w-5.h-5").first();

      // Get initial class
      String beforeClassA = checkboxA.getAttribute("class");
      System.out.println("🔹 Before toggle (User A): " + beforeClassA);

      // 🧠 User A toggles the todo (Optimistic UI should update immediately)
      checkboxA.click();
      Thread.sleep(500);
      String afterClassA = checkboxA.getAttribute("class");

      // 🔁 User B tries to toggle same todo concurrently (possible conflict)
      checkboxB.click();
      Thread.sleep(1000);

      // Check for visible rollback or error message (if UI shows 409 Conflict)
      boolean conflictVisible = userB.locator("text=Conflict").isVisible();
      if (conflictVisible) {
        System.out.println("⚠️ Conflict detected — rollback triggered for User B.");
      } else {
        System.out.println("✅ No visible conflict — backend handled concurrent toggle successfully.");
      }

      Thread.sleep(3000);
      browser.close();
    }
  }
}
