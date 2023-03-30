package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskE {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = reader.readLine().split(" ");
            int totalRopes = Integer.parseInt(tmp[0]);
            long totalHouses = Long.parseLong(tmp[1]);
            long[] ropes = new long[totalRopes];

            for (int i = 0; i < ropes.length; i++) {
                ropes[i] = Integer.parseInt(reader.readLine());
            }
            long l = 0;
            long r = Arrays.stream(ropes).sum();
            while (r - l > 1) {
                long x = (l + r) / 2;
                long countRopes = 0;
                if (x > 0) {
                    countRopes = Arrays.stream(ropes).map(y -> y / x).sum();
                }
                if (countRopes < totalHouses) {
                    r = x;
                } else {
                    l = x;
                }
            }
            long tmpp = r;
            if (Arrays.stream(ropes).map(y -> y / tmpp).sum() >= totalHouses)
                System.out.println(r);
            else
                System.out.println(l);
        }
    }
}
