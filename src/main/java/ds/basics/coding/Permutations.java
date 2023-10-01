package ds.basics.coding;

import java.util.Scanner;

public class Permutations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter String to find permutations:");
        String s = scan.next();
        permutations(s.toCharArray(), 0);

    }

    static void permutations(char[] ar, int fi) {
        if (fi == ar.length - 1) {
            System.out.println(ar);
            return;
        }
        for (int i = fi; i < ar.length; i++) {
            swap(ar, i, fi);
            permutations(ar, fi + 1);
            swap(ar, i, fi);
        }

    }

    static void swap(char[] ar, int i, int fi) {
        char temp = ar[i];
        ar[i] = ar[fi];
        ar[fi] = temp;
    }

}
