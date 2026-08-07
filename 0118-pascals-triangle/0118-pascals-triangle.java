import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();

            // Every row starts with 1
            currentRow.add(1);

            // Calculate the middle elements
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1)
                         + triangle.get(i - 1).get(j);

                currentRow.add(value);
            }

            // Every row with more than one element ends with 1
            if (i > 0) {
                currentRow.add(1);
            }

            triangle.add(currentRow);
        }

        return triangle;
    }
}