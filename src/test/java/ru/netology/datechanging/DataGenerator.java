package ru.netology.datechanging;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static Meeting generate() {
            Faker faker = new Faker(new Locale("ru"));
            LocalDate dateFirstMeeting = LocalDate.now().plusDays(5);
            LocalDate dateNewMeeting = LocalDate.now().plusDays(4);
            return new Meeting(
                    faker.address().city(),
                    dateFirstMeeting,
                    faker.name().lastName(),
                    faker.name().firstName(),
                    faker.phoneNumber(),
                    dateNewMeeting);
        }

    }

}
