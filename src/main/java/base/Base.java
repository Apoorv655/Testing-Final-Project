package base;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.*;

public class Base {

    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(Base.class);

    public String getUrl() throws IOException {
        Properties prop = new Properties();

      
        String path ="C:\\Users\\Apoorv.1.Singh\\eclipse-workspace\\Final_Project_01\\src\\main\\java\\base\\data.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        }
        return prop.getProperty("url");
    }
}