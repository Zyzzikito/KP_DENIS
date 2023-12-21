package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.requestModels.AddToCartRequestModel;
import models.requestModels.CartRequestModel;
import models.requestModels.DeleteProductRequestModel;
import models.requestModels.LoginRequestModel;
import models.responseModels.Items;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    String baseUrl = "https://api.demoblaze.com";

    @Step("Авторизация")
    public String login(LoginRequestModel user){
        return given()
                .baseUri(baseUrl)
                .body(user)
                .contentType(ContentType.JSON)
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }

    @Step("Проверка тела ответа")
    public void checkBodyResponse(String response, String expected){
        Assert.assertTrue(response.contains(expected));
    }

    @Step("Добавить товар в корзину")
    public void addToCart(AddToCartRequestModel product){
        given()
                .baseUri(baseUrl)
                .body(product)
                .contentType(ContentType.JSON)
                .post("/addtocart")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Step("Удалить товар из корзины")
    public String deleteProduct(DeleteProductRequestModel product){
        return given()
                .baseUri(baseUrl)
                .body(product)
                .contentType(ContentType.JSON)
                .post("/deleteitem")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }


    @Step("Посмотреть корзину")
    public Items viewCart(CartRequestModel body){
        return given()
                .baseUri(baseUrl)
                .body(body)
                .contentType(ContentType.JSON)
                .post("/viewcart")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(Items.class);
    }

    @Step("Регистрация")
    public void registration(LoginRequestModel user){
        given()
                .baseUri(baseUrl)
                .body(user)
                .contentType(ContentType.JSON)
                .post("/signup")
                .then()
                .log().all()
                .statusCode(200);
    }

}
