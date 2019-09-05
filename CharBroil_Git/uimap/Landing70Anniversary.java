package uimap;
import org.openqa.selenium.By;

public class Landing70Anniversary {

	public static final By lblAnniversaryTitle = By.cssSelector("div.anniversary__title");
	public static final By lblAnniversaryBody = By.cssSelector("div.anniversary__body.row > div");
	public static final By lblAnniversaryBodyLeft = By.cssSelector("div.anniversary__body.row > div:nth-child(1) > p");
	public static final By lblAnniversaryBodyRight = By.cssSelector("div.anniversary__body.row > div:nth-child(2) > p:nth-child(1)");
	
	public static final By lblAnniversaryPagerTitle = By.cssSelector("div.anniversary__pager--title");
	public static final By lblAnniversaryPaginationBullet = By.cssSelector("div.anniversary__pager--number.swiper-pagination-bullet");
	
	public static final By lblAnniversaryPagerSwipperSlider = By.cssSelector("div.slide.swiper-slide");
}
