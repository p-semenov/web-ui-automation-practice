package practicetestautomation.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestExceptions {
    ExtensionsPagePO extensionsPagePO =  new ExtensionsPagePO();
    private final static String ExtensionURL = "/practice-test-exceptions/";

    @BeforeEach
    public void setUp()
    {
        extensionsPagePO.openPage(ExtensionURL);
    }

    @Test
    public void checkRowDisplayed(){
        extensionsPagePO.addBtnCliclk()

                .VerifyRowDisplayed();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pizza", "pasta", "salad"})
    public void checkTextInRow(String text)
    {
        extensionsPagePO.addBtnCliclk()
                .VerifyRowDisplayed()
                .addTextToRow(text)
                .saveBtnClick()
                .checkTexts(text, "#row2 input");

    }
    @Test
    public void editFirstRow(){
        String text = "Some text";
        extensionsPagePO.editBtnClick()
                .clearInputfield()
                .changeValueInRow(text)
                .checkTexts(text, "#row1 input");
    }
    @Test
    public void elementInstructionDisappeared(){
        extensionsPagePO.findInstructionElement()
                .addBtnCliclk()
                .checkElementDisappeared();
    }
    @Test
    public void secondRowisNotDisplayedIn3sec(){
        extensionsPagePO.addBtnCliclk()
                    .secondFieldisNotdisplayedIn3sec(3000);
    }

}
