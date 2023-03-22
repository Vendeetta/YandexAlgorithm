package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
Обратите внимание на ограничения в этой задаче.

Рита и Гоша играют в игру. У Риты есть n фишек, на каждой из которых написано количество очков.
Фишки лежат на столе в порядке неубывания очков на них. Сначала Гоша называет число k, затем
Рита должна выбрать две фишки, сумма очков на которых равна заданному числу.

Рите надоело искать фишки самой, и она решила применить свои навыки программирования для решения этой задачи.
Помогите ей написать программу для поиска нужных фишек.

Формат ввода
В первой строке записано количество фишек n, 2 ≤ n ≤ 105.

Во второй строке записано n целых чисел в порядке неубывания —– очки на фишках Риты в диапазоне от -105 до 105.

В третьей строке —– загаданное Гошей целое число k, -105 ≤ k ≤ 105.

Формат вывода
Нужно вывести два числа —– очки на двух фишках, в сумме дающие k.

Если таких пар несколько, то можно вывести любую из них.

Если таких пар не существует, то вывести «None».


 */
public class TwoChips2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            int[] chips = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            int sum = Integer.parseInt(reader.readLine());

            int[] res = setSolutions(chips, sum);
            if (res == null)
                System.out.println("None");
            else
                System.out.println(res[0] + " " + res[1]);
        }
    }

    private static int[] pointersSolutions(int[] chips, int sum) {
        if (chips.length < 2)
            return null;
        int[] res = new int[2];
        int left = 0;
        int right = chips.length - 1;
        while (left < right) {
            if (chips[left] + chips[right] == sum) {
                res[0] = chips[left];
                res[1] = chips[right];
                return res;
            } else if (chips[left] + chips[right] < sum) {
                left++;
            } else
                right--;
        }
        return null;
    }

    private static int[] setSolutions(int[] chips, int sum) {
        int[] res = new int[2];
        Set<Integer> tmp = Arrays.stream(chips).boxed().collect(Collectors.toSet());
        for (int i = 0; i < chips.length; i++) {
            int t = sum - chips[i];
            if (tmp.contains(t) && t != chips[i]) {
                res[0] = chips[i];
                res[1] = t;
                return res;
            }
        }
        return null;
    }
}
