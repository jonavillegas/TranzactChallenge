package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

public class Order extends Hooks {

    By txtOrder = By.xpath("//span[contains(text(),'Order #')]");
    By informationOrder = By.xpath("//div[@class='text-textSubdued']");
    By totalAmount = By.xpath("//div[@class='grand-total-value']");
    By listProductsInOrder = By.xpath("//span[@class='font-semibold']");

    public Order(){
        super(driver);
    }

    public String returnOrder(){
        elementIsVisible(txtOrder);
        return returnText(txtOrder);
    }

    public boolean returnInformation(String valor){
        return containsOptionList(informationOrder, valor);
    }

    public double returnTotalAmount(){
        return convertAmountToDouble(totalAmount);
    }

    public boolean returnListProductsInOrder(String value){
        return equalsOptionList(listProductsInOrder,value);
    }

}
