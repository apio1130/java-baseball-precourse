package baseball.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 플레이어 class
 */
public class Player {

    private final List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    /**
     * 3가지 숫자 뽑기
     * @param input 사용자 입력
     * @return 1에서 9까지의 서로 다른 숫자 3가지
     */
    public List<Integer> pickThreeNumbers(String input) {
        validation(input);
        return convertNumbers(numbers, input);
    }

    private void validation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. " + input);
        }
        for (int i = 0; i < input.length(); i++) {
            checkNumber(input, i);
            checkDuplication(input, i);
        }
    }

    private void checkDuplication(String input, int idx) {
        for (int i = idx + 1; i < input.length(); i++) {
            checkDuplication(input, idx, i);
        }
    }

    private void checkDuplication(String input, int currentCharIdx, int nextCharIdx) {
        if (input.charAt(currentCharIdx) == input.charAt(nextCharIdx)) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. " + input);
        }
    }

    private void checkNumber(String input, int idx) {
        if (!Character.isDigit(input.charAt(idx))) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. " + input);
        }
    }

    private List<Integer> convertNumbers(List<Integer> numbers, String numbTxt) {
        numbers.clear();
        for (int i = 0; i < numbTxt.length(); i++) {
            numbers.add(numbTxt.charAt(i) - '0');
        }

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
