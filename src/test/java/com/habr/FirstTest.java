package com.habr;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//test
public class FirstTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://habr.com/ru/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tabs")));

        WebElement linkToCompany = driver.findElement(By.className("tabs"));
        linkToCompany.findElement(By.cssSelector("[href=\"https://habr.com/ru/companies/\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companies_suggest")));
        driver.findElement(By.id("companies_suggest")).sendKeys("DINS");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"https://habr.com/ru/company/dins/\"]")));
        driver.findElement(By.cssSelector("[href=\"https://habr.com/ru/company/dins/\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"https://habr.com/ru/company/dins/profile/\"]")));
        WebElement linkToProfile = driver.findElement(By.className("tabs"));
        linkToProfile.findElement(By.cssSelector("[href=\"https://habr.com/ru/company/dins/profile/\"]")).click();

        WebElement profSec = driver.findElement(By.className("profile-section"));
        profSec.findElement(By.xpath("//*[contains(.,'О компании')]"));
        profSec.findElement(By.xpath("//*[contains(.,'Ключевые технологии:')]"));

        WebElement defList = driver.findElement(By.className("defination-list"));
        defList.findElement(By.xpath("//*[contains(.,'1998 год')]"));

        driver.findElement(By.cssSelector("body > div.layout > div.layout__row.layout__row_footer > div > div > div.footer-grid__item.footer-grid__item_link.footer-grid__item_lang > a")).click();

        WebElement popup = driver.findElement(By.className("popup"));
        popup.findElement(By.cssSelector("#hl_langs_en+label")).click();
        popup.findElement(By.xpath("//*[@id=\"lang-settings-form\"]/div/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tabs")));

        WebElement tabs = driver.findElement(By.className("tabs"));

        WebElement prof = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/profile/\"]"));
        prof.findElement(By.xpath("//*[contains(.,'Profile')]"));

        WebElement blog = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/blog/\"]"));
        blog.findElement(By.xpath("//*[contains(.,'Blog')]"));

        WebElement news = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/news/\"]"));
        news.findElement(By.xpath("//*[contains(.,'News')]"));

        WebElement vacancies = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/vacancies/\"]"));
        vacancies.findElement(By.xpath("//*[contains(.,'Vacancies')]"));

        WebElement subs = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/fans/\"]"));
        subs.findElement(By.xpath("//*[contains(.,'Subscribers')]"));

        WebElement emp = tabs.findElement(By.cssSelector("[href=\"https://habr.com/en/company/dins/workers/\"]"));
        emp.findElement(By.xpath("//*[contains(.,'Employees')]"));

        WebElement enList = driver.findElement(By.className("defination-list"));
        enList.findElement(By.xpath("//*[contains(.,'Since 1998')]"));

        driver.quit();








    }

}
