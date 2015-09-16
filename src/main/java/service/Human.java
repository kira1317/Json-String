package service;

import annatation.CustomDateFormat;
import annatation.JsonValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by Администратор on 14.09.15.
 */
public class Human{

    private String firstName;
    private String lastName;
    @JsonValue(name="fun")
    private String hobby;
    @CustomDateFormat(format="dd-MM-yyyy")
    private Calendar bithDate;




    public Human(String firstName, String lastName, String hobby, Calendar bithDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.bithDate = bithDate;
    }

    @Override
    public String toString() {

        String date=bithDate.getTime().toString();

        return firstName + "," + lastName +","+ hobby+"," + date;
    }


}
