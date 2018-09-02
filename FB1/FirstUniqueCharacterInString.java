class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        int index  = Integer.MAX_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) != -1) {
                index = Math.min(index, map.get(key));
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
