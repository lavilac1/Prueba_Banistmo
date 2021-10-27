package Functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {
    static String resourceFolder="src/test/java/Software/";

    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");


    /** Inicializo el log **/
    private static Logger log = Logger.getLogger(WebDriverFactory.class);

    /**instancio el WebdriverFacctory**/
    private static WebDriverFactory instance= null;


    /**Metodo para crear el driver**/
    public static WebDriver createNewWebDriver(String browser, String os ) throws IOException {
        WebDriver driver;
        /*prop.load(in);
        resourceFolder=prop.getProperty("resourceFolder");*/


        /** valida si el navegador es firefox**/

        if ("FIREFOX".equalsIgnoreCase(browser)){
            if ("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver.exe" );
            }else {
                System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver.exe" );
            }
            driver= new FirefoxDriver();
        }

        /** valida si el navegador es chrome**/
        else  if ("CHROME".equalsIgnoreCase(browser)){
            if ("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe" );
            }else {
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe" );
            }
            driver= new ChromeDriver();
        }

        /** valida si el navegador es IE**/
        else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)){
            if ("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.ie.driver", resourceFolder+os+"/IEDriverServer.exe" );
            }else {
                System.setProperty("webdriver.ie.driver", resourceFolder+os+"/IEDriverServer.exe" );
            }
            driver= new ChromeDriver();
        }
        /** Si no se selecciono un navegador */
        else {
            log.error("The Driver is not selected property, invalid name: " + browser + ", " + os);
            return null;
        }
        driver.manage().window().maximize();
        return driver;

    }
}
