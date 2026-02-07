package practicetestautomation.com;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Epic("Обработка исключений Selenium")
@Feature("Динамические элементы и исключения")
public class TestExceptions {
    ExtensionsPagePO extensionsPagePO =  new ExtensionsPagePO();
    private final static String ExtensionURL = "/practice-test-exceptions/";

    @BeforeEach
    public void setUp()
    {
        extensionsPagePO.openPage(ExtensionURL);
    }

    @Test
    @DisplayName("Проверка отображения строки без ожидания")
    @Severity(SeverityLevel.CRITICAL)
    @Story("NoSuchElementException - элемент не найден")
    public void checkRowDisplayed(){
        extensionsPagePO.addBtnCliclk()

                .VerifyRowDisplayed();
    }

    @ParameterizedTest(name = "Ввод текста во вторую строку")
    @ValueSource(strings = {"pizza", "pasta"})
    @DisplayName( "Ввод текста в динамическую строку")
    @Severity(SeverityLevel.NORMAL)
    @Story("ElementNotInteractableException - взаимодействие с динамическими элементами")
    public void checkTextInRow(String text)
    {
        extensionsPagePO.addBtnCliclk()
                .VerifyRowDisplayed()
                .addTextToRow(text)
                .saveBtnClick()
                .checkTexts(text, "#row2 input");

    }
    @Test
    @DisplayName("Редактирование заблокированного поля")
    @Severity(SeverityLevel.NORMAL)
    @Story("InvalidElementStateException - работа с неактивными элементами")
    public void editFirstRow(){
        String text = "Some text";
        extensionsPagePO.editBtnClick()
                .clearInputfield()
                .changeValueInRow(text)
                .checkTexts(text, "#row1 input");
    }
    @Test
    @DisplayName("Исчезновение элемента инструкций")
    @Severity(SeverityLevel.NORMAL)
    @Story("Устаревшие ссылки на элементы")
    public void elementInstructionDisappeared(){
        extensionsPagePO.findInstructionElement()
                .addBtnCliclk()
                .checkElementDisappeared();
    }
    @Test
    @DisplayName("Недостаточное время ожидания")
    @Severity(SeverityLevel.NORMAL)
    @Story("TimeoutException - настройка времени ожидания")
    public void secondRowisNotDisplayedIn3sec(){
        extensionsPagePO.addBtnCliclk()
                    .secondFieldisNotdisplayedIn3sec(3000);
    }

}
