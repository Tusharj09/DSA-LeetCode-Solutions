class Solution {
    public String smallestPalindrome(String s) {
        int[] freqChar = new int[26];
        for(char ch : s.toCharArray()){
            freqChar[ch - 'a']++;
        }
        
        StringBuilder firstHalf = new StringBuilder();
        String middle = "";
        
        for(int i=0; i<26; i++){
            if(freqChar[i] % 2 != 0){
                middle = String.valueOf((char)(i + 'a'));
                freqChar[i]--;
            }
            for(int j=0; j < freqChar[i]/2; j++){
                firstHalf.append((char)(i + 'a'));
            }
        }
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        
        return firstHalf.toString()+middle+secondHalf;
    }
}