package hooks;
import java.io.*;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.cucumber.java.After;
import base.Base;
public class TestHooks extends Base{

	
	private static final Logger log = (Logger) LogManager.getLogger(TestHooks.class);
	
	
	  private static final boolean SCREENSHOT_ON_SUCCESS = true;

@Before
public void setup() {
    log.info("Launching Chrome Browser");
    Base.driver = new ChromeDriver();
    
    // EXPLICIT WAITS
    Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
}
@After
   public void tearDown(Scenario scenario) {
       try {
           if (Base.driver != null) {
               boolean takeShot = scenario.isFailed() || SCREENSHOT_ON_SUCCESS;
               if (takeShot) {
                   byte[] ss = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
                   String shotName = (scenario.isFailed() ? "Failure" : "Success") + " Screenshot";
                   Allure.addAttachment(shotName, new ByteArrayInputStream(ss));
               }
               

               if (scenario.isFailed()) {
                                  log.error("Scenario FAILED: {}", scenario.getName());
                              } else {
                                  log.info("Scenario PASSED: {}", scenario.getName());
                              }

                             
                          }
                      } catch (Exception e) {
                          log.error("Error during tearDown: {}", e.getMessage(), e);
                      } finally {
                          if (Base.driver != null) {
                              log.info("Closing browser...");
                              Base.driver.quit();
                              Base.driver = null;
                          }
                          
                          }   
                      }
    
private boolean isFailed() {
	return false;
}
    
    
}