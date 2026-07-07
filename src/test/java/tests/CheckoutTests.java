package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTest {

    @Test(description = "Успешное оформление заказа")
    public void checkoutTest() {
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver, wait);
        inventory.addBackpackToCart();
        inventory.openCart();

        CartPage cart = new CartPage(driver, wait);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver, wait);
        checkout.fillInformation("John", "Doe", "10001");
        checkout.finishOrder();

        CheckoutCompletePage complete = new CheckoutCompletePage(driver, wait);

        Assert.assertEquals(complete.getSuccessMessage(), "Thank you for your order!");
    }

    @Test(description = "Continue shopping после корзины")
    public void continueFromCartTest() {

        new LoginPage(driver, wait).login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver, wait);
        inventory.addBackpackToCart();
        inventory.openCart();

        CartPage cart = new CartPage(driver, wait);
        cart.continueShopping();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
