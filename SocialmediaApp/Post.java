package SocialmediaApp;

public class Post {
    private int postId;
    private String content;
    private int likes;
    private int comments;

    public Post(int postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    // overload
    public Post(int postId, String content, int likes, int comments) {
        this.postId = postId;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
    }

    public void incrementLikes(int incrementBy) {
        this.likes += incrementBy;
    }

    public void incrementComments(int incrementBy) {
        this.comments += incrementBy;
    }

    public void decrementLikes(int decrementBy) {
        if (decrementBy > this.likes) {
            System.out.println("decrement amount exceeds likes amount...");

        } else {
            this.likes -= decrementBy;
        }
    }

    public void decrementComments(int decrementBy) {
        if (decrementBy > this.comments) {
            System.out.println("decrement amount exceeds comments amount...");

        } else {
            this.comments -= decrementBy;
        }
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post [postId=" + postId + ", content=" + content + ", likes=" + likes + ", comments=" + comments + "]";
    }

}
