package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

 */
public class TwoChips {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            int[] chips = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            int sum = Integer.parseInt(reader.readLine());

            int a;
            int b = 0;
            String res = "None";
            for (int i = 0; i < chips.length; i++) {
                a = chips[i];
                for (int j = i + 1; j < chips.length; j++) {
                    b = chips[j];
                    if ((a + b) == sum) {
                        res = a + " " + b;
                        break;
                    }
                }
                if ((a + b) == sum)
                    break;
            }
            System.out.println(res);
        }
    }
}
