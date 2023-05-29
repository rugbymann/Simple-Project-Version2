package de.ait.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserValidatorTest {
    @Nested
    @DisplayName("Тесты для метода containsNumbers")
    class ForContainsNumbersTests {
        @Test
        public void contains_numbers_and_letters_returnsTrue() {
            String actual = "12345qwerty";
            boolean result = UserValidator.containsNumbers(actual);
            assertTrue(result);
        }

        @Test
        public void contains_letters_and_numbers_returnsTrue() {
            String actual = "qwerty12345";
            boolean result = UserValidator.containsNumbers(actual);
            assertTrue(result);
        }

        @Test
        public void contains_no_numbers_returnsFalse() {
            String actual = "qwerty";
            boolean result = UserValidator.containsNumbers(actual);
            assertFalse(result);
        }
    }
    @Nested
    @DisplayName("Тесты для метода isValidFirstName")
    class ForIsValidFirstNameTests {
        @Test
        public void isValidFirstName_empty_entrance_returnsFalse() {
            String name = "";
            boolean result = UserValidator.isValidFirstName(name);
            assertFalse(result);
        }

        @Test
        public void isValidFirstName_with_numbers_returnsFalse() {
            String name = "ain12345";
            boolean result = UserValidator.isValidFirstName(name);
            assertFalse(result);
        }

        @Test
        public void isValidFirstName_returnsTrue() {
            String name = "ain";
            boolean result = UserValidator.isValidFirstName(name);
            assertTrue(result);
        }
    }
    @Nested
    @DisplayName("Тесты для метода isValidLastName")
    class ForIsValidLastNameTests {

        @Test
        public void isValidLastName__empty_entrance_returnsFalse() {
            String name = "";
            boolean result = UserValidator.isValidLastName(name);
            assertFalse(result);
        }

        @Test
        public void isValidLastName_with_numbers_returnsFalse() {
            String name = "ain12345";
            boolean result = UserValidator.isValidLastName(name);
            assertFalse(result);
        }

        @Test
        public void isValidLastName_returnsTrue() {
            String name = "ain";
            boolean result = UserValidator.isValidLastName(name);
            assertTrue(result);
        }
    }
    @Nested
    @DisplayName("Тесты для метода isValidAge")
    class ForIsValidAgeTests {

        @Test
        public void isValidAge_less_then_zero_returnsFalse() {
            int age = -2;
            boolean result = UserValidator.isValidAge(age);
            assertFalse(result);
        }

        @Test
        public void isValidAge_zero_returnsFalse() {
            int age = 0;
            boolean result = UserValidator.isValidAge(age);
            assertFalse(result);
        }

        @Test
        public void isValidAge_more_than_150_returnsFalse() {
            int age = 151;
            boolean result = UserValidator.isValidAge(age);
            assertFalse(result);
        }

        @Test
        public void isValidAge_returnsTrue() {
            int age = 69;
            boolean result = UserValidator.isValidAge(age);
            assertTrue(result);
        }
    }
    @Nested
    @DisplayName("Тесты для метода isValidHeight")
    class ForIsValidHeightTests {
        @Test
        public void isValidHeight_less_than_zero_returnsFalse() {
            double height = -1.68;
            boolean result = UserValidator.isValidHeight(height);
            assertFalse(result);
        }

        @Test
        public void isValidHeight_zero_returnsFalse() {
            double height = 0.0;
            boolean result = UserValidator.isValidHeight(height);
            assertFalse(result);
        }
        @Test

        public void isValidHeight_more_than_5_returnsFalse() {
            double height = 5.5;
            boolean result = UserValidator.isValidHeight(height);
            assertFalse(result);
        }

        @Test
        public void isValidHeight_returnsTrue() {
            double height = 1.68;
            boolean result = UserValidator.isValidHeight(height);
            assertTrue(result);
        }
    }
}