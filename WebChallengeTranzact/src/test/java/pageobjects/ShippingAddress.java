package pageobjects;

import util.ReadJson;
import definitions.Hooks;
import org.openqa.selenium.By;

public class ShippingAddress extends Hooks {

    By emailContact = By.xpath("//div[@class='col-span-2']//span");
    By txtFullName = By.name("address[full_name]");
    By txtTelephone = By.name("address[telephone]");
    By txtAddress = By.name("address[address_1]");
    By txtCity = By.name("address[city]");
    By selectCountry = By.id("address[country]");
    By selectProvince = By.id("address[province]");
    By txtPostCode = By.name("address[postcode]");
    By rbtnExpress = By.xpath("//span[contains(text(),'Express Delivery')]");
    By btnCotinue = By.xpath("//span[contains(text(),'Continue to payment')]");
    ReadJson readJ ;

    public ShippingAddress(){
        super(driver);
        readJ = new ReadJson();
    }

    public void fillShippingAddress() {
        enterText(txtFullName,(String) readJ.readJson().get("FullName"));
        enterText(txtTelephone,(String) readJ.readJson().get("Telephone"));
        enterText(txtAddress,(String) readJ.readJson().get("Address"));
        enterText(txtCity,(String) readJ.readJson().get("City"));
        selectValueFromDropdown(selectCountry,(String) readJ.readJson().get("Country"));
        selectValueFromDropdown(selectProvince,(String) readJ.readJson().get("Province"));
        enterText(txtPostCode,(String) readJ.readJson().get("PostCode"));
    }

    public void selectShippingMethod(){
        elementIsVisible(rbtnExpress);
        click(rbtnExpress);
    }

    public void selectContinue(){
        click(btnCotinue);
    }

    public String returnEmailContact(){
        return returnText(emailContact);
    }
}
