package example.example.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.GooglePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Class GoogleSearchTest.
 *
 * @author Bharathish
 */
@Test(testName = "Website test", description = "Test description")
public class GoogleSearchTest extends BaseTest {

	/**
	 * Google search test.
	 */
//	@Test
//	public void googleSearchTest() {
//		driver.get("https://www.google.co.in/");
//		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
//		googlePage.searchText("automation test");
//		Assert.assertTrue(driver.getTitle().contains("automation test"), "Title doesn't contain abc : Test Failed");
//	}
// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://localhost/sys";
	//Database Username
	public static String DB_USER = "root";
	// Database Password
	public static String DB_PASSWORD = "12345678";

	@BeforeTest
	public void setUp() throws Exception {
		try {
			// Database connection
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void googleSearchTest() {
		driver.get("http://localhost:8000/");
//		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
//		googlePage.searchText("automation test");


		try {
			String query = "select * from sys.test";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(" " + res.getString(2));
				Assert.assertTrue(driver.getPageSource().contains(res.getString(2)), "Test Failed");
//				System.out.print(" " + res.getString(3));
//				System.out.println(" " + res.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}
