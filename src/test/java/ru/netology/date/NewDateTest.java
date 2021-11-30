package ru.netology.date;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class NewDateTest {

    @BeforeEach
    void setup() {

        Configuration.headless = true;
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successfully schedule and reschedule meeting")
    void shouldSuccessfullyScheduleAndRescheduleMeeting() {

        int daysToAddForFirstMeeting = 4;
        String firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        int daysToAddForSecondMeeting = 7;
        String secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        $("[data-test-id='city'] [class='input__control']").setValue(DataGenerator.generateCity("ru")); // город
        $("[data-test-id='date'] [class='input__control']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(firstMeetingDate); // дата
        $("[data-test-id='name'] [class='input__control']").setValue(DataGenerator.generateName("ru")); // ФИ
        $("[data-test-id='phone'] [class='input__control']").setValue("+7" + DataGenerator.generatePhone("ru")); // тел
        $("[data-test-id='agreement'] [class='checkbox__box']").click(); // согласие
        $(".button").click(); // отправка формы
        $("[data-test-id='date'] [class='input__control']").doubleClick().sendKeys(Keys.BACK_SPACE); // удалить старую дату
        $("[data-test-id='date'] [class='input__control']").setValue(secondMeetingDate); // новая дата
        $(".button").click();
        $("[data-test-id='replan-notification'] .notification__content").shouldBe(Condition.visible).shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $(".notification_status_error .button").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        $("[data-test-id='success-notification'] .notification__content").shouldBe(Condition.visible).shouldHave
                (Condition.exactText("Встреча успешно запланирована на " + secondMeetingDate));


    }
}

