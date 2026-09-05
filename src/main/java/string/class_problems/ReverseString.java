package string.class_problems;
public class ReverseString {
    public static String reverse(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String original = "hello";
        System.out.println("Reversed: " + reverse(original));
    }
}
