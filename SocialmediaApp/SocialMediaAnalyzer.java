package SocialmediaApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class SocialMediaAnalyzer {

    public void writeNewPostToCSV(int userId, String content, int likes, int comments) {
        String fileName = "Posts.txt";
        String post = userId + ", " + content + ", " + likes + ", " + comments;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(post);
            writer.newLine();
            System.out.println("post added: " + post);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred while adding the post: " + e.getMessage());
        }

    }

    public void readDataFromCSV(String csvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
    
                if (parts.length == 8) {
                    int userId = Integer.parseInt(parts[0]);
                    String username = parts[1];
                    Gender gender = Gender.valueOf(parts[2]);
                    LocalDate birthdate = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                    int postId = Integer.parseInt(parts[4]);
                    String content = parts[5];
                    int likes = Integer.parseInt(parts[6]);
                    int comments = Integer.parseInt(parts[7]);
    
                    User user = new User(userId, username, birthdate, gender);
                    Post post = new Post(postId, content, likes, comments);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
