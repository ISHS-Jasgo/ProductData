package com.github.jasgo.productdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductData {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "driver/chromedriver.exe";
    public static ChromeOptions options = new ChromeOptions();

    public static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        // options.addArguments("headless");

        driver = new ChromeDriver(options);
        driver.get("https://cu.bgfretail.com/product/product.do?category=product&depth2=4&depth3=3");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.executeScript("var count = 0;var interval = setInterval(() => { if(count < 29) {nextPage(1);count++;} else clearInterval(interval) }, 1000)");
        Thread.sleep(60 * 1000);
        List<WebElement> productList = driver.findElements(By.cssSelector("li.prod_list"));
        productList.forEach(product -> {
            WebElement p = product.findElement(By.cssSelector("div.prod_item div.prod_wrap div.prod_text div.name p"));
            String text = p.getAttribute("innerText").contains(")") ? p.getAttribute("innerText").split("\\)")[1] : p.getAttribute("innerText");
            System.out.println(text);
            System.out.println(getProductNumber(text));
        });

    }

    public static int getProductNumber(String name) {
        AtomicInteger result = new AtomicInteger(0);
        driver.get("https://www.foodsafetykorea.go.kr/main.do");
        driver.findElement(By.id("pc_searchTopTerm")).sendKeys(name + "\n");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        List<WebElement> productList = driver.findElements(By.cssSelector("ul.sr_result_list li"));
        if (productList == null) return 0;
        productList.forEach(product -> {
            if (product.findElement(By.cssSelector("span.sr_key_point")).getText().equalsIgnoreCase(name)) {
                String productNumber = product.findElements(By.cssSelector("div.srl_txt a")).get(0).getText();
                result.set(Integer.parseInt(productNumber));
            }
        });
        return result.get();
    }

    public static String getProductDescription(String reportNumber) {
        return "";
    }
}
