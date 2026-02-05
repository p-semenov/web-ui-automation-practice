package practicetestautomation.com;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    protected final static String BASE_URL = "https://practicetestautomation.com";
    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }
}