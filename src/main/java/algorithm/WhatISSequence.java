package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
По последовательности чисел во входных данных определите ее вид:

CONSTANT – последовательность состоит из одинаковых значений
ASCENDING – последовательность является строго возрастающей
WEAKLY ASCENDING – последовательность является нестрого возрастающей
DESCENDING – последовательность является строго убывающей
WEAKLY DESCENDING – последовательность является нестрого убывающей
RANDOM – последовательность не принадлежит ни к одному из вышеупомянутых типов

ВВОД
По одному на строке поступают числа последовательности ai, |ai| ≤ 109.

Признаком окончания последовательности является число -2 × 109. Оно в последовательность не входит.
 */

public class WhatISSequence {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isWeakly = false;
            boolean isAscending = true;
            boolean isDescending = true;
            boolean isConstant = true;
            List<Integer> list = new ArrayList<>();
            int tmp;
            while ((tmp = Integer.parseInt(reader.readLine())) != -2_000_000_000) {
                list.add(tmp);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                if (!Objects.equals(list.get(i), list.get(i + 1))) {
                    isConstant = false;
                } else {
                    isWeakly = true;
                }

                if (list.get(i) < list.get(i + 1)) {
                    isDescending = false;
                }
                if (list.get(i) > list.get(i + 1)) {
                    isAscending = false;
                }
            }
            if (isConstant)
                System.out.println("CONSTANT");
            else if (isWeakly && isAscending)
                System.out.println("WEAKLY ASCENDING");
            else if (isAscending)
                System.out.println("ASCENDING");
            else if (isWeakly && isDescending)
                System.out.println("WEAKLY DESCENDING");
            else if (isDescending)
                System.out.println("DESCENDING");
            else
                System.out.println("RANDOM");
        }
    }
}