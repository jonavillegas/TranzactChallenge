package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

import java.util.Random;

public class DetailsProducts extends Hooks {

   // By qty = By.name("qty");
    By txtQty = By.xpath("//input[contains(@type,'text')]");
    By btnAddCar = By.xpath("//span[contains(text(),'ADD TO CART')]");

    By optionSize = By.xpath("(//*[@class='variant-option-list flex justify-start']/child::*[1])[1]");
    By optionColor = By.xpath("(//*[@class='variant-option-list flex justify-start']/child::*[1])[2]");
    By linkViewCart = By.xpath("//a[contains(text(),'VIEW CART')]");
    By linkShopping = By.xpath("//a[contains(text(),'Continue Shopping')]");

    By linkMen2 = By.xpath("//a[contains(text(),'Men')]");
    By message = By.xpath("//div[contains(text(),'Please select variant')]");


    public DetailsProducts(){
        super(driver);
    }

    public int randomQuantityItem(){
        Random random = new Random();
        // Generate random number between 1 and 10
        int numeroAleatorio = random.nextInt(10) + 1;
        return numeroAleatorio;
    }
    public void fillDetailsProducts() {
        cleanField(txtQty);
        enterText(txtQty, String.valueOf( randomQuantityItem() ));
        click(optionSize);
        click(optionColor);
        clickButtonWithDelay(btnAddCar);
        if(elementIsDisplayed(message)){
            clickButtonWithDelay(btnAddCar);
        }
        click(linkShopping);
        click(linkMen2);
    }




}
