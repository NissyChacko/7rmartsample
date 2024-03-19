package com.obsqura.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.UniqueGenerator;

public class CreateDeleteExpenseTest extends BaseTest {

	@Test
	public void anotherTest() throws IOException {
		/** LoginPage lp = new LoginPage(driver);
		lp.Login();
		* manageExpemse();
		*HomePage hp = new HomePage(driver);
		*hp.navigateToExpenseCategoryPage();
		*ExpenseCategoryPage exp= new ExpenseCategoryPage(driver);
		*String uniqueCategory= "Expense".concat(UniqueGenerator.getCurrentDateTime());
		*String actualAlertMsg=exp.createExpense(uniqueCategory);
		*System.out.println(actualAlertMsg);
		**
		* Validating expense is getting created successfully
		*Assert.assertEquals(actualAlertMsg, "Expense Category Created Successfully");
		*/


	
		lp.Login();
		hp.navigateToExpenseCategoryPage();
		
		
		String uniqueCategory= "Expense".concat(UniqueGenerator.getCurrentDateTime());
		
		String actualAlertMsg=exp.createExpense(uniqueCategory);
		System.out.println(actualAlertMsg);
		/**
		 * Validating expense is getting created successfully
		 */
		Assert.assertEquals(actualAlertMsg, "Expense Category Created Successfully");
		
		
		String deleteAlertMsg=exp.deleteExpense();
		Assert.assertEquals(deleteAlertMsg, "Expense Category Deleted Successfully");	
		
	}
}