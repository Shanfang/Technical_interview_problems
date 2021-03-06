// update one array to generate each list, similar approach to optimize space complexity in DP
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}

// treat the triangle as left upper part of a matrix
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        int[][] matrix = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            matrix[i][0] = 1;
            matrix[0][i] = 1;
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(matrix[i - j][j]);
            }
            result.add(list);
        }
        return result;
    }
}
