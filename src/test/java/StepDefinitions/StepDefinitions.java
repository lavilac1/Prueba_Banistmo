package StepDefinitions;

import Functions.CreateDriver;
import Functions.SeleniumFunctions;
import Functions.WebDriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");


    WebDriver driver;
    /** Inicializo el log **/
    private static Logger log = Logger.getLogger(StepDefinitions.class);


    public  StepDefinitions(){
        driver= Hooks.driver;
    }

    @Given("^Ingreo a la pagina (.*)")
    public void Igotosite(String URL)  {
        log.info("Navigate to: " + URL);
        driver.get(URL);
    }


    @Then("^Clic en productos")
    public void clicEnProductos() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement aplicarButton = driver.findElement(By.xpath("//body/div[@id='main-content']/div[@id='layoutContainers']/div[1]/div[2]/div[1]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
        aplicarButton.click();


    }

    @And("clic en prestamos")
    public void clicEnPrestamos() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement aplicarButton = driver.findElement(By.xpath("//a[contains(text(),'Préstamos')]"));
        aplicarButton.click();
    }

    @And("clic en prestamos de autos")
    public void clicEnPrestamosDeAutos() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement aplicarButton = driver.findElement(By.xpath("//a[contains(text(),'Préstamos de Auto')]"));
        aplicarButton.click();
    }

    @And("clic en tasas y tarifas")
    public void clicEnTasasYTarifas() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement aplicarButton = driver.findElement(By.xpath("//a[contains(text(),'Tasas y tarifas')]"));
        aplicarButton.click();
    }

    @And("clic en prohibiciones")
    public void clicEnProhibiciones() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement aplicarButton = driver.findElement(By.cssSelector("body.toolbar-closed:nth-child(13) div.wpthemeLayoutContainers.wpthemeLayoutContainersHidden:nth-child(2) div.wpthemeInner div.component-control.id-Z7_8252I1C0MO0OF0ABLVQR7TGHV7:nth-child(2) section.ibmPortalControl.wpthemeControl.wpthemeHidden.a11yRegionTarget:nth-child(2) div.wpthemeControlBody.wpthemeOverflowAuto.wpthemeClear div.container-fluid.none:nth-child(2) div.row div.col-xs-12 div.tabs-verticales.container-fluid.tabs-horizontal div.row div.tab-content.responsive.col-sm-9.hidden-xs.hidden-sm div.tab-pane.active:nth-child(4) table.table-responsive:nth-child(2) tr:nth-child(2) td:nth-child(2) span.bt-content a:nth-child(1) > img:nth-child(1)"));
        aplicarButton.click();
    }
}
