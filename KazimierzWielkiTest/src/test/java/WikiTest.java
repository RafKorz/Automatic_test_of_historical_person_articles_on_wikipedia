import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WikiTest
{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\ChromeDriver91\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void articleTest()
    {
        driver.findElement(By.id("searchInput")).sendKeys("Kazimierz Wielki");
        driver.findElement(By.id("searchButton")).click();

        Assert.assertEquals(driver.getTitle(), "Kazimierz III Wielki – Wikipedia, wolna encyklopedia");
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://pl.wikipedia.org/wiki/Kazimierz_III_Wielki#Kr%C3%B3lewicz_Kazimierz/");
/*
        try{
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("#toc > ul > li.toclevel-1.tocsection-1 > a > span.toctext")).click();
        Assert.assertEquals(driver.findElement(By.id("Królewicz Kazimierz")), "Królewicz Kazimierz");

 */
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[3]/td/a/img")));
        Assert.assertEquals(false, verifyElementPresent(driver, By.id("oioioi")));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try
        {
            driver.findElement(by);
                    System.out.println("Element exists");
            return true;
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element not exists");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
