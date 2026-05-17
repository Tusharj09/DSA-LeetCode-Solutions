class Solution {
    public int totalFruit(int[] fruits) {


    HashMap<Integer,Integer> baskets = new HashMap<>();
    int n = fruits.length, maxFruit=0;
    int j = 0;
    for(int i = 0 ; i< n; i++) {
        baskets.put(fruits[i], baskets.getOrDefault(fruits[i],0) +1);
        while (baskets.size() > 2) {
            baskets.put(fruits[j], baskets.get(fruits[j]) - 1);
            
                if (baskets.get(fruits[j]) == 0) {
                    baskets.remove(fruits[j]);
                }

                j++;
            
        }
        

        maxFruit = Math.max(maxFruit, i-j+1);

    }
    
        return maxFruit;
    }
}