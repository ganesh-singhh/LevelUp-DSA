class 4Sum {
    public static void main(String [] args){
        int [] test1 = {3, 1, 2, 3, 5};
        int [] test2 = {4, 3, 6, 2, 1, 1};
        int [] test3 = {1, 2, 2, 4, 5};

        System.out.println("Test Case 1: " + test1);
        System.out.println("Output: " + fourSum(test1, 0));

        System.out.println("Test Case 2: " + test2);
        System.out.println("Output: " + fourSum(test2, 0));

        System.out.println("Test Case 3: " + test3);
        System.out.println("Output: " + fourSum(test3, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) 
                continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                
                int k = j + 1;
                int l = len - 1;

                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k - 1] == nums[k]) k++;
                        
                        while (k < l && nums[l + 1] == nums[l]) l--;
                    } else if (sum < target)
                        k++;
                    else 
                        l--;
                }
            }
        }

        return ans;
    }
}