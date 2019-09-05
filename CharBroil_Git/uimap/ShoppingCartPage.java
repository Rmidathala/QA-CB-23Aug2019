package uimap;

import org.openqa.selenium.By;

public class ShoppingCartPage {
	
	public static final By continueShopping = By.xpath("//button[@title='Continue Shopping']");
	public static final By lnkProduct = By.xpath("//div[@class='cart-item__title cart-item__cell']/a");
	public static final By selectProductQuantity = By.xpath("//select[@class='form__input-qty']");
	
	public static final By lblSingleItemPrice = By.xpath("//form[@id='update-cart']/div[2]/div[3]/span[2]/span");
	public static final By lblSubTotal = By.xpath("//form[@id='update-cart']/div[2]/div[5]/span[2]/span");
	
	public static final By lnkDeleteProduct = By.xpath("//form[@id='update-cart']/div[2]/div[6]/a/i");
	public static final By lblEmptyShoppingCart = By.xpath("//h1[@class='pod-carousel__title']"); //YOUR SHOPPING CART IS EMPTY...
	public static final By shopicon = By.xpath("//header[@class='lander-hero__header']");
	public static final By selectCountry = By.xpath("//select[@id='country']");
	public static final By selectState = By.xpath("//select[@id='region_id']");                                                //---- 55
	public static final By selectPostalCode = By.xpath("//input[@id='postcode']");													//31902
	public static final By selectCity = By.id("city");
	public static final By btnCalculate = By.xpath("//button[contains(text(),'Calculate')]");
	
	public static final By lblShippingMethodList = By.xpath("//dl[@class='cart__shipping__methods']");
	
	
	public static final By lblShoppingCart = By.xpath("//h1[contains(text(),'Shopping Cart')]");
	public static final By ShoppingCartCount = By.xpath("//*[@class='cart__item cart-item']");
	public static final By imgFirstProduct = By.xpath("(//img[@class='cart-item__image cart-item__image--desktop'])[1]");

	public static final By lnkDeleteSecondProduct = By.xpath("//form[@id='update-cart']/div[3]/div[6]/a");
	public static final By lnkDeleteFirstProduct = By.xpath("//form[@id='update-cart']/div[2]/div[6]/a");
	public static final By listSHoopingCartItem = By.xpath("//form[@id='update-cart']/div");
	
	public static final By iconShoppingCart = By.xpath("//a[contains(@href,'cart')]");
	
	
	public static final By cartCount = By.xpath("//span[@class='header__cart-count']");
	public static final By lblCheckout = By.xpath("//h1[contains(text(),'Checkout')]");

}
