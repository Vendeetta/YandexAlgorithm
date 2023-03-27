package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Metro {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int a = readData();
        int b = readData();
        int n = readData();
        int m = readData();
        int minTimeOneWay = (n + ((n-1) * a));
        int maxTimeOneWay = minTimeOneWay + 2*a;
        int minTimeSecondWay = (m + ((m-1) * b));
        int maxTimeSecondWay = minTimeSecondWay + 2 * b;
        int minTime = Math.max(minTimeOneWay, minTimeSecondWay );
        int maxTime = Math.min(maxTimeSecondWay, maxTimeOneWay);
        if (maxTime < minTimeOneWay || maxTime < minTimeSecondWay)
            System.out.println(-1);
        else
            System.out.println(minTime + " " + maxTime);
        reader.close();

    }

    private static int readData() throws IOException {
           return Integer.parseInt(reader.readLine());
        }
    //test
}
