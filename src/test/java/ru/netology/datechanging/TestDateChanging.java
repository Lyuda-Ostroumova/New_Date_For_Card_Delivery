package ru.netology.datechanging;


import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Keys;

public class TestDateChanging {
    private final Meeting meeting = DataGenerator.Registration.generate();


    @Test
    void shouldSubmitForCardDelivery() {

        // Configuration.headless = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd" + "." + "MM" + "." + "yyyy");

        open("http://localhost:9999");

        $("[data-test-id='city'] [class='input__control']").setValue(meeting.getCity()); // город
        $("[data-test-id='date'] [class='input__control']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(formatter.format(meeting.getDateFirstMeeting())); // дата
        $("[data-test-id='name'] [class='input__control']").setValue(meeting.getLastName() + " " + meeting.getFirstName()); // ФИ
        $("[data-test-id='phone'] [class='input__control']").setValue("+7" + String.valueOf(meeting.getPhoneNumber())); // тел
        $("[data-test-id='agreement'] [class='checkbox__box']").click(); // согласие
        $(".button").click(); // отправка формы
        $("[data-test-id='date'] [class='input__control']").doubleClick().sendKeys(Keys.BACK_SPACE); // удалить старую дату
        $("[data-test-id='date'] [class='input__control']").setValue(formatter.format(meeting.getDateNewMeeting())); // новая дата
        $(".button").click();
        $$(".button").find(Condition.exactText("Перепланировать")).click();
        $(".notification_status_ok").shouldBe(Condition.visible);
    }

}

