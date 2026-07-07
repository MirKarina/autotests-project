package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {

    @Test(description = "Проверка заголовка страницы Products")
    public void inventoryTitleTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        Assert.assertEquals(inventory.getTitle(), "Products");
    }

    @Test(description = "Проверка выхода из системы")
    public void logoutTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        inventory.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }

    @Test(description = "Проверка, что после Logout нельзя попасть на Inventory")
    public void inventoryUnavailableAfterLogoutTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        inventory.logout();
        driver.get("https://www.saucedemo.com/inventory.html");
        Assert.assertFalse(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(description = "Проверка счетчика корзины после открытия корзины")
    public void cartBadgeAfterOpeningCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        inventory.addBackpackToCart();
        inventory.openCart();
        Assert.assertEquals(inventory.getCartBadge(), "1");
    }
}
