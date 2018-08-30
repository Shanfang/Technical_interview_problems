class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);
                if (isPalindrome(str1)) {
                    String str2R = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2R) && map.get(str2R) != i) {
                        result.add(Arrays.asList(map.get(str2R), i));
                    }
                }
                if (j != word.length() && isPalindrome(str2)) {
                    String str1R = new StringBuilder(str1).reverse().toString();
                    // "", "abba" has been added in the above if statement
                    // we should avoid "abba", "", AKA when str2 = ""
                    if (map.containsKey(str1R) && map.get(str1R) != i) {
                        result.add(Arrays.asList(i, map.get(str1R)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
