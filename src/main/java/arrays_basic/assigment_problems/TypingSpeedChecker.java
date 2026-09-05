package arrays_basic.assigment_problems;
public class TypingSpeedChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';
        int minLength = Math.min(original.length(), typed.length());
        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }
        double accuracy = ((double) matches / original.length()) * 100.0;

        if (firstMismatchPos != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matches, original.length(), accuracy, firstMismatchPos, origChar, typedChar);
        } else if (typed.length() != original.length()) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | Length mismatch (Expected: %d, Typed: %d)%n",
                    matches, original.length(), accuracy, original.length(), typed.length());
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matches, original.length(), accuracy);
        }
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
