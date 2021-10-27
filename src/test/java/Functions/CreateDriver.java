package Functions;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CreateDriver {
    private static String browser;
    private static String os;
    private static String logLevel;
    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");     /**Leer el archivo de propiedades **/


    /** Atributo del log **/
    private static Logger log = Logger.getLogger(CreateDriver.class);

    /******** Initializar la configuración del controlador cuando se crea una instancia de la clase ********/
    private CreateDriver() throws IOException {
        CreateDriver.initConfig();
    }

    /**
     * obtengo la confoguracion del archivo test.properties
     */
    public static WebDriver initConfig() throws IOException {
        WebDriver driver;

        try {
            log.info("***********************************************************************************************************");
            log.info("[ POM Configuration ] - Read the basic properties configuration from: test.properties");
            prop.load(in);
            browser = prop.getProperty("browser");
            os = prop.getProperty("os");
            logLevel = prop.getProperty("logLevel");

        } catch (IOException e) {
            log.error("initConfig Error", e);
        }

        /******** POM Information ********/
        log.info("[ POM Configuration ] - OS: " + os + " | Browser: " + browser + " |");
        log.info("[ POM Configuration ] - Logger Level: " + logLevel);
        log.info("***********************************************************************************************************");

        /****** Load the driver *******/
        driver = WebDriverFactory.createNewWebDriver(browser, os);

        return driver;
    }


}

