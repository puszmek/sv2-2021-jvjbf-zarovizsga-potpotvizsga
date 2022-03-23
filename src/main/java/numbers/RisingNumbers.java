package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RisingNumbers {

    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        validateListOfNumbers(numbers);
        int count = 0;
        for (int number : numbers) {
            if (isSixDigitNumber(number) && isRisingNumber(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRisingNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }
        return areDigitsDifferent(digits) && areDigitsRising(digits);
    }

    private boolean areDigitsDifferent(List<Integer> digits) {
        return digits.size() == new HashSet<>(digits).size();
    }

    private boolean areDigitsRising(List<Integer> digits) {
        List<Integer> expected = new ArrayList<>(digits);
        Collections.sort(expected);
        Collections.reverse(expected);
        return digits.equals(expected);
    }

    private boolean isSixDigitNumber(int number) {
        return number > 99_999 && number < 1_000_000;
    }

    private void validateListOfNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("There are no numbers!");
        }
    }
}
