package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products extends Hooks {

    By listNamesProducts = By.xpath("//div[@class='product-name product-list-name mt-1 mb-025']");
    By listImagesProducts = By.xpath("//div[@class='product-thumbnail-listing']");

    By iconCart = By.xpath("//a[@class='mini-cart-icon']");
    DetailsProducts detProd;

    public Products(){
        super(driver);
        detProd = new DetailsProducts();
    }
    public String[] obtainProductsName(int quantity){
        return selectProduct(listNamesProducts,quantity);
    }

    public void clickCart(){
        click(iconCart);
    }
    public void clickProducts(int quantity) {

        for(int i =0; i<quantity;i++){
            searchListElements(listImagesProducts).get(i).click();
            detProd.fillDetailsProducts();
        }

    }


}
