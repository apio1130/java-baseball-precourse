package baseball.domain;

import baseball.vo.Judgment;
import java.util.List;

/**
 * 심판 class
 */
public class Referee {

    private static final int NUMBER_LENGTH = 3;

    /**
     * 판정 호출
     * @param computerNumbs 상대방(컴퓨터)의 3자리 숫자
     * @param playerNumbs 사용자의 3자리 숫자
     * @return 상대방과 사용자의 숫자 비교 판정 정보
     */
    public Judgment callJudgment(List<Integer> computerNumbs, List<Integer> playerNumbs) {
        int ballCount = checkBall(computerNumbs, playerNumbs);
        int strikeCount = checkStrike(computerNumbs, playerNumbs);
        return new Judgment(ballCount, strikeCount);
    }

    private int checkBall(List<Integer> computerNumbs, List<Integer> playerNumbs) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int playerNumb = playerNumbs.get(i);
            if (computerNumbs.contains(playerNumb) && computerNumbs.get(i).compareTo(playerNumbs.get(i)) != 0) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int checkStrike(List<Integer> computerNumbs, List<Integer> playerNumbs) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbs.get(i).compareTo(playerNumbs.get(i)) == 0) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
