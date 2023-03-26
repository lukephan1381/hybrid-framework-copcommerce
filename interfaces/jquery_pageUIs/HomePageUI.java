package jquery_pageUIs;

public class HomePageUI {
	public static final String DYNAMIC_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String DYNAMIC_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGE = "css=li.qgrd-pagination-page";
	public static final String DYNAMIC_PAGE_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='text']";
	public static final String DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";
	
	public static final String LOAD_BUTTON = "css=button#load";
}
