package pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class ItemPage extends BasePage {

    @FindBy(xpath ="//a[@onclick='addToCart(1)']")
    private WebElement AddToCart;



        public ItemPage(WebDriver driver){
                super(driver);
        }

            public void ClickAddToCart() throws Exception{
            this.click(AddToCart);

            }
            public boolean AceptModal(){
                Alert alert = getDriver().switchTo().alert();
                String message= alert.getText();
                alert.accept();
                return true;
             }
               public void goToIndexPage(){
                getDriver().get(environment().urlPantallaPrincipal());
        }

}
