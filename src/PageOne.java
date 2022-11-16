import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PageOne {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();

//		Date currentDate = new Date();
//		String TheActualDate = currentDate.toString().replace(":", "-");
//		
//		TakesScreenshot src = ((TakesScreenshot) driver);
//		File SrcFile = src.getScreenshotAs((OutputType.FILE));
//		File Dest = new File (".//MyPictures//"+TheActualDate+".png");
//		FileUtils.copyFile (SrcFile,Dest);

		List<WebElement> thestudents = driver.findElements(By.tagName("option"));
		int TheTotalNumberOfStudents = thestudents.size();
		System.out.println(TheTotalNumberOfStudents + " this is the orginal naumber.");

		int HowManyItems = 10;
		System.out.println(HowManyItems + " this is the number of items i have removed.");

		for (int i = 0; i < HowManyItems; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}
		List <WebElement> theStudentsAfterRemove = driver.findElements(By.tagName("option"));
		int ActualNumber = theStudentsAfterRemove.size();
		System.out.println(ActualNumber+" this is the new actual number.");

		int ExpectedNumber = TheTotalNumberOfStudents - HowManyItems;
		System.out.println(ExpectedNumber + " this is the number i have expected.");
		
		
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}

}
