package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*


Аня и Боря любят играть в разноцветные кубики, причем у каждого из них свой набор и в каждом наборе все кубики
различны по цвету. Однажды дети заинтересовались, сколько существуют цветов таких,
что кубики каждого цвета присутствуют в обоих наборах. Для этого они занумеровали все цвета случайными числами.
На этом их энтузиазм иссяк, поэтому вам предлагается помочь им в оставшейся части.
Номер любого цвета — это целое число в пределах от 0 до 109.

Формат ввода

В первой строке входного файла записаны числа N и M — количество кубиков у Ани и Бори соответственно.
В следующих N строках заданы номера цветов кубиков Ани. В последних M строках номера цветов кубиков Бори.
Формат вывода

Выведите сначала количество, а затем отсортированные по возрастанию номера цветов таких,
что кубики каждого цвета есть в обоих наборах, затем количество и отсортированные по возрастанию
номера остальных цветов у Ани, потом количество и отсортированные по возрастанию номера остальных цветов у Бори.
 */
public class Cube {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] cubes = reader.readLine().split(" ");
            int annCubes = Integer.parseInt(cubes[0]);
            int borisCubes = Integer.parseInt(cubes[1]);
            Set<Integer> annsCube = new TreeSet<>();
            Set<Integer> borisCube = new TreeSet<>();
            for (int i = 0; i < annCubes; i++) {
                annsCube.add(Integer.parseInt(reader.readLine()));
            }
            for (int i = 0; i < borisCubes; i++) {
                borisCube.add(Integer.parseInt(reader.readLine()));
            }

            Set<Integer> res = new TreeSet<>(annsCube);
            res.retainAll(borisCube);
            System.out.println(res.size());
            System.out.println(res.toString().replaceAll("[\\[\\],]", ""));
            annsCube.removeAll(res);
            System.out.println(annsCube.size());
            System.out.println(annsCube.toString().replaceAll("[\\[\\],]", ""));
            borisCube.removeAll(res);
            System.out.println(borisCube.size());
            System.out.println(borisCube.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
