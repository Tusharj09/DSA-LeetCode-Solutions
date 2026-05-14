class Solution {

     public boolean compare(int[] a, int[] b) {

        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
    if(n > m) return false;
     int[] s1Freq =  new int[26];
     int[] resultFreq = new int[26];


     for(int i = 0  ; i< n; i++ ) {
        char ch = s1.charAt(i);
         s1Freq[ch - 'a']++;
     }
     for(int i = 0 ; i< n ; i++) {
        char ch = s2.charAt(i);
         resultFreq[ch - 'a']++;
     }  
     if(compare(s1Freq,resultFreq)) return true;
     

     for(int i = n; i< m; i++) {
        char ch = s2.charAt(i);
        char remove = s2.charAt(i-n);
          resultFreq[remove- 'a']--;
          resultFreq[ch- 'a']++;
          
          if(compare(s1Freq,resultFreq)) return true;
     }

     return false;




        



     }
}