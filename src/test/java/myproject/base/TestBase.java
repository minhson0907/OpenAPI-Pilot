package myproject.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class TestBase {

    protected static WebDriver driver;
    protected static Properties prop;
    private File file = new File("config/linktest.properties");

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(file);
            prop.load(ip);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(){
        String browserType = prop.getProperty("browser.type");
        switch (browserType.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_2.38.exe");
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String readFile(String filename) throws Exception
    {
        File file = new File(System.getProperty("user.dir") + "\\data\\" + filename);
        String filePath = file.getAbsolutePath();
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        return fileContents;
    }

    public String read_user(String filename) {
        BufferedReader br = null;
        String temp = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\data\\" + filename));

            while ((sCurrentLine = br.readLine()) != null) {
                temp = sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return temp;
    }

    public void waitElement(By webElement) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
    }

    public void clickToElementByJS(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(locator)));
    }

    public String getValueInLine(String path,int beginIndex, int endIndex, int index) throws Exception{
        File file = new File(System.getProperty("user.dir") + "\\data\\" + path);
        String filePath = file.getAbsolutePath();
        String valueInLine = Files.readAllLines(Paths.get(filePath)).get(index);
        System.out.println("********************" + valueInLine);
        String value = valueInLine.substring(beginIndex,endIndex);
        System.out.println("********************" + value);
        return value;
    }
}
