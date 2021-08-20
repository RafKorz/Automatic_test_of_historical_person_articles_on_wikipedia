import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DlugossiusIoannesTest
{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\ChromeDriver91\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://wikipedia.pl");
    }

    @Test
    public void test()
    {
        driver.findElement(By.id("searchInput")).sendKeys("Jan Długosz");
        driver.findElement(By.id("searchButton")).click();;
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[1]/td/table/tbody/tr/td/span")));
    //    Assert.assertEquals(driver, By.xpath("//*[@id=\"firstHeading\"]"));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try{
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
