class Solution {

    

    public List<List<String>> groupAnagrams(String[] strs) {
    
       Map<String, List<String>>  hmap = new HashMap<>();

       for(int i = 0 ; i< strs.length; i++) {

        char[] chars = strs[i].toCharArray();

        Arrays.sort(chars);
        String curr = new String(chars);
        hmap.putIfAbsent(curr, new ArrayList<>());
        hmap.get(curr).add(strs[i]);
    
       }
       return new ArrayList<>(hmap.values());
    
        
    }
}