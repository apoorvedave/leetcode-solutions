public class Solution {
	public int minPatches(int[] nums, int n) {
		long sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			while (sum < nums[i] - 1 && sum < n) {
				sum = 2 * sum + 1;
				//System.out.println(sum + 1);
				++count;
			}
			sum += nums[i];
		}
		while (sum < n) {
			//System.out.println(sum + 1);
			sum = 2 * sum + 1;
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minPatches(new int[] { 1,2,2,6,34,38,41,44,47,47,56,59,62,73,77,83,87,89,94 }, 20));
	}
}
