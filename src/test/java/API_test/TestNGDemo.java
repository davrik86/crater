package API_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.DataReader;
import Utils.Driver;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TestNGDemo {
	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod"); 
		
	}
	@AfterMethod 
	public void wrapup(){
		System.out.println("@AfterMethod");
	}
	
  @Test (priority =1)
  public void DemoTest() {
	  System.out.println("test1");
	  
  }
  @Test (priority = 2)
  public void anotherTest() {
	  System.out.println("This is TestNG Demo");
	  
  }
  
}
