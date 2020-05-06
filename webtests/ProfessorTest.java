package org.example.untitled;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProfessorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddProfessorSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.linkText("Добавить преподавателя")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.xpath("//*[@id=\"professor\"]/table/tbody/tr[2]/td/input")).submit();

        String message = "Данные о преподавателе успешно добавлены";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddProfessorFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.linkText("Добавить преподавателя")).click();

        driver.findElement(By.xpath("//*[@id=\"professor\"]/table/tbody/tr[2]/td/input")).submit();

        String message = "Неправильно задано имя преподавателя. Длина имени может быть > 0 и <= 100";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void EditProfessorSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[4]/a")).click();
        driver.findElement(By.id("fullName")).clear();
        driver.findElement(By.id("fullName")).sendKeys("Петров Петр Петрович");
        driver.findElement(By.xpath("//*[@id=\"professor\"]/table/tbody/tr[2]/td/input")).submit();

        String message = "Данные о преподавателе успешно изменены";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

}
