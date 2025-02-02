package pageUIs.nopcommerce;

public class UserLoginPageUI {
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String LOGIN_BUTTON = "xpath=//button[text()='Log in']";
	public static final String EMAIL_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='Email-error' and text()='Please enter your email']";
	public static final String EMAIL_WRONG_ERROR_MESSAGE = "xpath=//span[@id='Email-error' and text()='Wrong email']";;
	public static final String PASSWORD_EMPTY_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors' and contains(.,'Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect')]";
	public static final String PASSWORD_INCORRECT_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors' and contains(.,'Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect')]";
}
