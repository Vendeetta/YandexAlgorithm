package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conditioner {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            int roomT = Integer.parseInt(input.split(" ")[0]);
            int condT = Integer.parseInt(input.split(" ")[1]);
            String mode = reader.readLine();
            switch (mode){
                case "auto":
                    System.out.println(condT);
                    break;
                case "heat":
                    if (condT < roomT)
                        System.out.println(roomT);
                    else
                        System.out.println(condT);
                    break;
                case "freeze":
                    if (condT > roomT)
                        System.out.println(roomT);
                    else
                        System.out.println(condT);
                    break;
                default:
                case "fan" :
                    System.out.println(roomT);
                    break;
            }
        }
    }
}
