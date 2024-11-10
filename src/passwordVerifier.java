import java.util.regex.*;

public class passwordVerifier {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        String lowerCasePattern = ".*[a-z].*";
        String upperCasePattern = ".*[A-Z].*";
        String digitPattern = ".*[0-9].*";
        String specialCharPattern = ".*[~!@#$%^&*()\\-=+_].*";

        int categoryCount = 0;

        if (Pattern.matches(lowerCasePattern, password)) {
            categoryCount++;
        }
        if (Pattern.matches(upperCasePattern, password)) {
            categoryCount++;
        }
        if (Pattern.matches(digitPattern, password)) {
            categoryCount++;
        }
        if (Pattern.matches(specialCharPattern, password)) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        String password = "Example@123";
        
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
