package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
Даны два массива чисел длины n. Составьте из них один массив длины 2n,
в котором числа из входных массивов чередуются (первый — второй — первый — второй — ...).
При этом относительный порядок следования чисел из одного массива должен быть сохранён.

Формат ввода
В первой строке записано целое число n –— длина каждого из массивов, 1 ≤ n ≤ 1000.

Во второй строке записано n чисел из первого массива, через пробел.

В третьей строке –— n чисел из второго массива.

Значения всех чисел –— натуральные и не превосходят 1000.
 */
public class Practicum2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            int[] c = new int[length * 2];
            Integer[] a = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer[] b = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int j = 0;
            for (int i = 0; i < a.length; i++) {
                c[j++] = a[i];
                c[j++] = b[i];
            }
            Arrays.stream(c).forEach(d -> System.out.print(d + " "));
        }
    }
}
