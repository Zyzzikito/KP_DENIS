import models.requestModels.AddToCartRequestModel;
import models.requestModels.CartRequestModel;
import models.requestModels.DeleteProductRequestModel;
import models.requestModels.LoginRequestModel;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest{

    @Test(description = "Авторизация")
    public void login(){
        LoginRequestModel user = new LoginRequestModel("admin", "YWRtaW4=");
        String response = API_STEPS.login(user);
        API_STEPS.checkBodyResponse(response, "Auth_token:");
    }


    @Test(description = "Добавить товар в корзину")
    public void addProductToCard(){
        AddToCartRequestModel product = new AddToCartRequestModel("26c6bf56-5cdb-768c-df05-1070c6206d52",
                "user=user=07433412-77ee-ae1b-d3c4-82fbbdf01894", 3, false);
        API_STEPS.addToCart(product);
    }

    @Test(description = "Удалить товар из корзины")
    public void deleteProduct(){
        DeleteProductRequestModel product = new DeleteProductRequestModel("26c6bf56-5cdb-768c-df05-1070c6206d52");
        String response = API_STEPS.deleteProduct(product);
        API_STEPS.checkBodyResponse(response, "Item deleted.");
    }


    @Test(description = "Посмотреть корзину")
    public void viewCart(){
        CartRequestModel body = new CartRequestModel("user=user=07433412-77ee-ae1b-d3c4-82fbbdf01894", false);
        API_STEPS.viewCart(body);
    }

    @Test(description = "Регистрация")
    public void signUp(){
        LoginRequestModel user = new LoginRequestModel("botyara", "123456");
        API_STEPS.registration(user);
    }
}
