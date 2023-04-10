package algorithm;

/*


Последовательность чисел назовем симметричной, если она одинаково читается как слева направо, так и справа налево.
Например, следующие последовательности являются симметричными:

1 2 3 4 5 4 3 2 1

1 2 1 2 2 1 2 1

Вашей программе будет дана последовательность чисел. Требуется определить, какое минимальное количество и
каких чисел надо приписать в конец этой последовательности, чтобы она стала симметричной.

Формат ввода

Сначала вводится число N — количество элементов исходной последовательности (1 ≤ N ≤ 100).
Далее идут N чисел — элементы этой последовательности, натуральные числа от 1 до 9.

Формат вывода

Выведите сначала число M — минимальное количество элементов, которое надо дописать к последовательности,
а потом M чисел (каждое — от 1 до 9) — числа, которые надо дописать к последовательности.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SymmetricalSequence {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] array = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();

            boolean isSymmetrical = true;
            int i = 0;
            int j = array.length - 1;
            while (i < j) {
                if (array[i] != array[j]) {
                    isSymmetrical = false;
                    break;
                }
                i++;
                j--;
            }
            if (isSymmetrical) {
                System.out.println(0);
            } else {
                int x;
                if (array[array.length - 1] == array[array.length - 2])
                    x = array.length - 3;
                else
                    x = array.length - 2;
                System.out.println(x + 1);
                while (x >= 0) {
                    System.out.print(array[x] + " ");
                    x--;
                }
            }
        }
    }
}
