package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector("[data-test='title']");
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleIsDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    @Step("Добавляем товары в корзину названию")
    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Добавляем товары в корзину по индексу")
    public void addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
    }

    @Step("Проверяем показатели корзины")
    public String checkCounterValue() {
        return driver.findElement(cartCounter).getText();
    }

    @Step("Проверяем цвет показателей корзины")
    public String checkCounterColor() {
        return driver.findElement(cartCounter).getCssValue("background-color");
    }

    @Step("Переходим в корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}