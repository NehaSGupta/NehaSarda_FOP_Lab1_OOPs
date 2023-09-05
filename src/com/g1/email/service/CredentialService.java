package com.g1.email.service;

import com.g1.email.model.Employee;

public interface CredentialService {
    String generatePassword();
    String generateEmailAddress(String firstName, String lastName, String department);
    void showCredentials(Employee employee);
}