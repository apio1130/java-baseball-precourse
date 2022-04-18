package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.game.NumbersBaseballGame;

public class Application {
    public static void main(String[] args) {
        // 프로그램 구현
        Computer computer = new Computer(); // 컴퓨터
        Referee referee = new Referee();    // 삼핀
        Player player = new Player();       // 사용자
        // 숫자 야구 게임 시작
        NumbersBaseballGame game = new NumbersBaseballGame(computer, referee, player);
        do {
            game.play();    // 게임 시작
        } while (game.isContinue());  // 재시작 여부 체크
    }
}
