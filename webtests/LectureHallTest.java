package org.example.untitled;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LectureHallTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddLectureHallSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация об аудиториях")).click();
        driver.findElement(By.linkText("Добавить аудиторию")).click();
        driver.findElement(By.id("number")).sendKeys("328");
        driver.findElement(By.id("capacity")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"lectureHall\"]/table/tbody/tr[3]/td/input")).submit();

        String message = "Аудитория успешно добавлена";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddLectureHallFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация об аудиториях")).click();
        driver.findElement(By.linkText("Добавить аудиторию")).click();

        driver.findElement(By.id("capacity")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"lectureHall\"]/table/tbody/tr[3]/td/input")).submit();

        String message = "Неправильно задан номер аудитории. Длина номера может быть > 0 и <= 20";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddLectureHallFailure2() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация об аудиториях")).click();
        driver.findElement(By.linkText("Добавить аудиторию")).click();
        driver.findElement(By.id("number")).sendKeys("328");
        driver.findElement(By.id("capacity")).sendKeys("10000");
        driver.findElement(By.xpath("//*[@id=\"lectureHall\"]/table/tbody/tr[3]/td/input")).submit();

        String message = "Неправильно задана вместимость аудитории. Вместимость может быть > 0 и < 2000";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void EditLectureHallSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация об аудиториях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/a")).click();
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys("329");
        driver.findElement(By.id("capacity")).clear();
        driver.findElement(By.id("capacity")).sendKeys("120");
        driver.findElement(By.xpath("//*[@id=\"lecture_hall\"]/table/tbody/tr[3]/td/input")).submit();

        String message = "Аудитория успешно изменена";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void ViewLectureHallTimetable() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация об аудиториях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/a")).click();
    }
}
