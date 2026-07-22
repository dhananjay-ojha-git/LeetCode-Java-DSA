class Solution {
    public int maxSum(int[] nums) {
        int[] first = new int[10];  
        int[] second = new int[10]; 
        int result = -1;

        for (int num : nums) {
            int digit = largestDigit(num);

            if (num > first[digit]) {
                second[digit] = first[digit];
                first[digit] = num;
            } else if (num > second[digit]) {
                second[digit] = num;
            }
            if (second[digit] > 0) {
                result = Math.max(result, first[digit] + second[digit]);
            }
        }

        return result;
    }

    private int largestDigit(int num) {
        int max = 0;
        while (num > 0) {
            int d = num % 10;
            max = Math.max(max, d);
            num /= 10;
        }
        return max;
    }
}