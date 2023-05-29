package de.ait.services;

public class UserValidator {

    public static boolean containsNumbers(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidFirstName(String firstName) {
        if (firstName.isEmpty() || containsNumbers(firstName)) {
            System.out.println("Некорректный ввод имени. " +
                    "Проверьте вводимые данные и повторите ввод");
            return false;
        }
        return true;
    }

    public static boolean isValidLastName(String lastName) {
        if (lastName.isEmpty() || containsNumbers(lastName)) {
            System.out.println("Некорректный ввод фамилии. " +
                    "Проверьте вводимые данные и повторите ввод");
            return false;
        }
        return true;
    }

    public static boolean isValidAge(int age) {
        if (age <= 0 || age > 150) {
            System.out.println("Некорректный ввод данных о возрасте. " +
                    "Укажите число полных лет");
            return false;
        }
        return true;
    }

    public static boolean isValidHeight(double height) {
        if (height <= 0.00 || height >= 5.00) {
            System.out.println("Некорректный ввод данных о росте. " +
                    "Данные укадите в метрах и через запятую");
            return false;
        }
        return true;
    }
}
