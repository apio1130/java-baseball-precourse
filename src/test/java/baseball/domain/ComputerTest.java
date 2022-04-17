package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 세자리_수_생성_확인() {
        Computer computer = new Computer();
        for (int i = 0; i < 10; i++) {
            List<Integer> pickThreeNumbers = computer.pickThreeNumbers();
            System.out.println(pickThreeNumbers.toString());
            assertThat(pickThreeNumbers).hasSize(3);
        }
    }

    @Test
    void 서로_다른_세자리_수_중복체크() {
        Computer computer = new Computer();
        for (int i = 0; i < 10; i++) {
            List<Integer> pickThreeNumbers = computer.pickThreeNumbers();
            System.out.println(pickThreeNumbers.toString());
            Set<Integer> pickNumberSet = new HashSet<>(pickThreeNumbers);
            assertThat(pickNumberSet).hasSize(3);
        }
    }

}
