package ds.basics.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOfServerPower {
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{4,1,3}));
        System.out.println(solution(new int[]{1,3,4}));

        List<Integer> power = Arrays.asList(1, 3, 4);
        int total = 0;

        for (int i = 0; i < power.size(); i++) {
            for (int j = i + 1; j <= power.size(); j++) {
                total = total + (power.subList(i, j).stream().min(Integer::compare).get() * power.subList(i, j).stream().reduce(0, Integer::sum));
            }
        }
        System.out.println(total);
    }

    public static int solution(int[] arr) {
        int n = arr.length, k = 1, cur = 0, ans = 0;
        int[][] mindp = new int[n][n];
        // construct an array for sum of subarray
        int[] sum = new int[n + 1];
        for(int num : arr) {
            cur += num;
            sum[k++] = cur;
        }

        // create a matrix to find out the minimum integer between index i and j
        for(int i = 0; i < arr.length; i++) {
            LinkedList<Integer> stack = new LinkedList<>();
            for(int j = i; j < arr.length; j++) {
                while(!stack.isEmpty() && (arr[stack.peekFirst()] > arr[j])) {
                    stack.removeFirst();
                }
                stack.addLast(j);
                mindp[i][j] = arr[stack.peekFirst()];
            }
        }
        // sum up all the possible subarrays using index i and j with the matrix and array
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                ans += mindp[i][j] * (sum[j + 1] - sum[i]);
            }
        }
        return ans;
    }
}
