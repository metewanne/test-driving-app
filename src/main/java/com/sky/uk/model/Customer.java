package com.sky.uk.model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {

    Scanner scan = new Scanner(System.in);

    //Changed from return type of String to void because it does not return anything
    public String inputCustomerName(String customerName){

        while (customerName == null || customerName.trim().equals("") || !customerName.chars().allMatch(Character::isLetter)){
            System.out.println("Incorrect input, please enter a valid name");
            customerName = scan.next();
        }
        return customerName;
    }

    public boolean validateEmail(String emailAddress) {

        String regexPattern = "^(.+)@(\\S+)$";
        while (emailAddress == null || !emailAddress.matches(regexPattern)) {
            System.out.println("Invalid email, please input again");
            emailAddress = scan.next();
        }
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }


}
