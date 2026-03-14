class Solution {
    public String maximumBinaryString(String binary) {
        int cz = 0;
        int n = binary.length();
        char[] res = new char[n];
        for (int i = 0; i < n; i++) 
            res[i] = '1';

        for(int i= 0 ; i< n ;i++ ) 
        {
            if(binary.charAt(i) == '0') cz++;
        }

        for(int  i = 0 ; i< n ;i++) {

            if( binary.charAt(i) == '0') {
              int idx=  i + cz-1;
              res[idx]= '0';
              break;
            }
        }
        return new String(res);
    }
}