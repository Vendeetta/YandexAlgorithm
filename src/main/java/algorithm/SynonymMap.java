package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*


Вам дан словарь, состоящий из пар слов. Каждое слово является синонимом к парному ему слову.
Все слова в словаре различны. Для одного данного слова определите его синоним.
Формат ввода

Программа получает на вход количество пар синонимов N. Далее следует N строк,
каждая строка содержит ровно два слова-синонима. После этого следует одно слово.
Формат вывода

Программа должна вывести синоним к данному слову. Примечание

Эту задачу можно решить и без словарей (сохранив все входные данные в списке),
но решение со словарем будет более простым.
 */
public class SynonymMap {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine());
            Map<String, String> synonyms = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String[] tmp = reader.readLine().split(" ");
                synonyms.put(tmp[0], tmp[1]);
                synonyms.put(tmp[1], tmp[0]);
            }
            String findSynonym = synonyms.get(reader.readLine());
            System.out.println(findSynonym);
        }
    }
}
