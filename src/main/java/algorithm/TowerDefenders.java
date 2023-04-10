package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TowerDefenders {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            long[] totalTowers = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long[] totalDefenders = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long maxTowerWidth = 0;
            int totalDefendersCanApply = 0;
            List<Long> illuminatedSqr = new ArrayList<>();
            for (int i = totalTowers.length - 1; i >= 0; i--) {
                long tmp = totalTowers[i];
                if (tmp > maxTowerWidth) {
                    illuminatedSqr.add(tmp - maxTowerWidth);
                    maxTowerWidth = tmp;
                }
            }
            illuminatedSqr.sort(Comparator.naturalOrder());
            Arrays.sort(totalDefenders);
            int j = 0;
            for (int i = 0; i < totalDefenders.length; i++) {
                for (; j < illuminatedSqr.size(); j++) {
                    if (illuminatedSqr.get(j) - totalDefenders[i] >= 0) {
                        totalDefendersCanApply++;
                        j++;
                        break;
                    }
                }
            }
            System.out.println(totalDefendersCanApply);
        }
    }
}