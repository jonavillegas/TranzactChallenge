package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

public class PaymentMethod extends Hooks {
    By rbtnPayment = By.xpath("(//div[@class='flex justify-start items-center gap-1']//a)[1]");
    By btnPlaceOrder = By.xpath("//span[contains(text(),'Place Order')]");
    By amountShipping = By.xpath("//div[contains(text(),'Express Delivery')]/following-sibling::*[1]");

    By address = By.xpath("(//div[@class='col-span-2'])[2]//span");
    public PaymentMethod(){
        super(driver);
    }

    public void selectPayment(){
        click(rbtnPayment);
    }

    public void clickPlaceOrder(){
        elementIsVisible(btnPlaceOrder);
        click(btnPlaceOrder);
    }

    public double returnAmountShipping(){
        elementIsVisible(amountShipping);
        return convertAmountToDouble(amountShipping);
    }

    public String returnAddress(){
        return returnText(address);
    }

}
