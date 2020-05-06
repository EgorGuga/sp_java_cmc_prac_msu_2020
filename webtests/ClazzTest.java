package org.example.untitled;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClazzTest {
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
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        Select professor = new Select(driver.findElement(By.id("professorId")));
        professor.selectByVisibleText("Сорокин Цицерон Валерьевич");
        Select lectureHall = new Select(driver.findElement(By.id("lectureHallId")));
        lectureHall.selectByVisibleText("П-4");
        Select day = new Select(driver.findElement(By.id("clazz.dayOfTheWeek")));
        day.selectByVisibleText("Вторник");
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("10");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("30");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("12");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("05");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Занятие добавлено";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();

        Select professor = new Select(driver.findElement(By.id("professorId")));
        professor.selectByVisibleText("Сорокин Цицерон Валерьевич");
        Select lectureHall = new Select(driver.findElement(By.id("lectureHallId")));
        lectureHall.selectByVisibleText("П-4");
        Select day = new Select(driver.findElement(By.id("clazz.dayOfTheWeek")));
        day.selectByVisibleText("Вторник");
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("10");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("30");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("12");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("05");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не выбран курс";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure2() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");

        Select lectureHall = new Select(driver.findElement(By.id("lectureHallId")));
        lectureHall.selectByVisibleText("П-4");
        Select day = new Select(driver.findElement(By.id("clazz.dayOfTheWeek")));
        day.selectByVisibleText("Вторник");
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("10");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("30");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("12");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("05");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не выбран преподаватель";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure3() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        Select professor = new Select(driver.findElement(By.id("professorId")));
        professor.selectByVisibleText("Сорокин Цицерон Валерьевич");

        Select day = new Select(driver.findElement(By.id("clazz.dayOfTheWeek")));
        day.selectByVisibleText("Вторник");
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("10");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("30");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("12");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("05");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не выбрана аудитория";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure4() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        Select professor = new Select(driver.findElement(By.id("professorId")));
        professor.selectByVisibleText("Сорокин Цицерон Валерьевич");
        Select lectureHall = new Select(driver.findElement(By.id("lectureHallId")));
        lectureHall.selectByVisibleText("П-4");

        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("10");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("30");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("12");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("05");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Не выбран день недели";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void AddStudentFailure5() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.linkText("Добавить занятие")).click();
        Select course = new Select(driver.findElement(By.id("courseId")));
        course.selectByVisibleText("Мат. анализ. Лекция 1 курс, 2020г.");
        Select professor = new Select(driver.findElement(By.id("professorId")));
        professor.selectByVisibleText("Сорокин Цицерон Валерьевич");
        Select lectureHall = new Select(driver.findElement(By.id("lectureHallId")));
        lectureHall.selectByVisibleText("П-4");
        Select day = new Select(driver.findElement(By.id("clazz.dayOfTheWeek")));
        day.selectByVisibleText("Вторник");
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("12");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("05");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("10");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("30");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Время оконачания раньше времени начала";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }

    @Test
    public void EditStudentSuccess() {
        driver.get("http://localhost:8080/webapp");
        driver.findElement(By.linkText("Посмотреть расписание")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[8]/a")).click();
        Select startHour = new Select(driver.findElement(By.id("startHour")));
        startHour.selectByVisibleText("16");
        Select startMinute = new Select(driver.findElement(By.id("startMinute")));
        startMinute.selectByVisibleText("10");
        Select endHour = new Select(driver.findElement(By.id("endHour")));
        endHour.selectByVisibleText("17");
        Select endMinute = new Select(driver.findElement(By.id("endMinute")));
        endMinute.selectByVisibleText("35");
        driver.findElement(By.xpath("//*[@id=\"clazz\"]/table/tbody/tr[7]/td/input")).submit();

        String message = "Занятие изменено";
        Assert.assertEquals(message, driver.findElement(By.xpath("/html/body/p[2]")).getText());
    }
}
