package org.example.untitled;

import junit.framework.Assert;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProfessorCourseTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/egorguguckin/Documents/cmcprak/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddProfessorCourseSuccessAndFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/a")).click();
        driver.findElement(By.linkText("Добавить курс для преподавателя")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        driver.findElement(By.xpath("//*[@id=\"professor_course\"]/table/tbody/tr[2]/td/input")).submit();

        String message = "Запись о курсе успешно добавлена";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());

        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/a")).click();
        driver.findElement(By.linkText("Добавить курс для преподавателя")).click();
        Select course2 = new Select(driver.findElement(By.id("courseId")));
        course2.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        driver.findElement(By.xpath("//*[@id=\"professor_course\"]/table/tbody/tr[2]/td/input")).submit();

        String message2 = "Запись о данном курсе уже имеется и преподавателя";
        Assert.assertEquals(message2, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void ViewProfessorCourse() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Информация о преподавателях")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/a")).click();
    }
}
