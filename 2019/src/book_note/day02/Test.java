package book_note.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Test {
    public static void main(String[] args) {
        new Test().getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 1) {
            return result;
        }
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            if (i == 0) {
                continue;
            }
            if (i > 1) {
                int size = result.size();
                for (int j = size - 1; j > 0; j--) {
                    int val = result.get(j) + result.get(j - 1);
                    result.set(j, val);
                }
            }
            result.add(1);
        }
        return result;
    }
}

