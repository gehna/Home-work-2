import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestGehna {

    @BeforeAll
    public static void beforeAllMethod() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillTest(){

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[id = firstName]").setValue("Gehna");
        $("[id = lastName]").setValue("Legko");
        $("[id = userEmail]").setValue("gehna@yandex.ru");
        $(By.cssSelector("label[for='gender-radio-1']")).click();
        $("[id = userNumber]").setValue("7111111111");
        $("[id = dateOfBirthInput]").click();
        $(".react-datepicker__month-dropdown-container").$(byText("August")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1986")).click ();
        $(".react-datepicker__month-container").$(byText("15")).click();
        $("[id = subjectsInput]").setValue("E").pressEnter();
        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/5.jpg");
        $("[id = currentAddress]").setValue("Mosscowww");
        $("[id = state]").click();
        $("[id = stateCity-wrapper]").$(byText("Haryana")).click();
        $("[id = city]").click();
        $("[id = stateCity-wrapper]").$(byText("Karnal")).click();
        $("[id = submit]").click();

        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Gehna Legko"));
        $(".modal-body").shouldHave(text("gehna@yandex.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("7111111111"));
        $(".modal-body").shouldHave(text("15 August,1986"));
        $(".modal-body").shouldHave(text("E"));
        $(".modal-body").shouldHave(text("Sport"));
        $(".modal-body").shouldHave(text("Mosscowww"));
        $(".modal-body").shouldHave(text("Haryana"));
        $("#closeLargeModal").click();
    }
}
