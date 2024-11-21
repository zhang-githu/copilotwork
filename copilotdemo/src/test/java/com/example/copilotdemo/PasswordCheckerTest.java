package com.example.copilotdemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PasswordCheckerTest {

    private final PasswordChecker passwordChecker = new PasswordChecker();


    
    @Test
    public void testValidPassword() {
        assertDoesNotThrow(() -> passwordChecker.checkPassword("Valid123"));
    }

    @Test
    public void testPasswordTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.checkPassword("Short1");
        });
        assertEquals("Password must be longer than 8 characters.", exception.getMessage());
    }

    @Test
    public void testPasswordNoUppercase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.checkPassword("nouppercase1");
        });
        assertEquals("Password must contain at least one uppercase letter.", exception.getMessage());
    }

    @Test
    public void testPasswordNoLowercase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.checkPassword("NOLOWERCASE1");
        });
        assertEquals("Password must contain at least one lowercase letter.", exception.getMessage());
    }

    @Test
    public void testPasswordNoDigit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.checkPassword("NoDigitHere");
        });
        assertEquals("Password must contain at least one digit.", exception.getMessage());
    }

    @Test
    public void testPasswordNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordChecker.checkPassword(null);
        });
        assertEquals("Password must be longer than 8 characters.", exception.getMessage());
    }
}