import java.util.Scanner;

public class PasswordStrengthValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean isStrong = validateLength(password) &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password);

        if (isStrong) {
            System.out.println(" Your password is strong.");
        } else {
            System.out.println(" Your password is weak. It must:");
            if (!validateLength(password)) System.out.println("- Be at least 8 characters long");
            if (!containsUppercase(password)) System.out.println("- Contain at least one uppercase letter");
            if (!containsLowercase(password)) System.out.println("- Contain at least one lowercase letter");
            if (!containsDigit(password)) System.out.println("- Contain at least one digit");
            if (!containsSpecialCharacter(password)) System.out.println("- Contain at least one special character");
        }

        scanner.close();
    }

    public static boolean validateLength(String password) {
        return password.length() >= 8;
    }

    public static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    public static boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    public static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    public static boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\";
        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) return true;
        }
        return false;
    }
}