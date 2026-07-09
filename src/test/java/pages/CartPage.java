package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By backpack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By bikeLight = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By checkout = By.id("checkout");
    private By continueShopping = By.id("continue-shopping");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By removeBikeLight = By.id("remove-sauce-labs-bike-light");

    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    public boolean isBackpackDisplayed(){
        Allure.step("Проверяем наличие Backpack в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(backpack));
        return driver.findElement(backpack).isDisplayed();
    }

    public boolean isBikeLightDisplayed(){
        Allure.step("Проверяем наличие Bike Light в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bikeLight));
        return driver.findElement(bikeLight).isDisplayed();
    }

    public void removeBackpack(){
        Allure.step("Удаляем Backpack");
        wait.until(ExpectedConditions.elementToBeClickable(removeBackpack));
        driver.findElement(removeBackpack).click();
    }

    public void removeBikeLight(){
        Allure.step("Удаляем Bike Light");
        wait.until(ExpectedConditions.elementToBeClickable(removeBikeLight));
        driver.findElement(removeBikeLight).click();
    }

    public void checkout(){
        Allure.step("Нажимаем Checkout");
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        driver.findElement(checkout).click();
    }

    public void continueShopping(){
        Allure.step("Нажимаем Continue Shopping");
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
        driver.findElement(continueShopping).click();
    }

    public boolean isBikeLightPresent(){

        return driver.getPageSource().contains("Sauce Labs Bike Light");
    }
    public boolean isBackpackPresent() {
        return driver.getPageSource().contains("Sauce Labs Backpack");
    }
}


