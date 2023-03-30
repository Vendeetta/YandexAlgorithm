package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TaskF {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countArrays = Integer.parseInt(reader.readLine().split(" ")[1]);
            int[] numbers = Arrays.stream(reader.readLine().split("\\D"))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            int l = 0;
//            long r = Arrays.stream(numbers).sum();
            int r = Integer.MAX_VALUE;
            while (r - l > 1) {
                int x = (l + r) / 2;
                int tmpValue = 0;
                int tCount = 0;
                int i = 0;
                for (; i < numbers.length; i++) {
                    if ((tmpValue += numbers[i]) > x) {
                        tCount++;
                        tmpValue = 0;
                        i--;
                    }
                    if (tCount == countArrays) {
                        break;
                    }
                }
                if (i < numbers.length - 1)
                    l = x;
                else
                    r = x;
            }
            System.out.println(r);
        }
    }
}
