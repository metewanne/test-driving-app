package main.java;

import java.util.Scanner;

public class Customer {
    String customerName;
    String customerSurname;
    String customerEmail;


    public Customer(String name, String surname, String email) {
        customerName = name;
        customerSurname = surname;
        customerEmail = email;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name");
        String name = input.nextLine();
        System.out.println("Enter surname");
        String surname = input.nextLine();
        System.out.println("Enter email");
        String email = input.nextLine();

    }
}
