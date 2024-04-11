package SocialmediaApp;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

public class User {
    private int userId;
    private String username;
    private LocalDate birthDate;
    private Gender gender;
    private ArrayList<Post> posts;

    public User(int userId, String username, LocalDate birthDate, Gender gender) {
        this.userId = userId;
        this.username = username;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public void addPost(Post post) {
        this.posts.add(post);

    }

    public Post findMostLikedPost() {
        int tracker = 0;
        Post bestPerformingPost = null;

        for (Post post : posts) {
            int currentPostLikes = post.getLikes();

            if (currentPostLikes > tracker) {
                tracker = currentPostLikes;

            } else {
                bestPerformingPost = post;
            }
        }
        return bestPerformingPost;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", birthDate=" + birthDate + ", gender=" + gender
                + "]";
    }

}
