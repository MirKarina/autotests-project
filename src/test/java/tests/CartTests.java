package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest {

    @Test(description = "1) Добавление одного товара в корзину")
    public void addOneItemToCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);

        inventory.addBackpackToCart();
        Assert.assertEquals(inventory.getCartBadge(), "1");
    }

    @Test(description = "2) Добавление двух товаров в корзину")
    public void addTwoItemsToCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);

        inventory.addBackpackToCart();
        inventory.addBikeLightToCart();
        Assert.assertEquals(inventory.getCartBadge(), "2");
    }

    @Test(description = "3) Проверка товара в корзине ")
    public void verifySingleItemInCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        CartPage cart = new CartPage(driver, wait);

        inventory.addBackpackToCart();
        inventory.openCart();
        Assert.assertTrue(cart.isBackpackDisplayed());
    }

    @Test(description = "4) Проверка двух товаров в корзине")
    public void verifyTwoItemsInCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        CartPage cart = new CartPage(driver, wait);

        inventory.addBackpackToCart();
        inventory.addBikeLightToCart();
        inventory.openCart();
        Assert.assertTrue(cart.isBackpackDisplayed());
        Assert.assertTrue(cart.isBikeLightDisplayed());
    }

    @Test(description = "5) Удаление товара из корзины")
    public void removeItemFromCartTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver, wait);
        CartPage cart = new CartPage(driver, wait);

        inventory.addBackpackToCart();
        inventory.openCart();

        Assert.assertTrue(cart.isBackpackDisplayed());
        cart.removeBackpack();
        Assert.assertFalse(cart.isBackpackPresent());
    }
}
