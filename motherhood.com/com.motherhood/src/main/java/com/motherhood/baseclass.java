package com.motherhood;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import finddocor.findadoctor;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.constants;
import utilities.genericMethod;

public class baseclass extends findadoctor {
		public static WebDriver driver;

		@SuppressWarnings("deprecation")
		@Test
			public void launchApp() throws IOException, InterruptedException 
				{
						  ChromeOptions p = new ChromeOptions();
						  p.addArguments("--disable-notifications");
						  WebDriverManager.chromedriver().setup();
						  driver = new ChromeDriver(p);
						  
						 // Thread.sleep(constants.WAIT_IN_SECS);
						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS) ;
						  genericMethod gm= new genericMethod();
						  String url=gm.PropertyReader();
						  
					      driver.get(url);
					      //driver.manage().window().maximize();
					      Thread.sleep(4000);
					      findadoctor fd=new findadoctor();
					      fd.login(driver, gm);
					      
				}
		
		
		@AfterTest	
			public void closeapp()
				{
					driver.quit();
				}
}
