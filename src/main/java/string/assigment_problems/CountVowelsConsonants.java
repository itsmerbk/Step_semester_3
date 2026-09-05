package string.assigment_problems;
public class CountVowelsConsonants {
    public static void countCharacters(String input) {
        if (input == null) return;
        int vowels = 0, consonants = 0;
        String lower = input.toLowerCase();
        for (char ch : lower.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) {
        countCharacters("Hello World");
    }
}
