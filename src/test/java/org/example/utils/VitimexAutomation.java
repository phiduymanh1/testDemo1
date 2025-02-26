package org.example.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VitimexAutomation {
    @Test
    public void testRegisterAndLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://vitimex.com.vn/");

        // Click vào nút Đăng ký
        driver.findElement(By.linkText("Đăng ký")).click();
        Thread.sleep(2000);


        driver.findElement(By.id("firstName")).sendKeys("Nguyen");
        driver.findElement(By.id("lastName")).sendKeys("An");
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test@1234");


        driver.findElement(By.id("registerButton")).click();
        Thread.sleep(3000);


        assertTrue(driver.getCurrentUrl().contains("account"));


        driver.findElement(By.linkText("Đăng xuất")).click();
        Thread.sleep(2000);


        driver.findElement(By.linkText("Đăng nhập")).click();
        Thread.sleep(2000);

        // Đăng nhập lại bằng tài khoản vừa tạo
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(3000);

        // Xác nhận đăng nhập thành công
        assertTrue(driver.getCurrentUrl().contains("account"));


        driver.quit();
    }
}
