package org.example;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(DataProviderRunner.class)
public class AppTest 
{
    private WebDriver driver;
//  Localizadores
    By edadLocalizador=By.name("edad");
    By generoLocalizador=By.name("genero");
    By btn_consultLocalizador=By.name("btn_conusltar");
    By bodySelector =By.cssSelector("body");

    @DataProvider
    public static Object[][] proveedorDAtos(){
        return new Object[][] {
                {"masculino","18","El valor de la prima anual de seguro de auto según su género y edad es: 2000 dólares"},
                {"masculino","24","El valor de la prima anual de seguro de auto según su género y edad es: 2000 dólares"},
                {"masculino","25","El valor de la prima anual de seguro de auto según su género y edad es: 1000 dólares"},
                {"masculino","64","El valor de la prima anual de seguro de auto según su género y edad es: 1000 dólares"},
                {"masculino","65","El valor de la prima anual de seguro de auto según su género y edad es: 1500 dólares"},
                {"femenino","18","El valor de la prima anual de seguro de auto según su género y edad es: 500 dólares"},
                {"femenino","24","El valor de la prima anual de seguro de auto según su género y edad es: 500 dólares"},
                {"femenino","25","El valor de la prima anual de seguro de auto según su género y edad es: 500 dólares"},
                {"femenino","64","El valor de la prima anual de seguro de auto según su género y edad es: 500 dólares"},
                {"masculino","-12","La edad no puede ser un valor negativo"},
                {"femenino","-12","La edad no puede ser un valor negativo"},
                {"masculino","$$","Debe ingresar valores numéricos en el campo edad"},
                {"masculino","$$","Debe ingresar valores numéricos en el campo edad"},
                {"masculino","","Debe ingresar su edad para poder realizar la cotización"},
                {"masculino","0","La edad del cotizante debe ser mayor o igual a 18 años"},
                {"masculino","17","La edad del cotizante debe ser mayor o igual a 18 años"},
        };
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resource/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost");
    }
    @Test
    @UseDataProvider("proveedorDAtos")
    public void testConsultaPrimaAnual(String _genero,String _edad,String _salidaEsperada) {
//    public void shouldAnswerWithTrue(String _genero,String _edad,String _salidaEsperada) throws InterruptedException {
//        Thread.sleep(1000);
        driver.findElement(generoLocalizador).sendKeys(_genero);
        driver.findElement(edadLocalizador).sendKeys(_edad);
        driver.findElement(btn_consultLocalizador).click();
        assertEquals(_salidaEsperada,driver.findElement(bodySelector).getText());

//        driver.findElement(generoLocalizador).sendKeys("masculino");
//        driver.findElement(edadLocalizador).sendKeys("18");
//        driver.findElement(btn_consultLocalizador).click();
//        assertEquals("El valor de la prima anual de seguro de auto según su género y edad es: 2000 dólares",driver.findElement(bodySelector).getText());
        assertTrue( true);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
