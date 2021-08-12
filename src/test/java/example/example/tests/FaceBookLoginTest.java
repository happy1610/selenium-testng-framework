package example.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.FacebookLoginPage;

/**
 * The Class FaceBookLoginTest.
 *
 * @author Bharathish
 */
@Test(testName = "Facebook login test", description = "Facebook login test")
public class FaceBookLoginTest extends BaseTest {

//	@Test
//	public void facebookLoginTest() {
//		driver.get("https://www.facebook.com/");
//		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
//		facebookLoginPage.enterEmail("test").enterPassword("test").clickSignIn();
//		Assert.assertTrue(driver.getTitle().contains("Email hoặc số di động bạn nhập không kết nối với tài khoản nào. Hãy tìm tài khoản của bạn và đăng nhập."), "Title doesn't contain abc : Test Failed");
//	}

	@Test
	public void facebookLoginTest() {
		driver.get("http://localhost:8000/");
//		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
//		facebookLoginPage.enterEmail("test").enterPassword("test").clickSignIn();
		Assert.assertTrue(driver.getPageSource().contains("Static Website Hosting"), "Test Failed");
	}
}
