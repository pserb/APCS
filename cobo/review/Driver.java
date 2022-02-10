public class Driver {
    public static void main(String[] args) {
        System.out.println(Review.sentimentVal("word"));
        System.out.println(Review.sentimentVal("thing"));
        System.out.println(Review.sentimentVal("person"));

        System.out.println(Review.totalSentiment("SimpleReview.txt"));
    }
}
