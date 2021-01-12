package SortingMerging;

import java.util.Arrays;

class SortedMerge {
    public static void sm(int[] A, int[] B, int a, int b) {
        if (b == 0) {
            return;
        }

        int p1 = a - 1, p2 = b - 1, end = a + b - 1;

        while(p1 >= 0 && p2 >= 0) {
            if (A[p1] > B[p2]) {
                A[end] = A[p1];
                p1--;
            } else {
                A[end] = B[p2];
                p2--;
            }
            end--;

        }

        if (p1 >= 0) {
            while(p1 >= 0) {
                A[end] = A[p1];
                p1--;
                end--;
            }
        }

        if (p2 >= 0) {
            while(p2 >= 0) {
                A[end] = B[p2];
                p2--;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,10,12,17, 0, 0, 0, 0, 0};
        int[] B = new int[] {2, 11, 13, 14, 18};
        
        sm(A, B, 4, 5);
        System.out.println(Arrays.toString(A));
    }
}