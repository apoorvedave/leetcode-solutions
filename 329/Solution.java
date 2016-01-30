import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res[][] = new int[matrix.length][matrix[0].length];

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (res[i][j] == 0) {
                    max = Math.max(max, doStuff(matrix, res, i, j));
                }
            }
        }

        return max;
    }

    private int doStuff(int[][] matrix, int[][] res, int i, int j) {

        if (res[i][j] != 0){
            return res[i][j];
        }

        List<Pair<Integer, Integer>> valid = new ArrayList<Pair<Integer, Integer>>();
        valid.add(new Pair<Integer, Integer>(i - 1, j));
        valid.add(new Pair<Integer, Integer>(i + 1, j));
        valid.add(new Pair<Integer, Integer>(i, j - 1));
        valid.add(new Pair<Integer, Integer>(i, j + 1));

        res[i][j] = 1;
        int maxVal = res[i][j];
        for (Pair<Integer, Integer> p : valid) {
            if (p.getKey() < 0 || p.getKey() >= matrix.length || p.getValue() < 0 || p.getValue() >= matrix[0].length
                    || matrix[p.getKey()][p.getValue()] >= matrix[i][j]) {
                continue;
            }
            maxVal = Math.max(maxVal, doStuff(matrix, res, p.getKey(), p.getValue()));
            res[i][j] = maxVal + 1;
        }
        return res[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
