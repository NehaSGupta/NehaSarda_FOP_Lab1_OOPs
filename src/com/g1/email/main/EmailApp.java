package com.g1.email.main;

import com.g1.email.service.CredentialService;
import com.g1.email.service.CredentialServiceImpl;
import com.g1.email.model.Employee;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        CredentialService service =  new CredentialServiceImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name\n");
        String fn = sc.next();
        System.out.print("Enter your last name\n");
        String ln = sc.next();

        Employee employee = new Employee(fn, ln);

        System.out.println("Please enter the department from the following ");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        int dept = sc.nextInt();
        String department = "";

        switch (dept) {
            case 1:
                department = "tech";
                break;
            case 2:
                department = "ad";
                break;
            case 3:
                department = "hr";
                break;
            case 4:
                department = "lg";
                break;
            default:
                System.out.println("Please select correct option");
                break;
        }

        String email = service.generateEmailAddress(fn, ln, department);
        employee.setEmail(email);

        String password = service.generatePassword();
        employee.setPassword(password);

        service.showCredentials(employee);
    }
}
