public class PasswordTest {

    // This method checks if the character is one of the valid symbols.
    static boolean isValidSymbol(char c) {
        switch (c) {
            case '~':
            case '!':
            case '@':
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '(':
            case ')':
            case '-':
            case '=':
            case '+':
            case '_':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        String argsString = args[0];
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int numCount = 0;
        int validSymbolCount = 0;
        int numCategoriesIncluded = 0;

        // Checking if password is between 8 and 16 characters long.
        if (!((argsString.length() >= 8) && (argsString.length() <= 16))) {
            System.out.println("\n" + "Password is invalid. Length must be between 8 and 16 characters." + "\n"
                    + "Please restart the program and try again.");
            return;
        }

        // Checking if each character is a lowercase letter, uppercase letter, number,
        // or valid symbol.
        for (int i = 0; i < argsString.length(); i++) {
            char c = argsString.charAt(i);
            if (c >= 97 && c <= 122) { // Checking if char is a lowercase letter.
                lowercaseCount++;
            } else if (c >= 65 && c <= 90) { // Checking if char is an uppercase letter.
                uppercaseCount++;
            } else if (c >= 48 && c <= 57) { // Checking if char is a number between 0 and 9.
                numCount++;
            } else if (isValidSymbol(c)) { // Checking if char is a valid symbol.
                validSymbolCount++;
            } else {
                System.out.println(
                        "\n" + "The password contains an invalid character. Please restart the program and try again.");
                return;
            }
        }

        if (lowercaseCount > 0) {
            numCategoriesIncluded++;
        }
        if (uppercaseCount > 0) {
            numCategoriesIncluded++;
        }
        if (numCount > 0) {
            numCategoriesIncluded++;
        }
        if (validSymbolCount > 0) {
            numCategoriesIncluded++;
        }
        if (numCategoriesIncluded < 3) { // Checking if at least three of the four categories have been met.
            System.out.println("\n" + "Password is invalid. Please restart the program and try again.");
            return;
        }

        System.out.println("\n" + "The password is valid!"); // The password has passed all of the tests.
    }
}