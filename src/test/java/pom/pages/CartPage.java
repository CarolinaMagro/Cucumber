package pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;
import java.util.List;

public class CartPage extends BasePage {
        @FindBy(className = "success")
        private List<WebElement> ItemsInCart;

        @FindBy(xpath ="//a[contains(text(),'Delete')]")
        private List<WebElement> delete;
        public CartPage(WebDriver driver){
                super(driver);
        }
        public Integer GetNumberOfItemsInCart()throws Exception{
                Integer number = ItemsInCart.size();
                return number;
        }
        public void DeleteItem()throws Exception{
                this.click(delete.get(0));
                Thread.sleep(1000);
        }
               public void goToIndexPage(){
                getDriver().get(environment().urlPantallaPrincipal());
        }


}
