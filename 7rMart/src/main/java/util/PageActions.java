package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageActions extends WaitUtility {
	
	@FindBy(css=".btn.btn-rounded.btn-danger")
	protected WebElement newBtn;
	
	@FindBy(css=".alert-success")
	protected WebElement alertMsg;
	
	@FindBy(name="create")
	protected WebElement saveBtn;
	

	private WebDriver driver;
	
	public PageActions(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}
		
	public void clickElement(WebElement element) {
		waitUntilVisible(element);
		waitUntilClickable(element);
			element.click();
		}
		
	public void setTextBox(WebElement element, String value) {
		waitUntilVisible(element);
		waitUntilClickable(element);
			element.sendKeys(value);
		}
		
		
	public String getSplitStringText(String text) {
			return text.split("!")[1].trim();
		}
		
		public void acceptAlert() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		//public void handleChildWindow() {
			/**
			 * write a code to switch to child window
			 * 
			 */
		/*public void handleChildWindow()
		Set<String>windowHandles=driver.getWindowHandles();
		Iterator<String>it = windowHandles.iterator();
		String parentWindow =it.next();
		String childWindow =it.next();
		driver.switchTo().window(parent window);
		
		*/
		public void scrollToBottomofPage() {
			JavascriptExecutor js= (JavascriptExecutor)driver;
		     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		}
		public void setstaticDropdown(WebElement element, String value) {
			Select staticDropdown = new Select(element);
			staticDropdown.selectByVisibleText(value);
			
		}

		/*	public void shortWait() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
			
			public void uploadFile(WebElement element, String fileToUpload) throws AWTException {
				//clickElement(element);
				clickJavaScript(element);
				ShortWait();
				StringSelection ss = new StringSelection(fileToUpload);
			     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			     //imitate mouse events like ENTER, CTRL+C, CTRL+V
			     Robot robot = new Robot();
			     robot.delay(250);
			     robot.keyPress(KeyEvent.VK_ENTER);
			     robot.keyRelease(KeyEvent.VK_ENTER);
			     robot.keyPress(KeyEvent.VK_CONTROL);
			     robot.keyPress(KeyEvent.VK_V);
			     robot.keyRelease(KeyEvent.VK_V);
			     robot.keyRelease(KeyEvent.VK_CONTROL);
			     robot.keyPress(KeyEvent.VK_ENTER);
			     robot.delay(90);
			     robot.keyRelease(KeyEvent.VK_ENTER);
			}
			
			 public void clickJavaScript(WebElement element) {
			    	JavascriptExecutor js= (JavascriptExecutor)driver;
			    	waitUntilVisible(element);
					waitUntilClickable(element);
			    	js.executeScript("arguments[0].click();",element);
			    }
			
		
		}
		
		
		
		
	


