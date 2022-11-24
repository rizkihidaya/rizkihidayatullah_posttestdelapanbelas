package com.juaracoding.selenium;

import com.juaracoding.rizkihidayatullah.postestdelapanbelas.pageobject.drivers.DriverSingleton;
import com.juaracoding.rizkihidayatullah.postestdelapanbelas.pageobject.pages.Login;
import com.juaracoding.rizkihidayatullah.postestdelapanbelas.pageobject.pages.Search;
import com.juaracoding.rizkihidayatullah.postestdelapanbelas.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearch {
    public static WebDriver driver;
    private Login login;

    private Search search;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL_LOGIN);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        search = new Search();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
//        driver.quit();
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testSearchItem() {

        delay(Constants.DETIK);
        //PreCondition
        login.loginForm("rizki_h1","@rizki03081996");
        delay(Constants.DETIK);
        search.searchItem();
        Assert.assertTrue(search.getTxtDress().contains("DRESS"));
        System.out.println("Test case Search Item");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
