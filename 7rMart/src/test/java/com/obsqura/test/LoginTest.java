package com.obsqura.test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test
	public void verifyUserIsAbleToLogin() throws IOException {
		//LoginPage lp = new LoginPage(driver);
		lp.Login();
		//HomePage hp = new HomePage(driver);
		String actualHeader=hp.getBrandHeader();
		
		Assert.assertEquals(actualHeader, "7rmart supermarket");
	}
}
		
	
	