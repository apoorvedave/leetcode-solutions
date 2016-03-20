import java.util.ArrayList;

public class Solution {
    public int[] countBits(int num) {
        
        //base cases
        if (num==0){
            return new int[]{0};
        }
        
        //storing powers of 2 with index i
        ArrayList<Integer> powersOf2 = new ArrayList<>();
        powersOf2.add(1);
        int j = 1;
        while(j<=num){
            powersOf2.add(2*powersOf2.get(j-1));
            j++;
        }

        int powerIdx = 0;
        
        int[] result = new int[num+1];
        result[0]=0;
        
        for (int i=1; i<num+1; i++) {
            if (powerIdx+1<powersOf2.size() && powersOf2.get(powerIdx+1)<=i){
                powerIdx++;
            }
            result[i] = 1 + result[i-powersOf2.get(powerIdx)];
        }
        return result;
    }
}
