import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void studentRegistrationFormTest ()
    {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Shav");
        $("#userEmail").setValue("AlexShav@mmmail.com");
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").setValue("3752911122");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").setValue("20 Dec 1986").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbies-checkbox-1").sendKeys(" ");
        $("#uploadPicture").uploadFile(new File("src/test/resources/Pic.png"));
        $("#currentAddress").setValue("Minsk");
        $("#state").click();
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Alex"),
                text("Shav"),
                text("AlexShav@mmmail.com"),
                text("3752911122"),
                text("Minsk"),
                text("History"),
                text("Sports"),
                text("Male"),
                text("NCR Delhi")


        );


    }
}
