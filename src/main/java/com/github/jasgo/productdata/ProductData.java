package com.github.jasgo.productdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductData {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "driver/chromedriver.exe";
    public static ChromeOptions options = new ChromeOptions();

    public static ChromeDriver driver;

    public static void main(String[] args) throws IOException, ParseException {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        options.addArguments("headless");
        driver = new ChromeDriver(options);
//      String name = getProductName("19870415003246");
//      System.out.println(name);
//      getNutrients(name);
    }

    public static String getProductName(String productNumber) throws IOException, ParseException {
        URL url = new URL("http://openapi.foodsafetykorea.go.kr/api/8afc960ac75f4a4e9426/I1250/json/1/1/PRDLST_REPORT_NO=" + productNumber);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            builder.append(s);
        }
        String result = builder.toString();
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result);
        JSONObject json = (JSONObject) ((JSONArray) ((JSONObject)object.get("I1250")).get("row")).get(0);
        return (String) json.get("PRDLST_NM");
    }

    public static void getNutrients(String name) {
        AtomicInteger result = new AtomicInteger(0);
        driver.get("https://various.foodsafetykorea.go.kr/nutrient/simple/search/firstList.do");
        driver.findElement(By.id("searchFoodText")).sendKeys(name + "\n");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.cssSelector("td.tal a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        List<AllFoodData> foodDataList = new ArrayList<>();
        List<WebElement> webList = driver.findElements(By.cssSelector("div[data-skin-food='cell']"));
        List<Integer> nContent = new ArrayList<>();
        webList.forEach(webElement -> {
            String text = webElement.findElements(By.tagName("span")).get(2).getText().trim();
            nContent.add((int) Double.parseDouble(text));
        });
        System.out.println("칼로리: " + nContent.get(0));
        System.out.println("단백질: " + nContent.get(1));
        System.out.println("지방: " + nContent.get(2));
        System.out.println("탄수화물: " + nContent.get(3));
        System.out.println("총당류: " + nContent.get(4));
        System.out.println("나트륨: " + nContent.get(5));
        System.out.println("콜레스테롤: " + nContent.get(6));
        System.out.println("총 포화지방산: " + nContent.get(7));
        System.out.println("트랜스지방산: " + nContent.get(8));

        foodDataList.add(new AllFoodData(name, nContent.get(0), nContent.get(1), nContent.get(2), nContent.get(3), nContent.get(4), nContent.get(5), nContent.get(6), nContent.get(7), nContent.get(8)));
    }

    public static String getProductDescription(String reportNumber) {
        return "";
    }
}
