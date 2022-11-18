package leetcode;

import java.util.Arrays;
import java.util.List;

public class MakeSquare_473 {
    public boolean makeSquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int edgeLength = sum / 4;
        List<Integer> length = Arrays.stream(matchsticks).sorted().boxed().toList();
        for (int i = 0; i < matchsticks.length; i++) {

        }
        return false;
    }
}
