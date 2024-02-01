package com.pruebas.selenium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Caso1Test {
	private WebDriver driver;
	
	 private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void caso1() {
	    driver.get("http://localhost:8000/");
	    driver.manage().window().setSize(new Dimension(1054, 809));
	    driver.findElement(By.id("nombre")).click();
	    driver.findElement(By.cssSelector(".btn")).click();
	    driver.findElement(By.id("nombre")).click();
	    driver.findElement(By.id("nombre")).sendKeys("a");
	    driver.findElement(By.cssSelector(".btn")).click();
	    driver.findElement(By.id("apellidos")).sendKeys("b");
	    driver.findElement(By.cssSelector(".btn")).click();
	    driver.findElement(By.cssSelector(".btn")).click();
	    vars.put("filas", driver.findElements(By.xpath("//*[@id=\'tabla\']/tbody/tr")).size());
	    System.out.println(vars.get("filas").toString());
	    assertEquals(vars.get("filas").toString(), "0");
	  }
	
}
