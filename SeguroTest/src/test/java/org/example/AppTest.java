package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resource/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost");
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
