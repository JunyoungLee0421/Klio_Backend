package com.kilo.klio.Security;

import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class PasswordValidator {
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&(){}\\[\\]])[A-Za-z\\d@$!%*?&(){}\\[\\]]{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();
        
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            errors.add("At least 8 characters long, include:");
            errors.add("- An uppercase letter");
            errors.add("- A lowercase letter");
            errors.add("- A number");
            errors.add("- A special character (@$!%*?&(){}[]).");
        }

        if (hasConsecutiveCharacters(password)) {
            errors.add("No more than three consecutive identical characters.");
        }
        return errors; // Valid password
    }

    private static boolean hasConsecutiveCharacters(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }
}
