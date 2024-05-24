package StepDefinitions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class orangehrmlogin {
	WebDriver driver;
	@Given("launch the browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	   
	}
	@And("Navigate to the URL")
	public void navigate_to_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@When("enter the username and password")
	public void enter_the_username_and_password() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		String[][] data=new String[1][2];
		File file1=new File("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\inputdata.xlsx");
		  FileInputStream fis=new FileInputStream(file1);
		  XSSFWorkbook workbook=new XSSFWorkbook(fis);
		  XSSFSheet sheet=workbook.getSheetAt(0);
		  int rowcount=sheet.getPhysicalNumberOfRows();
		  System.out.println("row count:"+rowcount);
		  for(int i=0;i<rowcount;i++)
		  {
			  
			  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			  
			  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		  
		     
		
		driver.findElement(By.name("username")).sendKeys(data[i][0]);
		 driver.findElement(By.name("password")).sendKeys(data[i][1]);
		 
		  }
	    //throw new io.cucumber.java.PendingException();
	}
	@And("clickon submit button")
	public void clickon_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000); 
		Boolean searchdispalyed=driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed();
 
		 if (searchdispalyed.equals(true))
		 {
			 System.out.println("Login Successfull");
		 }
		 else
		 {
			 System.out.println("Login unsuccessfull");
		 }
		 //throw new io.cucumber.java.PendingException();
	}

	@And("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
		//throw new io.cucumber.java.PendingException();
	}

	
}
