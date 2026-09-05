package arrays_basic.assigment_problems;
public class MovieReviewProfiler {
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }
    public static void main(String[] args) {
        String review1 = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review1);
        String review2 = "Good plot but slow pace";
        classifyWordLengths(review2);
    }
}
