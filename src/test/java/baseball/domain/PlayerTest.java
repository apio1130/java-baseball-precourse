package baseball.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 세자리_숫자_입력_확인() {
        Player player = new Player();
        String input = "123";
        List<Integer> numbers = player.pickThreeNumbers(input);
        System.out.println("numbers = " + numbers);
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    void 예외처리_문자입력_테스트() {
        Player player = new Player();
        String input = "12삼";
        Assertions.assertThatThrownBy(() -> {
            player.pickThreeNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외처리_중복숫자_테스트() {
        Player player = new Player();
        String input = "122";
        Assertions.assertThatThrownBy(() -> {
            player.pickThreeNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외처리_자리수_테스트() {
        Player player = new Player();
        String input1 = "1234";
        // 4자리
        Assertions.assertThatThrownBy(() -> {
            player.pickThreeNumbers(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        String input2 = "1";
        // 1자리
        Assertions.assertThatThrownBy(() -> {
            player.pickThreeNumbers(input2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
