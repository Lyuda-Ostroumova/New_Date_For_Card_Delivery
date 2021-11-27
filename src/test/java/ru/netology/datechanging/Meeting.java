package ru.netology.datechanging;

import com.github.javafaker.PhoneNumber;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Meeting {

    private final String city;
    private final LocalDate dateFirstMeeting;
    private final String lastName;
    private final String firstName;
    private final PhoneNumber phoneNumber;
    private final LocalDate dateNewMeeting;

    public String getCity() {
        return city;
    }

    public LocalDate getDateFirstMeeting() {
        return dateFirstMeeting;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateNewMeeting() {
        return dateNewMeeting;
    }


    public Meeting(String city, LocalDate dateFirstMeeting, String lastName, String firstName, PhoneNumber phoneNumber, LocalDate dateNewMeeting) {
        this.city = city;
        this.dateFirstMeeting = dateFirstMeeting;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.dateNewMeeting = dateNewMeeting;
    }
}


