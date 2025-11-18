package sample;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class Firstprogram {
	
	@Test
	public void First() throws InterruptedException
	{

//	Playwright playwright = Playwright.create();
//	BrowserType browsertype = playwright.chromium();
//	Browser browser = browsertype.launch(
//		    new BrowserType.LaunchOptions().setHeadless(false)
//		);
//	BrowserContext browsercontext = browser.newContext(); // if  needed same browser multiple tab use browsercontext variable but if want multiple browser every time create new variable
//	Page page = browsercontext.newPage();
	Page page1 = Playwright.create()
            .chromium()
            .launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"))  // for msedge for microsoft browser 
            .newContext()
            .newPage();
//	page.navigate("https://www.google.com");
	 page1.navigate("https://the-internet.herokuapp.com/dropdown");
	//page1.locator("[placeholder='Search']").fill("playwright");  // using  fill method 
	
	//  using keyboard  type  method   note  page.type is depriciated
	//Locator type = page1.locator("[placeholder='Search']");
 //  type.click();
  //  page1.keyboard().type("Playwright", new Keyboard.TypeOptions().setDelay(200)); 
    
//	System.out.println(page.title());
	//Thread.sleep(5000);
	//System.out.println(page1.title());
	
	//page1.locator("").click();  // to click a button 
	// page1.locator("").check();   // work only for radio button  and checkbox
	// page1.locator("").uncheck();  // done to uncheck checkbox only 
	
	//boolean b = page1.locator("input[type='checkbox']").isChecked();   // to   check if  checkbox is ticked or not
	
	// page1.locator("#dropdown").selectOption("Option 1");   // To Select  drop down by  value 
	 //page1.locator("#dropdown").selectOption(new SelectOption().setIndex(2));  // To select  frop down by  index 
	// Note only work if  there is select tag  in html for drop down 
	
	
	// To handle  custom drop down 
	// Open dropdown
//	page1.locator(".dropdown > button").click();

	// Select option
//	page1.locator(".dropdown ul li:has-text('Banana')").click();
	
	// To focus on a field 
//	page1.locator("").focus(); 
	
	// To take  Screenshot of specific element 
	
	//page1.locator("").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot/logo.png")));
	
	// Take full-page screenshot
	//page1.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot/fullpage.png")).setFullPage(true));
	
	// To get  element  attribute 
//	String type = page1.locator("#someElement").getAttribute("type");
	
	
	// To get   element text 
	//String text = page1.locator("#example").innerText(); // returns ""  blank if element is hidden 
	//String text1 = page1.locator("#example").textContent(); // returns text which is hidden also but no html
	//String html = page1.locator("#example").innerHTML(); // returns Returns HTML markup, not just text.
	
	// To  get complete  content of website , title  ,url 
	//String content = page1.content();
	//String title = page1.title();
	//String url = page1.url();
	
	
	// Date Picker
	//page1.locator("").fill("12/10/2025");
	// page1.keyboard().press("Enter");
	 
	 // Not  enable datepicker 
	// page1.evaluate("document.getElementById('')");
	// page1.evaluate("document.querySelector('')");
	
	 // Single frame 
	//page1.frameLocator("").locator("").fill("a");
	
	//By  Frame Name 
	//Frame frame =page1.frame("Name of Frame");
	//frame.locator("").fill("a");
	
	// Multiple frame 
	//page1.frameLocator("").frameLocator("").locator("").fill("a");

	// handle  action  of multiple window 
	 // 1st approach  When you  dont know how many page open redirect  and unknown popup
//	 Page newPage = context.waitForPage(() -> {
//		    page.locator("").click();});
	 // newPage.waitForLoadState(LoadState.NETWORKIDLE);  // to wait to new page loaded complete and wait for 30 sec
	 // newPage.bringToFront();  // Bring POPUP to front  and also used for switch 
	 
	 // 2nd approach  when you know excatly which pop up will open
//	 Page popup = page.waitForPopup(() -> {
//		    page.locator("").click();});
	 //  page.waitForTimeout(5000);  //  if  you want wait for complete  all pages with user define time
	
	 
	 
	 // To  get  all open pages 
	// Get all open pages
	// List<Page> allPages = context.pages();
	// allPages.size()
	// Page firstPage = allPages.get(0);
	

	 //Keyboard 
//	 page1.keyboard().type("Playwright", new Keyboard.TypeOptions().setDelay(200)); 
//	 page1.keyboard().press("Shift"+"A");
//	 page1.keyboard().down("Shift");
	 
	 // To  store multiple  element 
//	 List<Locator> data = page1.locator("").all();  // it return locator and can any operation want 
	// List<String> datastring = page1.locator("").allTextContents();  // it return string only 
//	 for(data1:data)
//	 {
//		 SOP(data1)
//	 }
	 
	 // Mouse click 
	// Double click
	//page1.locator("").dblclick();
	 // Right click (context click)
	//page1.locator("").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	// mouse hover
	 // page1.locator("").hover();
	 
	 // to  go back 
	// page1.goBack();
	 
	 //  Browser to  record video  fro complete browser context 
	 
 //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("video/test")).setRecordVideoSize(1920,1080));
//	 Page page = context.newPage();
	// page.video().path();  to get  path for video stored 
	 
	 
	 //  To  Download  File 
	 // Wait for download while triggering the download action
     //Download download = page.waitForDownload(() -> {
     //    page.locator("a#downloadButton").click(); });

     // Save the file
   //  String path = "C:\\Users\\Akshay\\Downloads\\" + download.getSuggestedFilename();
    // download.saveAs(path);
	 
	
	 // Set default download folder
//     BrowserContext context = browser.newContext(
//         new Browser.NewContextOptions()
//             .setAcceptDownloads(true)
//             .setDownloadsPath(Paths.get("C:\\Users\\Akshay\\Downloads")));
	 
	 // Upload  Single file 
	 //page.locator("input[type='file']").setInputFiles("C:\\Users\\Akshay\\Documents\\resume.pdf");
	 
	 //upload  multiple file 
//	 page.locator("input[type='file']").setInputFiles(new Path[]{
//			    Paths.get("C:\\Users\\Akshay\\Documents\\photo1.jpg"),
//			    Paths.get("C:\\Users\\Akshay\\Documents\\photo2.jpg")});
	 
	 // Clear  File 
	// page.locator("input[type='file']").setInputFiles(new Path[]{});
	 
	 //  File upload  without input type
	// FileChooser fileChooser = page.waitForFileChooser(() -> {
        // page.locator("").click(); });
	// fileChooser.setFiles("C:\\path\\to\\file.txt");
	 
	 // multiple File with File chooser 
	// FileChooser fileChooser = page.waitForFileChooser(() -> {
     // page.locator("").click(); });
	// fileChooser.setFiles("C:\\path\\to\\file1.txt", "C:\\path\\to\\file2.txt", "C:\\path\\to\\file3.txt");
	 
	 // To  Store  a session  in file .json
	// browserContext.storageState( new BrowserContext.StorageStateOptions().setPath(Paths.get("authenticate.json"))
		//	);

	 //  reuse  above storage 
	 //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("authenticate.json"))
	//		);
	 
	 // Ignore HTTPS  error 
	 /*BrowserContext context = browser.newContext(
             new Browser.NewContextOptions().setIgnoreHTTPSErrors(true)   // <--- ignore HTTPS errors
         ); */
	 
	 //  To  Define  size of  Page 
//	 BrowserContext context = browser.newContext(
//			    new Browser.NewContextOptions()
//			        .setViewportSize(1920, 1080));
	 
	 // Full Screen  work for chromium only google  or edge 
//	Browser browser = playwright.chromium().launch(
//			  new BrowserType.LaunchOptions()
//			       .setHeadless(false)
//	 .setArgs(new String[]{"--start-maximized"}));
//	BrowserContext context = browser.newContext(
//		    new Browser.NewContextOptions()
//		        .setViewportSize(null));
	}
}

