package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
Фермер Николай нанял двух лесорубов: Дмитрия и Федора, чтобы вырубить лес, на месте которого должно быть кукурузное поле.
В лесу растут X деревьев.

Дмитрий срубает по A деревьев в день, но каждый K-й день он отдыхает и не срубает ни одного дерева.
Таким образом, Дмитрий отдыхает в K-й, 2K-й, 3K-й день, и т.д.

Федор срубает по B деревьев в день, но каждый M-й день он отдыхает и не срубает ни одного дерева.
Таким образом, Федор отдыхает в M-й, 2M-й, 3M-й день, и т.д.

Лесорубы работают параллельно и, таким образом, в дни, когда никто из них не отдыхает,
они срубают A + B деревьев, в дни, когда отдыхает только Федор — A деревьев, а в дни, когда отдыхает только Дмитрий — B деревьев.
В дни, когда оба лесоруба отдыхают, ни одно дерево не срубается.

Фермер Николай хочет понять, за сколько дней лесорубы срубят все деревья, и он сможет засеять кукурузное поле.

Требуется написать программу, которая по заданным целым числам A, K, B, M и X определяет,
за сколько дней все деревья в лесу будут вырублены.

Input
Входной файл содержит пять целых чисел, разделенных пробелами: A, K, B, M и X (1 ≤ A, B ≤ 109, 2 ≤ K, M ≤ 1018, 1 ≤ X ≤ 1018).

Output
Выходной файл должен содержать одно целое число — искомое количество дней.
 */
public class TaskF {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] data = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .toArray();
            int firstWorkerDo = data[0];
            int firstWorkerRest = data[1];
            int secondWorkerDo = data[2];
            int secondWorkerRest = data[3];
            int totalWoods = data[4];
            int l = -1;
            int r  = totalWoods / firstWorkerDo + 1;
            while (r - l > 1) {
                int curDay = (l + r) / 2;
               int totalWood = (curDay * firstWorkerDo) + (curDay * secondWorkerDo) - (curDay/firstWorkerRest * firstWorkerDo) - (curDay/secondWorkerRest * secondWorkerDo);
               if (totalWood < totalWoods)
                   l = curDay;
               else
                   r = curDay;
            }
            System.out.println(r);
        }
    }
}
