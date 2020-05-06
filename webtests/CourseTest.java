package org.example.untitled;

import org.junit.BeforeClass;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CourseTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddCourseSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Курс успешно добавлен";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseSuccess2() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Спец. курс");
        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Курс успешно добавлен";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();

        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Неправильно задано название курса. Длина имени может быть > 0 и <= 100";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure2() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");

        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не задан год обучения. Год обучения может быть не задан только для спец. курса";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure3() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        driver.findElement(By.id("yearOfStudy")).sendKeys("100");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Неправильно задан год обучения. Год обучения может быть > 0 и < 10";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure4() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");

        driver.findElement(By.id("intensity")).sendKeys("2");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не задан тип курса";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure5() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("20");
        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Неправильно задана интенсивность курса. Интенсивность может быть > 0 и < 20";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddCourseFailure6() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.linkText("Добавить курс")).click();
        driver.findElement(By.id("name")).sendKeys("Практикум на ЭВМ Семинар");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).sendKeys("2");

        driver.findElement(By.id("active1")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Неправильно задан год курса. Год может быть >= 2000 и <= 2100";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void EditCourseSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о курсах")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[7]/a")).click();
        driver.findElement(By.id("yearOfStudy")).clear();
        driver.findElement(By.id("yearOfStudy")).sendKeys("2");
        Select coverage = new Select(driver.findElement(By.id("coverage")));
        coverage.selectByVisibleText("Поток");
        driver.findElement(By.id("intensity")).clear();
        driver.findElement(By.id("intensity")).sendKeys("3");
        driver.findElement(By.id("active2")).click();
        driver.findElement(By.xpath("//*[@id=\"course\"]/table/tbody/tr[7]/td/input")).submit();
        String message = "Курс успешно изменен";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }
}