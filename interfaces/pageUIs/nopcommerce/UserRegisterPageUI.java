package pageUIs.nopcommerce;

public class UserRegisterPageUI {
	
	// Locators
	public static final String GENDER_MALE_RADIO = "id=gender-male";
	public static final String GENDER_FEMALE_RADIO = "id=gender-female";
	public static final String FIRSTNAME_TEXTBOX = "id=FirstName";
	public static final String LASTNAME_TEXTBOX = "id=LastName";
	public static final String DAY_DROPDOWN = "name=DateOfBirthDay";
	public static final String MONTH_DROPDOWN = "name=DateOfBirthMonth";
	public static final String YEAR_DROPDOWN = "name=DateOfBirthYear";
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String COMPANY_TEXTBOX = "id=Company";
	public static final String NEWSLETTER_CHECKBOX = "id=Newsletter";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String PASSWORD_CONFIRM_TEXTBOX = "id=ConfirmPassword";
	public static final String REGISTER_BUTTON = "id=register-button";
	public static final String REGISTER_SUCCESS_MESSAGE = "class=result";
	public static final String LOGOUT_LINK = "class=ico-logout";
	public static final String LOGIN_LINK = "class=ico-login";
	public static final String CONTINUE_BUTTON = "xpath=//a[text()='Continue']";
	
	// Error Messages
	public static final String FIRSTNAME_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error' and text()='First name is required.']";
	public static final String LASTNAME_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='LastName-error' and text()='Last name is required.']";
	public static final String EMAIL_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='Email-error' and text()='Email is required.']";
	public static final String EMAIL_WRONG_ERROR_MESSAGE = "xpath=//span[@id='Email-error' and text()='Wrong email']";
	public static final String EMAIL_EXIST_ERROR_MESSAGE = "xpath=//div[@class='message-error validation-summary-errors']/ul/li";
	public static final String PASSWORD_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='Pasword-error' and text()='Password is required.']";
	public static final String PASSWORD_CONFIRM_EMPTY_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error' and text()='Password is required.']";
	public static final String PASSWORD_AT_LEAST_SIX_CHAR_ERROR_MESSAGE = "xpath=//span[@id='Password-error' and contains(.,'must have at least 6 characters')]";
	public static final String PASSWORD_NOT_MATCH_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error' and text()='The password and confirmation password do not match.']";
}
