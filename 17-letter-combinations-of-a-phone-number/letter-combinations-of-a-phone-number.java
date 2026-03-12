class Solution {

    List<String> result = new ArrayList<>();


    void possibleCombinations(String[]teleData, int digit) {
         List<String> temp = new ArrayList<>();
        
        for(int i= 0 ; i<teleData[digit].length() ;i++) {
            char c = teleData[digit].charAt(i);
            
            if(result.size() == 0) {
            temp.add(String.valueOf(c));
            }
            else {
                for(int j = 0 ; j<result.size();j++) {
                   String newVal = result.get(j) + c;
                    temp.add(newVal);
                }
            }
          
        }
          result = temp;
    }

    public List<String> letterCombinations(String digits) {

       
        String[] teleData= new String[10];

        teleData[0] = "";
        teleData[1] ="";
        teleData[2] = "abc";
        teleData[3]= "def";
        teleData[4] = "ghi";
        teleData[5] = "jkl";
        teleData[6] ="mno";
        teleData[7] = "pqrs";
        teleData[8]= "tuv";
        teleData[9]= "wxyz";


        for(int i = 0 ; i<digits.length(); i++) {

            
            possibleCombinations(teleData, digits.charAt(i)- '0');
        }

        return result;
        
    }
}