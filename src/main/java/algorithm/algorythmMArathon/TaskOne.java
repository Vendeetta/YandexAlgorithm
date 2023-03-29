package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class TaskOne {
    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            reader.readLine();
//            Integer[] a = Arrays.stream(reader.readLine().split(" "))
//                    .map(Integer::parseInt)
//                    .toArray(Integer[]::new);
//            Integer[] b = Arrays.stream(reader.readLine().split(" "))
//                    .map(Integer::parseInt)
//                    .toArray(Integer[]::new);
//
//            Arrays.sort(a);
//            for (int i = 0; i < b.length; i++) {
//                int l = -1;
//                int r = a.length;
//                while (r - l > 1) {
//                    int mid = (l + r) / 2;
//                    if (b[i] < a[mid])
//                        r = mid;
//                    else
//                        l = mid;
//                }
//                System.out.print(r + " ");
//            }
//        }

        DataInputStream inputStream = new DataInputStream(System.in);
        int a = inputStream.readInt();
        System.out.println(a);
    }
}
