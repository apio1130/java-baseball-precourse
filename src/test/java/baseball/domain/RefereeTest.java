package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.vo.Judgment;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 판정_3스트라이크() {
        Referee referee = new Referee();

        List<Integer> computerNumbs = new ArrayList<>();
        computerNumbs.add(1);
        computerNumbs.add(2);
        computerNumbs.add(3);

        List<Integer> playerNumbs = new ArrayList<>();
        playerNumbs.add(1);
        playerNumbs.add(2);
        playerNumbs.add(3);

        Judgment judgment = referee.callJudgment(computerNumbs, playerNumbs);

        assertThat(judgment.getBallCount()).isZero();
        assertThat(judgment.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 판정_낫싱() {
        Referee referee = new Referee();

        List<Integer> computerNumbs = new ArrayList<>();
        computerNumbs.add(1);
        computerNumbs.add(2);
        computerNumbs.add(3);

        List<Integer> playerNumbs = new ArrayList<>();
        playerNumbs.add(4);
        playerNumbs.add(5);
        playerNumbs.add(6);

        Judgment judgment = referee.callJudgment(computerNumbs, playerNumbs);

        assertThat(judgment.getBallCount()).isZero();
        assertThat(judgment.getStrikeCount()).isZero();
    }

    @Test
    void 판정_2볼1스트라이크() {
        Referee referee = new Referee();

        List<Integer> computerNumbs = new ArrayList<>();
        computerNumbs.add(1);
        computerNumbs.add(2);
        computerNumbs.add(3);

        List<Integer> playerNumbs = new ArrayList<>();
        playerNumbs.add(3);
        playerNumbs.add(2);
        playerNumbs.add(1);

        Judgment judgment = referee.callJudgment(computerNumbs, playerNumbs);

        assertThat(judgment.getBallCount()).isEqualTo(2);
        assertThat(judgment.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void 판정_1볼1스트라이크() {
        Referee referee = new Referee();

        List<Integer> computerNumbs = new ArrayList<>();
        computerNumbs.add(1);
        computerNumbs.add(2);
        computerNumbs.add(3);

        List<Integer> playerNumbs = new ArrayList<>();
        playerNumbs.add(3);
        playerNumbs.add(2);
        playerNumbs.add(4);

        Judgment judgment = referee.callJudgment(computerNumbs, playerNumbs);

        assertThat(judgment.getBallCount()).isEqualTo(1);
        assertThat(judgment.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void 판정_2스트라이크() {
        Referee referee = new Referee();

        List<Integer> computerNumbs = new ArrayList<>();
        computerNumbs.add(1);
        computerNumbs.add(2);
        computerNumbs.add(3);

        List<Integer> playerNumbs = new ArrayList<>();
        playerNumbs.add(1);
        playerNumbs.add(2);
        playerNumbs.add(4);

        Judgment judgment = referee.callJudgment(computerNumbs, playerNumbs);

        assertThat(judgment.getBallCount()).isZero();
        assertThat(judgment.getStrikeCount()).isEqualTo(2);
    }

}