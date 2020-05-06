package org.example.untitled;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TimetableEditorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TimetableEditorSuccessAndFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[28]/td[5]/a")).click();
        driver.findElement(By.linkText("Добавить индивидуальное занятие")).click();
        Select clazz = new Select(driver.findElement(By.id("classId")));
        clazz.selectByVisibleText("Дополнительные главы по мат. анализу  курс, Спец. курс");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[2]/td/input")).submit();

        String message = "Занятие добавлено в расписание";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());

        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[28]/td[5]/a")).click();
        driver.findElement(By.linkText("Добавить индивидуальное занятие")).click();
        Select clazz2 = new Select(driver.findElement(By.id("classId")));
        clazz2.selectByVisibleText("Дополнительные главы по мат. анализу  курс, Спец. курс");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[2]/td/input")).submit();

        String message2 = "Занятие уже есть в расписании";
        Assert.assertEquals(message2, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }
}
