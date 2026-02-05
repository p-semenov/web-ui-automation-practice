package practicetestautomation.com;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtensionsPagePO extends BaseTest {
    private SelenideElement instructionText;

    public ExtensionsPagePO openPage(String URL)
    {
        open(BASE_URL + URL);
        return this;
    }

    public ExtensionsPagePO addBtnCliclk()
    {
        $("#add_btn").click();
        return this;
    }

    public ExtensionsPagePO VerifyRowDisplayed()
    {
        $("#row2").should(appear,Duration.ofSeconds(6));
        return this;
    }
    public ExtensionsPagePO addTextToRow(String txt)
    {
        $("#row2 input.input-field").setValue(txt);
        return this;
    }


    public ExtensionsPagePO saveBtnClick()
    {
        $$("#save_btn").filterBy(visible).first().click();
        return this;
    }

    public ExtensionsPagePO checkTexts(String expectedValue, String locator){
        String actualValue = $(locator).getValue();

        assertThat(actualValue).isEqualTo(expectedValue);
        return this;
    }

    public ExtensionsPagePO editBtnClick()
    {
        $("#edit_btn").click();
        return this;
    }

    public ExtensionsPagePO clearInputfield()
    {
        $("#row1 input.input-field").shouldBe(enabled).clear();
        return this;
    }

    public ExtensionsPagePO changeValueInRow(String txt)
    {
        $("#row1 input.input-field").setValue(txt);
        return this;
    }

    public ExtensionsPagePO findInstructionElement()
    {
        instructionText = $("#instructions");
        System.out.println(instructionText);
        return this;
    }
    public ExtensionsPagePO checkElementDisappeared()
    {
        instructionText.shouldNotBe(visible, Duration.ofSeconds(6));
       return this;
    }

    public ExtensionsPagePO secondFieldisNotdisplayedIn3sec(int milliseconds)
    {
        Selenide.sleep(milliseconds);
        $("#row2").shouldNotBe(appear);
        return this;
    }

}
