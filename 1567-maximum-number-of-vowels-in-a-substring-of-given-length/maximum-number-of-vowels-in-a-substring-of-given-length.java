class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0 , count = 0;
        for(int i = 0 ; i< k ; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
            }
        }

        maxCount = Math.max(maxCount, count);

        for(int i = k ; i < s.length(); i++) {
                char ch = s.charAt(i);
                char rCh = s.charAt(i-k);
            if(rCh == 'a' || rCh == 'e' || rCh == 'i' || rCh == 'o' || rCh == 'u') {
                    count--;
            }
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                    maxCount  = Math.max(count, maxCount);
            }

        }
        return maxCount;
    }
}