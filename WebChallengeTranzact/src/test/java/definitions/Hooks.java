package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;


    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20,40);
    }

    public void accessUrl(){
        driver.get("https://demo.evershop.io/");
    }
    public void refrescar(){
        driver.navigate().refresh();
    }
    public void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public List<WebElement> searchListElements(By locator) {
        return driver.findElements(locator);
    }
    public void selectValueFromDropdown(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(value);
    }
    public Boolean getTextCompare(By locator, String inputText) {
        return driver.findElement(locator).getText().trim().equalsIgnoreCase(inputText);
    }
    public void elementIsVisible(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Throwable t) {
            System.out.println(t);
        }
    }
    public boolean elementIsDisplayed(By locator){
        try {
             if(driver.findElement(locator).isDisplayed()){
                 return true;
             }
         }catch (Throwable t){
            System.out.println(t);

        }
        return false;
    }
    public void cleanField(By locator){
        driver.findElement(locator).clear();
    }

    public String returnText(By locator){
        return driver.findElement(locator).getText();
    }
    public double convertAmountToDouble(By locator){
        String text1 = returnText(locator).replace("$","");
        String text2 = text1.replace(",","");
        return Double.parseDouble(text2);
    }

    public void clickButtonWithDelay(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public String[] selectProduct(By element, int quantity) {
        String[] arrayProducts = new String[quantity];
        List<WebElement> lista = driver.findElements(element);
        for(int i=0; i<quantity;i++){
            arrayProducts[i] = lista.get(i).getText();
        }
      return arrayProducts;
    }

    public boolean equalsOptionList(By element, String valor) {
        List<WebElement> lista = driver.findElements(element);
        for(WebElement e : lista) {
            if(e.getText().equals(valor)){
                return true;
            }
        }
        return false;
    }

    public boolean containsOptionList(By element, String valor) {
        List<WebElement> lista = driver.findElements(element);
        for(WebElement e : lista) {
            if(e.getText().contains(valor)){
                return true;
            }
        }
        return false;
    }

     @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
