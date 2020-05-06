package org.example.untitled;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StudentTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddStudentSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select  flow = new Select(driver.findElement(By.id("flowId")));
        flow.selectByVisibleText("1");
        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("102");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Данные о студенте успешно добавлены";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();

        driver.findElement(By.id("yearOfStudy")).sendKeys("2");
        Select  flow = new Select(driver.findElement(By.id("flowId")));
        flow.selectByVisibleText("1");
        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("102");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Неправильно задано имя студента. Длина имени может быть > 0 и <= 100";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure2() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.id("yearOfStudy")).sendKeys("15");
        Select  flow = new Select(driver.findElement(By.id("flowId")));
        flow.selectByVisibleText("1");
        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("102");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Неправильно задан курс обучения. Курс может быть > 0 и < 10";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure3() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");

        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("102");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Не выбран поток";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure4() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select  flow = new Select(driver.findElement(By.id("flowId")));
        flow.selectByVisibleText("1");

        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Не выбрана группа";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure5() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Добавить студента")).click();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.id("yearOfStudy")).sendKeys("1");
        Select  flow = new Select(driver.findElement(By.id("flowId")));
        flow.selectByVisibleText("1");
        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("104");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Группа не соответствует потоку";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void EditStudentSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]/a")).click();
        driver.findElement(By.id("fullName")).clear();
        driver.findElement(By.id("fullName")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.xpath("//*[@id=\"student\"]/table/tbody/tr[5]/td/input")).submit();

        String message = "Данные о студенте успешно изменены";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void ViewStudentIndividualTimetable() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[5]/a")).click();

    }

    @Test
    public void ViewStudentGroupTimetable() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о студентах")).click();
        driver.findElement(By.linkText("Поиск по группе")).click();
        Select group = new Select(driver.findElement(By.id("groupId")));
        group.selectByVisibleText("101");
        driver.findElement(By.xpath("//*[@id=\"group\"]/table/tbody/tr[2]/td/input")).click();
        driver.findElement(By.linkText("Расписание группы")).click();
    }
}
