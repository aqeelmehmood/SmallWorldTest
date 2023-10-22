package appHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class ApplicationHooks {
	
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
  //  private ExtentReports extent;
    //private ExtentTest extentTest;
 //   private boolean scenarioFailed = false;

	
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.init_prop();
		
		
	}
	@Before(order=1)
	public void launchBrowser() throws IOException {
		prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            try {
                // Define the directory and file path where you want to save the screenshot
                String screenshotPath = "C:\\Aqeel_Data\\Java_Projects\\Screenshots";
                File screenshotFile = new File(screenshotPath + "screenshot.png");
                // Use Apache Commons IO to save the screenshot to the file
                FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }		
	
	}


