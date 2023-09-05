package com.g1.email.service;

import com.g1.email.model.Employee;

import java.util.Random;

public class CredentialServiceImpl implements CredentialService {
    private static final String COMPANY_NAME = "company.com";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";


    public String generateEmailAddress(String firstName, String lastName, String department) {
        return firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + COMPANY_NAME;

    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();

        Random random = new Random();
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < 12; i++) {
            int type = random.nextInt(4); // 0 for uppercase, 1 for lowercase, 2 for number, 3 for special character
            switch (type) {
                case 0:
                    password.append(uppercase.charAt(random.nextInt(uppercase.length())));
                    break;
                case 1:
                    password.append(lowercase.charAt(random.nextInt(lowercase.length())));
                    break;
                case 2:
                    password.append(numbers.charAt(random.nextInt(numbers.length())));
                    break;
                case 3:
                    password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
                    break;
            }
        }

        return password.toString();
    }

    public void showCredentials(Employee employee) {
        System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows");
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Password: " + employee.getPassword());
    }
}