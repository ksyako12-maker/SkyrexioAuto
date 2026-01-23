import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstLoginTest {


    @Test
    public void firstLogin() {
        //открыть бразуер
        //зайдем на сайт https://www.saucedemo.com/

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("user-name")).sendKeys(Keys.CONTROL + "A");

        browser.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@=data-test='password']")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();

        assertTrue(titleIsDisplayed, "Заголовок не виден");


        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");





       /* browser.findElement(By.xpath("//*[@id='user-name']'"));
        browser.findElement(By.cssSelector("[@id='user-name']"));*/


        browser.quit();
    }

    @Test
    public void incorrectLogin() {
        //открыть бразуер
        //зайдем на сайт https://www.saucedemo.com/

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("user-name")).sendKeys(Keys.CONTROL + "A");

        browser.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@=data-test='password']")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();

        assertTrue(titleIsDisplayed, "Заголовок не виден");


        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");





       /* browser.findElement(By.xpath("//*[@id='user-name']'"));
        browser.findElement(By.cssSelector("[@id='user-name']"));*/


        browser.quit();
    }

}