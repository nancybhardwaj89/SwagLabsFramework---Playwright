package qa.swaglabs.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;

	public Page initBrowser(String browserName) {

		System.out.println("Browser Name is:" + browserName);
		playwright = Playwright.create();
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHandleSIGHUP(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Browser Name is not correct");
			break;
		}
		browsercontext = browser.newContext();
		page = browsercontext.newPage();
		page.navigate("https://swaglabs.in/");
		return page;
	}
}
