public class ScoreManager {
    private int score;

    public ScoreManager() {
        this.score = 0;
    }

    public void incrementScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }
}