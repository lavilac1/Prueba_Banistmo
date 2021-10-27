package StepDefinitions;

import Functions.CreateDriver;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import cucumber.api.Scenario;
import java.io.IOException;

public class Hooks {
    public static WebDriver driver;
    /**inicializar las variables **/
    Logger log=Logger.getLogger(Hooks.class);
    Scenario scenario=null;

    @Before
    public void initDriver() throws IOException {
        log.info("************");
        log.info("Configuración: Inicialización del driver");
        log.info("************");
        this.scenario =scenario;
        driver= CreateDriver.initConfig();
/**
        log.info("************");
        log.info("Scenario -"+ scenario.getName());
        log.info("************");*/
    }

    @After
    public void tearDown(){
        log.info("***********************************************************************************************************");
        log.info("[ Driver Status ] - Clean and close the intance of the driver");
        log.info("***********************************************************************************************************");
        driver.quit();

    }

}
