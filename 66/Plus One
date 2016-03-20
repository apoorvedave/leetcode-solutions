public class Solution {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length-1;
        while (i>=0) {
            digits[i]++;
            if (digits[i]<10){
                break;
            }
            digits[i] = 0;
            i--;
        }
        
        if (digits[0] == 0){
            // return array of size 1 more than digits with first bit 1;
            int [] res = new int [digits.length+1];
            res[0]=1;
            return res;
        }
        return digits;
    }
}
