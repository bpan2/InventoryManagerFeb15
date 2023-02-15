package com.inventorymanager.Helpers.Utilities;

import com.inventorymanager.Models.Entities.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {
    private static final String defaultPassword = "999";

    private static Date getDate(int diff){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();

        users.add(new User("0001", "first", "David", "Sanders",
                defaultPassword, "yes", "yes", "yes",
                "yes", "yes", "Loblaws", "416-789-0123", "dsanders@gmail.com"
               ));

        users.add(new User("0002", "second", "Sarah", "Sanders",
                defaultPassword, "yes", "yes", "yes",
                "yes", "yes", "No Frills", "416-789-0124", "ssanders@gmail.com"
        ));

        users.add(new User("0003", "third", "John", "Smith",
                defaultPassword, "yes", "yes", "yes",
                "yes", "yes", "Metro", "416-789-0125", "jsmith@gmail.com"
        ));

        return users;
    }
}
