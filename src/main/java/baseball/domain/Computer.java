package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 상대방(컴퓨터)  class
 */
public class Computer {

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    /**
     * 3가지 숫자 뽑기
     * @return 1에서 9까지의 서로 다른 숫자 3가지
     */
    public List<Integer> pickThreeNumbers() {
        numbers.clear();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 9, 3));
        return numbers;
    }

    /**
     * 선택한 3가지 숫자 반환
     * @return 1에서 9까지의 서로 다른 숫자 3가지
     */
    public List<Integer> getThreeNumbers() {
        return numbers;
    }

}
