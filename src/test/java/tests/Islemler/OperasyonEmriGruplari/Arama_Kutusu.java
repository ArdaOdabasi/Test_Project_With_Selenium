package tests.Islemler.OperasyonEmriGruplari;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Arama_Kutusu
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
    public void Search_By_No() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("51");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("51",webDriver.findElement(By.xpath("//td[@aria-label=\"51  No\"]")).getText());
    }

    @Test
    public void Search_By_Wrong_No() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("88");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("Gösterilecek kayıt yok",webDriver.findElement(By.xpath("//tr[@class=\"e-emptyrow\"]")).getText());
    }

    @Test
    public void Search_By_Code() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("545");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("545",webDriver.findElement(By.xpath("//td[@aria-label=\"545  Kod\"]")).getText());
    }

    @Test
    public void Search_By_Wrong_Code() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("77");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("Gösterilecek kayıt yok",webDriver.findElement(By.xpath("//tr[@class=\"e-emptyrow\"]")).getText());
    }

    @Test
    public void Search_By_Description() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("deneme");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("deneme",webDriver.findElement(By.xpath("//td[@aria-label=\"deneme  Açıklama\"]")).getText());
    }

    @Test
    public void Search_By_Wrong_Description() throws InterruptedException
    {
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id=\"OperationOrderGroupGrid_ToolbarSearchBox\"]")).sendKeys("Birinci Operasyon");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class=\"e-searchclear e-search-icon e-icons e-input-group-icon\"]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("Gösterilecek kayıt yok",webDriver.findElement(By.xpath("//tr[@class=\"e-emptyrow\"]")).getText());
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}







