package baseball.vo;

public class Judgment {

    private int ballCount;

    private int strikeCount;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public Judgment call(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        return this;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        return resultMessage();
    }

    private String resultMessage() {
        String message = "";
        if (ballCount > 0) {
            message += ballCount + "볼";
        }
        message += lineDivision();
        if (strikeCount > 0) {
            message += strikeCount + "스트라이크";
        }
        return message;
    }

    private String lineDivision() {
        if (ballCount > 0 && strikeCount > 0) {
             return " ";
        }
        return "";
    }

}
