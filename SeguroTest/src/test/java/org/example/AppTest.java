package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;
    By edadLocalizador=By.name("edad");
    By generoLocalizador=By.name("genero");
    By btn_consultLocalizador=By.name("btn_conusltar");
    By bodySelector =By.cssSelector("body");

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resource/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost");
    }
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(generoLocalizador).sendKeys("masculino");
        driver.findElement(edadLocalizador).sendKeys("18");
        driver.findElement(btn_consultLocalizador).click();
        assertEquals("El valor de la prima anual de seguro de auto según su género y edad es: 2000 dólares",driver.findElement(bodySelector).getText());
        assertTrue( true);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
