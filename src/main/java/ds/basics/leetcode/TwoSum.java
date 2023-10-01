package ds.basics.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]){
        //CASE 1
    int[] nums = {2,7,11,15};
    int target = 9;
    int[] result = new TwoSum().twoSumV2(nums, target);
    System.out.println("EXPECTED: 0 1");
    System.out.println("ACTUAL: "+result[0] + " " + result[1]);

        //CASE 2
    nums = new int[]{3,2,4};
    target = 6;
    result = new TwoSum().twoSumV2(nums, target);
    System.out.println("EXPECTED: 1 2");
    System.out.println("ACTUAL: "+result[0] + " " + result[1]);

        //CASE 3
    nums = new int[]{3,3};
    target = 6;
    result = new TwoSum().twoSumV2(nums, target);
        System.out.println("EXPECTED: 0 1");
    System.out.println("ACTUAL: "+result[0] + " " + result[1]);
    }

    //RUNTIME  45 MS
    //MEMORY 43.56
    public int[] twoSumV1(int[] nums, int target) {
        if(nums.length > 1)
            for(int i = 0;i<nums.length;i++){
                for(int j= i+1;j<nums.length;j++){
                    if(nums[i]+nums[j] == target)
                        return new int[]{i, j};
                }
            }
        return new int[] {};
    }


    //RUNTIME  1 MS
    //MEMORY 44.06MB
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer requiredNum = target - nums[i];
            //if (indexMap.containsKey(requiredNum)) {
            if (indexMap.get(requiredNum) != null) {
                return new int[] {indexMap.get(requiredNum), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
