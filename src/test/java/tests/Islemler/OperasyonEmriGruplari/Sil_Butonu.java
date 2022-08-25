package tests.Islemler.OperasyonEmriGruplari;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sil_Butonu
{
    protected WebDriver webDriver;

    @Before
    public void setUp() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.projesisadvanced.com");
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        webDriver.findElement(By.id("email")).sendKeys("group1@projesis.com");
        webDriver.findElement(By.id("password")).sendKeys("group1");
        webDriver.findElement(By.cssSelector("button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//li[@data-uid=20]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//li[@data-uid=2020]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void Kayit_Sil() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//td[@aria-label=\"10  Kod\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@aria-label=\"Sil\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@class=\"e-control e-btn e-lib e-flat  e-primary\"]")).click();
        Thread.sleep(2000);

        try
        {
            webDriver.findElement(By.xpath("//td[@aria-label=\"10  Kod\"]"));
        }
        catch (NoSuchElementException exception)
        {
            Assert.assertEquals("class org.openqa.selenium.NoSuchElementException", exception.getClass());
        }
    }

    @Test
    public void Silme_Onayi_Reddet() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//td[@aria-label=\"10  Kod\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@aria-label=\"Sil\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@class=\"e-control e-btn e-lib e-flat \"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals("10",webDriver.findElement(By.xpath("//td[@aria-label=\"10  Kod\"]")).getText());
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}