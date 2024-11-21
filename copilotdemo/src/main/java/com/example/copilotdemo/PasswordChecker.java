package com.example.copilotdemo;

public class PasswordChecker {

    /**
     * Checks if the provided password meets the following criteria:
     * <ul>
     *   <li>Is not null and has a length greater than 8 characters.</li>
     *   <li>Contains at least one uppercase letter.</li>
     *   <li>Contains at least one lowercase letter.</li>
     *   <li>Contains at least one digit.</li>
     * </ul>
     *
     * @param password the password to be checked
     * @return true if the password meets all the criteria
     * @throws IllegalArgumentException if the password does not meet any of the criteria
     */
    public boolean checkPassword(String password) throws IllegalArgumentException {
        

        if (password == null || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{9,}$")) {
            throw new IllegalArgumentException("Password must be longer than 8 characters, contain at least one uppercase letter, one lowercase letter, and one digit.");
        }

        return true;
    }
}
