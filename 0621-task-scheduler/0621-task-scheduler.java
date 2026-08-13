class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Har task ki frequency count karo
        int[] freq = new int[26]; 
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Step 2: Sort karo taaki maxFreq easily mil jaye
        Arrays.sort(freq);
        int maxFreq = freq[25]; // sabse last (sabse zyada frequency)
        
        // Step 3: Kitne tasks hain jinki frequency maxFreq ke barabar hai
        int maxCount = 0;
        for (int i = 25; i >= 0 && freq[i] == maxFreq; i--) {
            maxCount++;
        }
        
        // Step 4: Formula apply karo
        int formulaResult = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Step 5: Maximum lo formula aur actual tasks length ke beech
        return Math.max(formulaResult, tasks.length);
    }
}