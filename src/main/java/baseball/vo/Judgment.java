package baseball.vo;

public class Judgment {

    private int ballCount;

    private int strikeCount;

    public Judgment(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
