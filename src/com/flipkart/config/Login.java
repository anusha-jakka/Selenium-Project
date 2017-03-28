package com.flipkart.config;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login 
{
	protected WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		/*org.openqa.selenium.Proxy p=new org.openqa.selenium.Proxy();
		p.setHttpProxy("localhost:7777");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY,cap);*/
		//System.setProperty("webdriver.chrome.driver", "E:\\Anusha Selenium\\Selenium Practice\\external drivers\\chromedriver.exe");
		//driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "E:\\Anusha Selenium\\Selenium Practice\\external drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("after maximize");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");		
		//driver.get("https://www.flipkart.com/");
		//driver.get("http://toolsqa.com/Automation-practice-form/");
		//driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		//driver.get("http://learn-automation.com/");
		//driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.get("https://www.gmail.com");
		
	}
	//Login
	@Test(enabled=false)
	public void TestCheck01()
	{
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI jUwFiZ']")).click();
		driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys("anusha.j222@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']")).sendKeys("anusha@1991");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		
	}
    //Drop down
    @Test(enabled=false)
    public void Testcheck02()
    {
    	//int i=10;
    	WebElement dropDown=driver.findElement(By.id("selenium_commands"));
    	System.out.println("dropDown"+dropDown);
    	Select sct=new Select(dropDown);
    	//System.out.println(sct.getOptions());
    	List<WebElement> options=sct.getOptions();
    	
    	for (WebElement opt : options)
    	{
    		System.out.println(opt.getText());
    	}
    		
    	if(sct.isMultiple())
    	{
    		sct.selectByVisibleText(options.get(options.size()-1).getText());
    		sct.selectByVisibleText("Switch Commands");
    		sct.selectByIndex(0);
    	}
    	else
    	{
    		sct.selectByIndex(3);
    	}
    	
    	List<WebElement> selectedOpt=sct.getAllSelectedOptions();
    	for(WebElement deOpt : selectedOpt)
    	{
    		System.out.println("--deselect--"+deOpt.getText());
    		sct.deselectByVisibleText(deOpt.getText());
    			
    	}
    	//
    }
    //List menu
    @Test(enabled=false)
    public void TestCheck03()
    {
    	Actions act=new Actions(driver);
    	WebElement electronics=driver.findElement(By.xpath("//a[@title='Electronics']"));
    	act.moveToElement(electronics).perform();
    	driver.findElement(By.xpath("//a[@title='Motorola']")).click();
    	
    }
    //Alerts
    @Test(enabled=false)
    public void TestCheck04() throws InterruptedException
    {
    	//confirmation 
    	
    	driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
    	Alert alt1=driver.switchTo().alert();
    	alt1.accept();
    	
    	Thread.sleep(30);
    	
    	//promt
    	driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
    	Alert alt2=driver.switchTo().alert();
    	alt2.sendKeys("Anusha");
    	alt2.accept();
    	
    	Thread.sleep(30);
    	
    	//Alert
    	driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
    	Alert alt3=driver.switchTo().alert();
    	System.out.println(alt3.getText());
    	alt3.accept();
    	
    }
    //windows
    @Test(enabled=false)
    public void TestCheck05()
    {
    	
    /*WebDriverWait wait=new WebDriverWait(driver, 0);
    System.out.println("alert result"+wait.until(ExpectedConditions.alertIsPresent()));
    if(wait.until(ExpectedConditions.alertIsPresent())==null)
    {
    	System.out.println("Alert is not present");
    	    }
    else
    {
    	System.out.println("Alert is present");
    	driver.switchTo().alert().dismiss();
    }*/
   
    String parentWin=driver.getWindowHandle();
    System.out.println("--parent handle--"+parentWin);
    driver.findElement(By.xpath("//a[text()='Selenium Basic Concepts']")).click();
    Set<String> windowHandles=driver.getWindowHandles();
    System.out.println("--window count--"+windowHandles.size());
    Iterator<String> handle=windowHandles.iterator();
    if(handle.hasNext())
    {
    	System.out.println(" child window "+handle.next());
    	String childWin=handle.next();
    	if(!parentWin.equals(childWin))
    	{
    		System.out.println("inside child window switch");
    		driver.switchTo().window(childWin);
    		System.out.println("Ater switch");
    		driver.findElement(By.xpath("//a[@href='http://learn-automation.com/selenium-script-firefox/']")).click();
    		System.out.println("After child window click");
    		Assert.assertEquals("Best way to execute selenium test on firefox browser", driver.findElement(By.xpath("//h1[@class='title single-title entry-title']")).getText());
    		System.out.println("afetr assert");
    		driver.close();
    	}
    }
    driver.switchTo().window(parentWin);
    System.out.println(driver.getTitle());
    //driver.findElement(By.xpath("//a[@class='tve_btnLink']")).click();
    }
    //frames
    @Test(enabled=false)
    public void TestCheck06()
    {
    	
    	System.out.println("No of Frames"+driver.findElements(By.tagName("iframe")).size());
    	try
    	{
    		WebElement frame=driver.findElement(By.xpath("(//iframe)[5]"));
    	    driver.switchTo().frame(frame);
    	    System.out.println("Successfully switched to frame");
    	}
    	catch(NoSuchFrameException e)
    	{
    		System.out.println(e.getMessage());
    		System.out.println("Not switched to frame");
    	}
    	
    driver.switchTo().defaultContent();
    System.out.println("Main page");
    	
  
    	
    }
    //dynamic calendar
    @Test(enabled=false)
    public void TestCheck07() throws InterruptedException
    {
    	String expectedMonth="February";
    	driver.findElement(By.id("datepicker")).click();
    	
    	for(int i=1;i<=12;i++)
    	{       		
    	
    	String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
    	
    	if(expectedMonth.equalsIgnoreCase(month))
    	{
    		System.out.println("Matched");
    		break;
    	}
    	else
    	 {
        	 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
         }
    	}
    	
    	//List<WebElement>calender=driver.findElements(By.xpath("//div/table[@class='ui-datepicker-calendar']/tbody/tr"));
    	List<WebElement> calender=driver.findElements(By.xpath("//div/table[@class='ui-datepicker-calendar']/tbody/tr/td"));
    	for(WebElement cal : calender)
    	{
    		String date=cal.getText();
    		//System.out.println("---Date---"+date);
    		if(date.equalsIgnoreCase("22"))
    		{
    			cal.click();
    			break;
    		}
    	}
    	
    	System.out.println("Selected date"+driver.findElement(By.id("datepicker")).getText());
    }
    //gmailLogin
    @Test(enabled=false)
    public void TestCheck08()
    {
    	try
    	{
    		System.out.println("inside try");
    	if(driver.findElement(By.xpath("//div[@id='sb_ifc0']")).isDisplayed())
    	{
    		System.out.println("inside if");
    		driver.findElement(By.xpath(".//*[@id='sb_ifc0']"));
    	}
    	}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	/*Actions act=new Actions(driver);
    	WebElement link=driver.findElement(By.cssSelector("#sbse1"));
    	act.moveToElement(link).click(link).build().perform();*/
    }
    
    
    
    @Test
	public void GmailLogin() throws InterruptedException
	{
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("anusha.j222",Keys.ENTER);
		Reporter.log("email id added",true);
		Thread.sleep(5000);
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("Anusha@0613",Keys.ENTER);
		Reporter.log("password entered",true);
	}
    @AfterMethod
    public void Close(ITestResult result) throws IOException
    {
    	
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    		System.out.println("inside failure");
    		com.flipkart.UtilityFunction.CaptureScreen.CaptureScreenShot(driver, result.getName());
    	}
    	driver.close();
    }
}
