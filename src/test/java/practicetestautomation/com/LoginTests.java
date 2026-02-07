package practicetestautomation.com;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@Epic("Авторизация пользователя")
@Feature("Форма логина")
public class LoginTests {
    LoginPagePO loginPagePO =  new LoginPagePO();
    String loginUrl = "/practice-test-login/";


    @Test
    @DisplayName("Успешная авторизация с валидными данными")
    @Description("Проверка входа с корректными учетными данными пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Позитивный сценарий авторизации")
    public void positiveLoginTest(){

        loginPagePO.openPage(loginUrl)
                    .loginUser("student")
                    .loginPassword("Password123")
                    .submitBtn()

                    .successPageShouldBeOpened("/logged-in-successfully/")
                    .successMessageShouldBe("Successfully")
                    .logoutBtnShouldBeVisible();

    }

    @ParameterizedTest(name = "Негативная авторизация: логин={0}, пароль={1}, ожидаемая ошибка={2}")
    @DisplayName("Негативные сценарии авторизации")
    @Description("Проверка сообщений об ошибках при невалидных данных")
    @Severity(SeverityLevel.NORMAL)
    @Story("Негативные сценарии авторизации")
    @CsvSource({
            "incorrectUser, Password123, Your username is invalid!",
            "student, incorrectPassword, Your password is invalid!"
    })
    public void negativeLoginTest(String username, String password, String errorMessage){

        loginPagePO.openPage(loginUrl)
                        .loginUser(username)
                        .loginPassword(password)
                        .submitBtn()

                        .verifyErrorMessageDisplayed()
                        .verifyErrorMessagetext(errorMessage);

    }
}
