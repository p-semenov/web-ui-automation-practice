package practicetestautomation.com;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



public class LoginTests {
    LoginPagePO loginPagePO =  new LoginPagePO();
    String loginUrl = "/practice-test-login/";


    @Test
    public void positiveLoginTest(){
        loginPagePO.openPage(loginUrl)
                    .login("student", "Password123")

                    .successPageShouldBeOpened("/logged-in-successfully/")
                    .successMessageShouldBe("Successfully")
                    .logoutBtnShouldBeVisible();

    }

    @ParameterizedTest
    @CsvSource({
            "incorrectUser, Password123, Your username is invalid!",
            "student, incorrectPassword, Your password is invalid!"
    })
    public void negativeLoginTest(String username, String password, String errorMessage){

        loginPagePO.openPage(loginUrl)
                        .login(username, password)

                        .verifyErrorMessageDisplayed()
                        .verifyErrorMessagetext(errorMessage);

    }
}
