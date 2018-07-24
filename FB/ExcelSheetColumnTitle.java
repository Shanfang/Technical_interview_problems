class Solution {
    public String convertToTitle(int n) {
        String result = "";
        while (n != 0) {
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            result = ch + result;
        }
    return result;
    }
}
