package baseball.game;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.vo.Judgment;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자 야구 게임 class
 */
public class NumbersBaseballGame {

    private Computer computer;

    private Referee referee;

    private Player player;

    public NumbersBaseballGame(Computer computer, Referee referee, Player player) {
        this.computer = computer;
        this.referee = referee;
        this.player = player;
    }

    public boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!("1".equals(input) || "2".equals(input))) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. " + input);
        }
        if ("2".equals(input)) {
            System.out.println("게임 종료");
            return false;   // 종료
        }
        return true;    // 새로운 게임
    }

    public void play() {
        computer.pickThreeNumbers();
        Judgment judgment = null;
        do {
            System.out.printf("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            player.pickThreeNumbers(input);
            judgment = referee.callJudgment(computer.getThreeNumbers(), player.getThreeNumbers());
            printJudgment(judgment);
        } while (judgment.getStrikeCount() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private void printJudgment(Judgment judgment) {
        System.out.println(judgment);
    }
}
