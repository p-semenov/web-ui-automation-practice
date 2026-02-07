package practicetestautomation.com;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPagePO extends BaseTest {


    public LoginPagePO openPage(String path) {

        open(BASE_URL + path);
        return this;
    }

    public LoginPagePO loginUser(String username) {
        $("#username").setValue(username);
        return this;
    }
    public LoginPagePO loginPassword(String password) {
        $("#password").setValue(password);
        return this;
    }
    public LoginPagePO submitBtn() {
        $("#submit").click();
        return this;
    }

    public LoginPagePO successPageShouldBeOpened(String path) {
        assertThat(url())
                .isEqualTo( BASE_URL + path);

        return this;
    }
    public LoginPagePO successMessageShouldBe(String message) {
        $("h1").shouldHave(text(message));
        return this;
    }

    public LoginPagePO logoutBtnShouldBeVisible() {
        $(".has-text-color").shouldBe(Condition.visible);
        return this;
    }

    public LoginPagePO verifyErrorMessageDisplayed() {
        $("#error").shouldBe(Condition.visible);
        return this;
    }

    public LoginPagePO verifyErrorMessagetext(String message) {
        $("#error").shouldHave(text(message));
        return this;
    }
}
