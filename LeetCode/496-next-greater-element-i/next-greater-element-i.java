class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            mp.put(nums1[i], i);
            res[i] = -1;
        }
        st.push(nums2[0]);
        for(int i = 1; i < nums2.length; i++) {
            if(nums2[i] > st.peek()) {
                while(!st.isEmpty() && nums2[i] > st.peek()) {
                    if(mp.containsKey(st.peek())) 
                        res[mp.get(st.peek())] = nums2[i];
                    st.pop();
                }
                st.push(nums2[i]);
            } else {
                st.push(nums2[i]);
            }
        }
        return res;
    }
}