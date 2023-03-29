package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class TaskTwo {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] a = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            int[] b = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            binarySearchSolution(a, b);
        }
    }

    private static void binarySearchSolution(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            int l = 0;
            int r = a.length - 1;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (b[i] < a[mid])
                    r = mid;
                else
                    l = mid;
            }
            if (Math.abs(b[i] - a[l]) < Math.abs(b[i] - a[r]))
                System.out.println(a[l]);
            else if (Math.abs(b[i] - a[l]) > Math.abs(b[i] - a[r]))
                System.out.println(a[r]);
            else
                System.out.println(Math.min(a[l], a[r]));
        }
    }
}

