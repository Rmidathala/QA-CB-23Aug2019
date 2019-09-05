package uimap;

import org.openqa.selenium.By;

public class PartFinderPage {

	//Links
	//public static final By linkResultProducts = By.xpath("//div[@class='cb-product-tile']");
	public static final By linkResultProducts = By.xpath("//div[@class='page-title']");
	//public static final By linkResultProductsNotFound = By.xpath("//*[@id='top']/body/div[1]/div/div[6]/div/div/div/div[2]/p");
	public static final By linkResultProductsNotFound = By.cssSelector("p.note-msg");
}
