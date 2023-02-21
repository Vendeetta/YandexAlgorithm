package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] numbers = new String[3];
            String newNumber = reader.readLine();
            newNumber = newNumber.replaceAll("\\W", "");
            newNumber = newNumber.length() == 7 ? "495" + newNumber : newNumber.substring(1);
            numbers[0] = reader.readLine();
            numbers[1] = reader.readLine();
            numbers[2] = reader.readLine();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("\\W", "");
                numbers[i] = numbers[i].length() == 7 ? "495" + numbers[i] : numbers[i].substring(1);
                if (numbers[i].equals(newNumber))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
