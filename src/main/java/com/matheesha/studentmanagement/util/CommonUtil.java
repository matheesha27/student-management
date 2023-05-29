package com.matheesha.studentmanagement.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CommonUtil {

    public String generateAdmissionNumber(String firstName, String lastName) {
        Date date = new Date();
        String timestampStr1 = String.valueOf(date.getTime()).substring(6,8);
        String timestampStr2 = String.valueOf(date.getTime()).substring(8,10);
        String admissionNumber = firstName.charAt(0) + timestampStr1 + lastName.charAt(0) + timestampStr2;
        return admissionNumber;
    }
}
