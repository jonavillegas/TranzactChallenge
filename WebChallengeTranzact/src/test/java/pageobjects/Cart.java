package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

public class Cart extends Hooks {

    By btnCheckout = By.xpath("//span[contains(text(),'CHECKOUT')]");
    By subTotal = By.xpath("//div[@class='text-right']");

    public Cart(){
        super(driver);
    }

    public void clickCheckout(){
        click(btnCheckout);
    }

    public double subTotal(){
        return convertAmountToDouble(subTotal);
    }

}
