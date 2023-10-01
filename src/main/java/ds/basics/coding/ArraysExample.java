package ds.basics.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysExample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Integer[] arr = { 2, 1, 0, 0, 3, 3, 2, 4, 1, 1, 4 };
        print(replaceDuplicateWithZero(arr));
        print(Arrays.asList(replaceDuplicateWithZero2(arr)));
    }

    /**
     * Sort Replace duplicate elements with 0.
     */
    private static List<Integer> replaceDuplicateWithZero(Integer[] arr) {
        List<Integer> arrList = Arrays.asList(arr);
        List<Integer> arrListOutput = new ArrayList<>();

        arrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
              .forEach(e -> {
                  if (e.getValue() > 0) for (int i = 0; i < e.getValue(); i++) {
                      if (i == 0) arrListOutput.add(e.getKey().intValue());
                      else arrListOutput.add(0);
                  }

              });
        return arrListOutput;

    }

    /**
     * Sort Replace duplicate elements with 0.
     */
    private static Integer[] replaceDuplicateWithZero2(Integer[] arr) {
        Arrays.sort(arr);
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == prev) {
                arr[i] = 0;
            } else {
                prev = arr[i];
            }
        }
        return arr;
    }

    private static void print(List<Integer> val) {
        System.out.println("\nPrinting ArrayList using a for-each loop:");
        for (Integer item : val) {
            System.out.print(item);
        }
    }
}
