package algorithm;

/*
В школе решили на один прямоугольный стол поставить два прямоугольных ноутбука. Ноутбуки нужно поставить так,
чтобы их стороны были параллельны сторонам стола. Определите, какие размеры должен иметь стол,
чтобы оба ноутбука на него поместились, и площадь стола была минимальна.

Формат ввода
Вводится четыре натуральных числа, первые два задают размеры одного ноутбука, а следующие два — размеры второго. Числа не превышают 1000.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NoteBook {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Map<Integer, List<Integer>> res = new HashMap<>();

            String[] notes = reader.readLine().split(" ");
            int lN1 = Integer.parseInt(notes[0]);
            int wN1 = Integer.parseInt(notes[1]);
            int lN2 = Integer.parseInt(notes[2]);
            int wN2 = Integer.parseInt(notes[3]);

            int sum1;
            int tmpL;
            int tmpW = wN1 + wN2;
            if (lN1 > lN2) {
                    tmpL = lN1;
                    sum1 = tmpL * tmpW;
                }
            else {
                tmpL = lN2;
                sum1 = tmpL * tmpW;
            }
            int minS = sum1;
            res.put(sum1, Arrays.asList(tmpL, tmpW));

            int sum2;
            tmpW = wN1 + lN2;
            if (lN1 > wN2) {
                tmpL = lN1;
                sum2 = tmpL * tmpW;
            }
            else {
                tmpL = wN2;
                sum2 = tmpL * tmpW;
            }
            if (sum2 < minS)
                minS = sum2;
            res.put(sum2, Arrays.asList(tmpL, tmpW));

            int sum3 = 0;
            tmpW = lN1 + wN2;
            if (wN1 > lN2) {
                tmpL = wN1;
                sum3 = tmpL * tmpW;
            }
            else {
                tmpL = lN2;
                sum3 = tmpL * tmpW;
            }
            if (sum3 < minS)
                minS = sum3;
            res.put(sum3, Arrays.asList(tmpL, tmpW));

            int sum4 = 0;
            tmpW = lN1 + lN2;
            if (wN1 > wN2) {
                tmpL = wN1;
                sum4 = tmpL * tmpW;
            }
            else {
                tmpL = wN2;
                sum4 = tmpL * tmpW;
            }
            if (sum4 < minS)
                minS = sum4;
            res.put(sum4, Arrays.asList(tmpL, tmpW));
            System.out.println(res.get(minS).get(0) + " " + res.get(minS).get(1));
        }
    }
}

