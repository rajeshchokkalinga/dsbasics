package ds.basics.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Example 1:

      packets := []int32{1, 2, 3, 4, 5}
      channels := 2

      // Explaination: If packet {1, 2, 3, 4} is sent to channel 1, the median of that channel would be 2.5.
      //               If packet {5} is sent to channel 2 its median would be 5.
      //               Total quality would be 2.5 + 5 = 7.5 ~ 8
      answer := 8
      Example 2:

      packets := []int32{5, 2, 2, 1, 5, 3}
      channels := 2

      // Explaination: Channel 1: {2, 2, 1, 3} (median: 2)
      //               Channel 2: {5, 5}       (median: 5)
      //               Total Quality : 2 + 5 = 7

      // Explaination 2: Channel 1: {5, 2, 2, 1, 3} (median: 2)
      //                 Channel 2: {5}             (median: 5)
      //                 Total Quality : 2 + 5 = 7
      answer := 7

*/


public class MaximumQuality {

    public static double highestQualityWithSorting(List<Integer> list, int ch) {
        int length = list.size();
        Collections.sort(list);
        if(ch==1) {
            return calculateMediun(list, 0, list.size()-1);
        }
        // n-ch+1 (not adding 1 because index is zero based)
        int traverseTill = (length - ch);

        double curMedian = calculateMediun(list, 0,traverseTill);

        while(++traverseTill<length) {
            curMedian+=list.get(traverseTill);
        }
        return curMedian;
    }

    private static double calculateMediun(List<Integer> list, int start, int end) {
        int length = end - start+1;
        int mid = (start + end)/2;

        if(length%2==0) {
            return ((double)list.get(mid)+list.get(mid+1))/2;
        }
        return list.get(mid);
    }

    public static double highestQualityWithSorting3(List<Integer> list, int ch) {

        Collections.sort(list);
        int sum = 0;
        int index = list.size()-1;
        while(ch > 1){
            sum += list.get(index);
            index--;
            ch--;
        }

       return calculateMediun(list, 0, index)+sum;
    }



    public static void main(String[] args) {
        System.out.println(highestQualityWithSorting(Arrays.asList(1,2,3,4,5,6), 3));
        System.out.println(highestQualityWithSorting3(Arrays.asList(1,2,3,4,5), 2));
        System.out.println(highestQualityWithSorting(Arrays.asList(1,2,3,4,5), 3));
        System.out.println(highestQualityWithSorting3(Arrays.asList(5,1,2,3,4), 3));
    }
}
