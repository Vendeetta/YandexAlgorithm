package algorithm.algorythmMArathon;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class TaskThree {

    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader= new BufferedReader(new FileReader("/home/spaikk/Загрузки/Telegram Desktop/input1.txt"))) {
//            long totalDetails = Long.parseLong(reader.readLine().split(" ")[1]);
//            StringBuilder builder = new StringBuilder();
//            while (reader.ready()) {
//                builder.append(reader.readLine());
//            }
//            long[] eachMachineNeededTimePerDetail = Arrays.stream(builder.toString().split("\\D"))
//                    .map(Long::parseLong)
//                    .mapToLong(x -> x)
//                    .toArray();
//            long l = -1;
//            long r = totalDetails * eachMachineNeededTimePerDetail[0];
//            while (r - l > 1) {
//                long time = l + (r - l) / 2;
//                long count = 0;
//                for (long value : eachMachineNeededTimePerDetail) {
//                    count += time / value;
//                    if (count > totalDetails)
//                        break;
//                }
//                if (count < totalDetails) {
//                    l = time;
//                } else {
//                    r = time;
//                }
//            }
//            System.out.print(r);
//        }
//    }
//}
try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long totalDetails = Long.parseLong(reader.readLine().split(" ")[1]);
            long[] eachMachineNeededTimePerDetail = Arrays.stream(reader.readLine().split("\\D"))
                    .map(Long::parseLong)
                    .mapToLong(x -> x)
                    .toArray();
            long l = -1;
            long r = totalDetails * eachMachineNeededTimePerDetail[0];
            while (r - l > 1) {
                long time = l + (r - l) / 2;
                long count = 0;
                for (long value : eachMachineNeededTimePerDetail) {
                    count += time / value;
                    if (count > totalDetails)
                        break;
                }
                if (count < totalDetails) {
                    l = time;
                } else {
                    r = time;
                }
            }
            System.out.print(r);
        }
    }
}
