package classes.lampdatamigration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindBrFindBrokenLinksExample{
	private WebDriver driver;
	private static int invalidLinksCount;
	private static int validlinkCount;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "W:\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www-test15.vmware.com/security/advisories/VMSA-2015-0004");
		//driver.get("https://www.google.co.in/");
	}

	@Test
	public void validateInvalidLinks() {

		try {
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"));
			System.out.println("Total no. of links are "
					+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						//System.out.println("Verifying the URL:-"+url);
						verifyURLStatus(url);
					} else {
						//System.out.println(url+"is not valid ");
						//invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are "
					+ invalidLinksCount);
			System.out.println("Total no. of valid links are "
					+ validlinkCount);

		} catch (Exception e) {
			//e.printStackTrace();
			
			//System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	public void verifyURLStatus(String URL) {
		if(URL.length()>1)
		{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			//System.out.println(URL);
			
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
			{
				invalidLinksCount++;
				System.out.println(URL+"   is not working ");
			}
			else
			{
				validlinkCount++;
				System.out.println(URL+"   is working ");
			}
		} catch (Exception e) {
			//System.out.println(URL+"   is not working ");
			//e.printStackTrace();
		}
	}
	
	else
	{
		// System.out.println("sorry No Link Found in href attribute of Anchor Tag");
	}
	}
}
