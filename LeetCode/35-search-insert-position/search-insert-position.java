class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                idx = i;
                break;
            } else if(nums[i] > target) {
                idx = i;
                break;
            }
        }
        if(idx == -1) idx = n;
        return idx;
    }
}