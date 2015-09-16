package service;

import annatation.CustomDateFormat;
import annatation.JsonValue;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Администратор on 14.09.15.
 */
public class Human{

    private String firstName;
    private String lastName;
    @JsonValue(name="fun")
    private String hobby;
    @CustomDateFormat(format="dd-MM-yyyy")
    private LocalDate bithDate;
}
