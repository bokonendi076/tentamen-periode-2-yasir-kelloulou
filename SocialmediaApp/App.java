package SocialmediaApp;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        User user = new User(1, "Yasir076", LocalDate.of(2001, 12, 27), Gender.MALE);
        Post post = new Post(23, "Nieuwe post!");

        SocialMediaAnalyzer analyzer = new SocialMediaAnalyzer();

        analyzer.writeNewPostToCSV(121, "New Post yeah!!!", 343, 67);

        System.out.println(user.toString());
        System.out.println(post.toString());
    }
}
