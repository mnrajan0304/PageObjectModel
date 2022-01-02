package Pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class Baseclass extends ExcelUtils{
	
	public Baseclass() {
		
	}

	
	static WebDriver driver;
	
	public static void browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\geckodriver-v0.30.0-win64\\geckodriver.exe");
          driver= new FirefoxDriver();
		}
		else
			System.out.println("Error: Browser not support");
	}
	
	public static void get(String url) {
		driver.get(url);
	}
	
	public static  String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static  String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static  String pageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	public static  WebElement findElement(String by, String value) {
		
		WebElement element = null;
		if (by.equalsIgnoreCase("name"))
		    element = driver.findElement(By.name(value));
		else if (by.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(value));
		else if (by.equalsIgnoreCase("className"))
			element =driver.findElement(By.className(value));
		else if (by.equalsIgnoreCase("linkText"))
			element =driver.findElement(By.linkText(value));
		else if (by.equalsIgnoreCase("partialLinkText"))
			element =driver.findElement(By.partialLinkText(value));
		else if (by.equalsIgnoreCase("cssSelector"))
			element =driver.findElement(By.cssSelector(value));
		else if (by.equalsIgnoreCase("xpath"))
			element =driver.findElement(By.xpath(value));
		else if (by.equalsIgnoreCase("tagName"))
			element =driver.findElement(By.tagName(value));
		else System.out.println("Error!: please enter proper by method");
	
		return element;
	}
	
	public static  Options manage() {
		org.openqa.selenium.WebDriver.Options options = driver.manage();
		return options;
	}
	public static  Window window() {
		Window window = driver.manage().window();
		return window;
	}
	public static  void maximize() {
		driver.manage().window().maximize();
	}
	public static  void clearAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public static  void close() {
		driver.close();
	}
	
	public static  void quit() {
		driver.quit();
	}
	
	public static  void sendKeys(WebElement element, String value) {
				element.sendKeys(value);
	}

	public static  void clear(WebElement element) {
		element.clear();
	}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	public static  String getText(WebElement element) {
		String Text = element.getText();
		return Text;
	}
	public static  String getAttribute(WebElement element, String attribute_name ) {
		String attribute = element.getAttribute(attribute_name);
		return attribute;
	}
	public static  String getTagName(WebElement element) {
		String tag = element.getTagName();
		return tag;
	}
	public static  String getCssValue(WebElement element, String value_name) {
		String cssvalue = element.getCssValue(value_name);
		return cssvalue;
	}
	public static  Point getLocation(WebElement element) {
		Point point = element.getLocation();
		return point;
	}
	public static  Dimension getSize(WebElement element) {
		Dimension dimension = element.getSize();
		return dimension;
	}
	public static  boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public static  boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	public static  boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public static  void submit(WebElement element) {
		element.submit();
	}
	
	public static  void select(WebElement element, String type, String value) {
		Select s= new Select(element);
		if(type.equalsIgnoreCase("index"))
		s.selectByIndex(Integer.parseInt(value)); //String to integer
		else if (type.equalsIgnoreCase("value"))
		s.selectByValue(value);
		else if (type.equalsIgnoreCase("text"))
		s.selectByVisibleText(value);
	}
	
	public static  void deselect(WebElement element, String type, String value) {
		Select s= new Select(element);
		if (s.isMultiple()==true) {
		if(type.equalsIgnoreCase("index"))
			s.deselectByIndex(Integer.parseInt(value));
		else if (type.equalsIgnoreCase("value"))
			s.deselectByValue(value);
		else if (type.equalsIgnoreCase("text"))
		s.deselectByVisibleText(value);
		}
		else System.out.println("Deslect option can't perform here");
	}
	
	public static  void deselectAll(WebElement element) {
		Select s= new Select(element);
		s.deselectAll();
	}
			
	public static  List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s= new Select(element);
		 return s.getAllSelectedOptions();
	}
		
	public static  WebElement getFirstSelectedOption(WebElement element) {
		Select s= new Select(element);
		return s.getFirstSelectedOption();
	}
	public static  List<WebElement> getOptions(WebElement element) {
		Select s= new Select(element);
		return s.getOptions();
	}
	
	public static  String getAllSelectedOptionsText(WebElement element) {
		Select s= new Select(element);
		List<WebElement> li = s.getAllSelectedOptions();
		String text= null;
		for(WebElement e: li) {
			 text = e.getText();
			 System.out.println(text);
		}		
		return text;
	}
	public static  String getOptionsText(WebElement element) {
		Select s= new Select(element);
		List<WebElement> li = s.getOptions();
		String text= null;
		for(WebElement e: li) {
			 text = e.getText();
			 System.out.println(text);
		}		
		return text;
	}
	
	public static  void screenshot(String name) {
		TakesScreenshot tk =  (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(".//screenshot//"+name+".png");
		try {
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  void waitThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static  void waitImplicit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static  WebDriverWait waitExplicit(int time) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait;
	}
	
	public static  void waitFluent(int withTimeout, int pollingEvery) {
	
		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
                .ignoring(Exception.class);
	}
	
	public static  void switchtoFrame(String using) {
		if (using.equalsIgnoreCase("id")||using.equalsIgnoreCase("name"))
		driver.switchTo().frame(using);
		else if (using.equalsIgnoreCase("index")) 
			driver.switchTo().frame(Integer.parseInt(using));
	}
	
	public static  void switchtoFrameelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static  String windowHandle() {
		return driver.getWindowHandle();
	}
	
	public static  Set<String> windowHandles() {
		return driver.getWindowHandles();
	}
	
	public static  void switchWindowid(String id) {
		  driver.switchTo().window(id);
	}
	
	public static  void fileUpload(WebElement element, String path) {
		element.sendKeys(path);
	}
	
	public static  void autheticationPopup(String username, String password, String urlwithouthttsps) {
		driver.get("https://"+username+":"+password+"@"+urlwithouthttsps);
	}
	
	
	public static  void webtableHeading() {
		WebElement table = driver.findElement(By.tagName("table"));
		WebElement heading = table.findElement(By.tagName("thead"));
		WebElement row= heading.findElement(By.tagName("tr"));
		List<WebElement> headingList = row.findElements(By.tagName("th"));
		for (WebElement i: headingList) {
		System.out.print(i.getText()+"     ");	
		}
	}
	public static  void webtableBody() {
		WebElement table = driver.findElement(By.tagName("table"));
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = body.findElements(By.tagName("tr"));
		for (WebElement i1: rows) {
			System.out.println();
			List<WebElement> data = i1.findElements(By.tagName("td"));
			for (WebElement i2:data) {
			System.out.print(i2.getText()+"     ");	
			}
		}
	}
	public static  void webtableFoot() {
	    WebElement table = driver.findElement(By.tagName("table"));
		WebElement foot = table.findElement(By.tagName("tfoot"));
		WebElement fRow = foot.findElement(By.tagName("tr"));
		List<WebElement> fhead = fRow.findElements(By.tagName("th"));
		System.out.println();
		for(WebElement i2: fhead) {
			System.out.print(i2.getText());
		}
		List<WebElement> fData = fRow.findElements(By.tagName("td"));
		for(WebElement i2: fData) {
			System.out.println(i2.getText());
		}
	}
	
	public static  void brokenLinks() {
		URL url=null;
		URLConnection connect=null;
		String responseMessage = null;
		int responseCode = 0;
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Num of links: "+li.size());
		int validCount= 0;
		int invalidCount= 0;
		
		for(WebElement e: li) {
			String attribute = e.getAttribute("href");
			
			if (attribute!=null) {
			
			try {
				url = new URL(attribute);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			
			try {
				connect = url.openConnection();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			HttpURLConnection httpconnect = (HttpURLConnection) connect;
			
			try {
				responseCode = httpconnect.getResponseCode();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			try {
				responseMessage = httpconnect.getResponseMessage();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			if (responseCode==200|| responseMessage=="Ok") {
				System.out.println("Valid Link"+ attribute);
				validCount++;
			}
				else {
					System.out.println("Broken link"+ attribute);
					invalidCount++;
			}
		}}
		System.out.println("Total valid count"+ validCount);
		System.out.println("Total Invalid count"+ invalidCount);
		driver.quit();
	}
	
	public static  Navigation navigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}
	public static  Alert alert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public static  Actions actions() {
		Actions action = new Actions(driver);
		return action;
	}
	public static  JavascriptExecutor jsExecutor() {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		return js;
	}
}

class ExcelUtils {
	static String projectPath;
	static File file;
	static FileInputStream fi;
	static XSSFWorkbook workbook;
	static Sheet sheet;
	static Row row;
	static Cell cell;
		 public   static int getRowCount(String path, String sheetName) {
		 projectPath = System.getProperty("user.dir");
		 file= new File(path);
		try {
			FileInputStream fi = new FileInputStream(file);
		 workbook = new XSSFWorkbook(fi);
		 sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		//System.out.println(rowCount);
		return rowCount;
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage()); 
			exp.printStackTrace();
			return 0;
		}
		}
		public  static  int getCellCount(int rownum ) {
				row = sheet.getRow(rownum);
			int cellCount = row.getPhysicalNumberOfCells();
			//System.out.println(cellCount);
			return cellCount;
		}
		public  static  String getCellValue(int rownum, int cellnum) {
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			
			int celltype= cell.getCellType();
			 if (celltype==1){
					String StringCellValue = cell.getStringCellValue();
					//System.out.println(StringCellValue);
					return StringCellValue;
				}
			else if (DateUtil.isCellDateFormatted(cell)) {
				Date datecell = cell.getDateCellValue();
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateformat.format(datecell);
			//System.out.println(date);
			return date;
			}
			else {
				double dou = cell.getNumericCellValue();
				String NumericCellValue = String.valueOf(dou);
				//System.out.println(NumericCellValue);
				return NumericCellValue;
			}
		}
}


