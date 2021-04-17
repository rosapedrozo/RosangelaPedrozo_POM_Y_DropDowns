package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class BasePage {

    By dropDown = By.xpath("//*[@id=\"select-demo\"]");
    By citiesList = By.id("multi-select");
    By btnFirstSelected = By.id("printMe");

    /***
     * @author Rosangela
     * @description this method will select an option from the days dropdown list on the homepage.
     * @param driver instance of driver.
     * @param day it is the day to be selected.
     */
    public boolean selectDay(WebDriver driver, String day) {
        try {
            Select days = new Select(driver.findElement(dropDown));
            days.selectByVisibleText(day);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    /***
     * @author Rosangela
     * @description this method will select a city from the citiesList on the homepage.
     * @param driver instance of driver.
     * @param city it is the city to be selected.
     */
    public boolean selectCity(WebDriver driver, String city) {
        try {
            Select cities = new Select(driver.findElement(citiesList));
            cities.selectByVisibleText(city);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /***
     * @author Rosangela
     * @description this method will clicking on the First Selected button.
     * @param driver instance of driver.
     */
    public boolean clickFirstSelected(WebDriver driver) {
        try {
            driver.findElement(btnFirstSelected).click();
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}

