package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;


    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By title = By.className("title");
    private By sortDropdown = By.className("product_sort_container");

    public InventoryPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void addBackpackToCart(){
        Allure.step("Добавление Sauce Labs Backpack в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(backpack));
        driver.findElement(backpack).click();
    }

    public void addBikeLightToCart(){
        Allure.step("Добавление фонаря в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(bikeLight));
        driver.findElement(bikeLight).click();
    }

    public void openCart(){
        Allure.step("Открытие корзины");
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        driver.findElement(cartButton).click();
    }

    public String getCartBadge(){
        Allure.step("Получение количества товаров в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return driver.findElement(cartBadge).getText();
    }

    public void logout(){
        Allure.step("Выход из аккаунта");
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        driver.findElement(logout).click();
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public boolean isInventoryPageDisplayed(){
        return driver.getCurrentUrl().contains("inventory");
    }
}

