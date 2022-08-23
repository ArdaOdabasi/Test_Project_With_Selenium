package tests.Islemler.KaliteIslemleri;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ekle_Butonu
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
        webDriver.findElement(By.xpath("//li[@data-uid=2070]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@tabindex=-1]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void Yeni_Kalite_Kaydi() throws InterruptedException
    {
        webDriver.findElement(By.id("Quantity")).sendKeys("10");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@class=\"e-input-filter e-input\"]")).sendKeys("Yazılımsal");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//button[@type=\"Submit\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("Bu alan boş bırakılamaz" , webDriver.findElement(By.xpath("//div[@class=\"validation-message\"]")).getText());
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}






