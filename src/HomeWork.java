import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();
		
		List <WebElement> myOptions = driver.findElements(By.tagName("option"));
		
		for (int i = 0; i < myOptions.size(); i++) {
			
						if (i % 2 == 0) {
			
							myOptions.get(i).click();
			
							System.err.println("sorry i will remove " + myOptions.get(i).getText());
							driver.findElement(By.id("remove")).click();
			
						} else {
			
							System.out.println(" i will keep " + myOptions.get(i).getText());
						}
			
					}
		Date currentDate = new Date();
		String TheActualDate = currentDate.toString().replace(":", "-");
		
		TakesScreenshot src = ((TakesScreenshot) driver);
		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File (".//MyPictures//"+TheActualDate+".png");
		FileUtils.copyFile (SrcFile,Dest);
			

	}

}
