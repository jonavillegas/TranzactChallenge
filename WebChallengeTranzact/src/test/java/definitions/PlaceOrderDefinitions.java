package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.*;

public class PlaceOrderDefinitions {

    Home home;
    Login login;
    MyAaccount account;
    Products pro;
    Cart cart;
    ShippingAddress shipping_address;
    PaymentMethod pay;
    Order order;
    String[] resultadoProductosElegidos;
    String emailContact;
    double subTotal ;
    double amountShipping;
    String addressGeneral;

    public PlaceOrderDefinitions() {
        home = new Home();
        login = new Login();
        account = new MyAaccount();
        pro = new Products();
        cart = new Cart();
        shipping_address = new ShippingAddress();
        pay = new PaymentMethod();
        order = new Order();
    }


    @Given("The user searches in the Men category")
    public void theUserSearchesInTheMenCategory() {
        login.toAccessMen();
    }

    @And("the user selects {int} products with different amounts per item")
    public void theUserSelectsProductsWithDifferentAmountsPerItem(int quantity) {
        resultadoProductosElegidos = pro.obtainProductsName(quantity);
        pro.clickProducts(quantity);
    }

    @And("the user clicks on Cart")
    public void theUserVisualizaElCarrito() {
        pro.clickCart();
    }

    @And("the user clicks on Checkout option")
    public void theUserClicksOnCheckoutOption() {
        subTotal = cart.subTotal();
        cart.clickCheckout();
    }

    @When("the user fill the shipping address")
    public void theUserFillTheShippingAddress() {
        shipping_address.fillShippingAddress();
        emailContact = shipping_address.returnEmailContact();
    }

    @And("the user selects a shipping method")
    public void theUserSelectsAShippingMethod() {
        shipping_address.selectShippingMethod();
    }

    @And("the user clicks on Continue to payment")
    public void theUserClicksOnContinueToPayment() {
        shipping_address.selectContinue();
    }

    @And("the user selects a Payment Method")
    public void theUserSelectsAPaymentMethod() {
        amountShipping = pay.returnAmountShipping();
        addressGeneral = pay.returnAddress();
        int indiceComa = addressGeneral.indexOf(",");
        addressGeneral = addressGeneral.substring(0, indiceComa);
        pay.selectPayment();
    }

    @And("the user clicks on Place Order")
    public void theUserClicksOnPlaceOrder() {
        pay.clickPlaceOrder();
    }

    @Then("the order is generated for the logged in user")
    public void theOrderIsGeneratedForTheLoggedInUser() {
        //I VALIDATE THAT A PURCHASE ORDER NUMBER IS GENERATED.
        Assert.assertTrue(order.returnOrder().contains("Order #"));

        //I VALIDATE THAT THE CONTACT EMAIL APPEARS IN THE GENERATED ORDER
        Assert.assertTrue(order.returnInformation(emailContact));

        //I VALIDATE THAT THE VALUE OF THE SUBTOTAL OF PRODUCTS ADDED TO
        // THE VALUE OF SHIPPING IS EQUAL TO THE TOTAL AMOUNT GENERATED IN THE ORDER
        double valor = subTotal+amountShipping;
        Assert.assertEquals(valor, order.returnTotalAmount(),0.01);

        //I VALIDATE THAT THE SHIPPING ADDRESS IS THE SAME AS SHOWN IN THE ORDER
        Assert.assertTrue(order.returnInformation(addressGeneral));

        //I VALIDATE THAT THE PRODUCTS SHOWN IN THE ORDER ARE THE SAME AS THE PRODUCTS CHOSEN
        for(int i = 0; i< resultadoProductosElegidos.length; i++){
            Assert.assertTrue(order.returnListProductsInOrder(resultadoProductosElegidos[i]));
        }
    }





}

