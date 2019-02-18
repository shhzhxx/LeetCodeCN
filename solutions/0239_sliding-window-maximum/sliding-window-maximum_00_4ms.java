class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 || k == 0){
            return nums;
        }else{
            int[] rst = new int[nums.length - k + 1];             // 结果数组
            int max_0 = findMax(nums, 0, k - 1);
            int max_1 = findMax(nums, max_0 + 1, k - 1);
            rst[0] = nums[max_0];
            
            for(int i = 1;i + k - 1 < nums.length;++i){
                int end = i + k - 1;
                if(max_0 < i){
                    if(max_0 == max_1){
                        max_0 = findMax(nums, i, end);
                        max_1 = findMax(nums, max_0 + 1, end);
                    }else if(nums[max_1] <= nums[end]){
                        max_0 = end;
                        max_1 = end;
                    }else{
                        max_0 = max_1;
                        max_1 = findMax(nums, max_0 + 1, end);
                    }
                }else{
                    if(max_0 == max_1){
                        if(nums[max_0] <= nums[end]){
                            max_0 = end;
                        }
                        max_1 = end;
                    }else if(nums[max_0] <= nums[end]){
                        max_0 = end;
                        max_1 = end;
                    }else if(nums[max_1] <= nums[end]){
                        max_1 = end;
                    }
                }
                
                rst[i] = nums[max_0];
            }
            return rst;
        }
    }
    
    public int findMax(int[] nums, int lt, int rt){
        if(lt >= rt){
            return rt;
        }
        rt = (nums.length - 1) > rt ? rt : nums.length - 1;
        for(int i = lt;i <= rt;++i){
            if(nums[i] > nums[lt]){
                lt = i;
            }
        }
        return lt;
    }
}