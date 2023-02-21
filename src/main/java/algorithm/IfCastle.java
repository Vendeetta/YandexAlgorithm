package algorithm;

/*
За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E.
Замок Иф сложен из кирпичей, размером A × B × C. Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие,
 если стороны кирпича должны быть параллельны сторонам отверстия.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IfCastle {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] abc = {
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
            };
            Arrays.sort(abc);
            int a = abc[0];
            int b = abc[1];
            String dd = reader.readLine();
            String ee = reader.readLine();
            int d = Math.min(Integer.parseInt(dd), Integer.parseInt(ee));
            int e = Math.max(Integer.parseInt(dd), Integer.parseInt(ee));
            if (a > d || b > e)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
