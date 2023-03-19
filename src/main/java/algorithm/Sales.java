package algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
Дана база данных о продажах некоторого интернет-магазина. Каждая строка входного файла представляет собой запись
вида Покупатель товар количество, где Покупатель — имя покупателя (строка без пробелов),
товар — название товара (строка без пробелов), количество — количество приобретенных единиц товара.
Создайте список всех покупателей, а для каждого покупателя подсчитайте количество приобретенных им единиц
каждого вида товаров.

Формат ввода

Вводятся сведения о покупках в указанном формате.
Формат вывода

Выведите список всех покупателей в лексикографическом порядке, после имени каждого покупателя выведите двоеточие,
затем выведите список названий всех приобретенных данным покупателем товаров в лексикографическом порядке,
после названия каждого товара выведите количество единиц товара, приобретенных данным покупателем.
Информация о каждом товаре выводится в отдельной строке.
 */
public class Sales {
    public static void main(String[] args) throws IOException {

        Map<String, Map<String, Integer>> customers = parseFile(Path.of("/home/spaikk/Рабочий стол/Java/test.txt"));
        display(customers);

    }

    private static void display(Map<String, Map<String, Integer>> customers) {
        for (Map.Entry<String, Map<String, Integer>> entry : customers.entrySet()) {
            System.out.println(entry.getKey()+":");
            for (Map.Entry<String, Integer> ee : entry.getValue().entrySet()) {
                System.out.println(ee.getKey() + " " + ee.getValue());
            }
        }
    }

    private static Map<String, Map<String, Integer>> parseFile(Path path) throws IOException {
        List<String> strings = Files.readAllLines(path);
        Map<String, Map<String, Integer>> customersWithPurchase = new TreeMap<>();
        for (String s : strings) {
            String[] tmp = s.split(" ");
            String key = tmp[0];
            String goodKey = tmp[1];
            int count = Integer.parseInt(tmp[2]);
            if (!customersWithPurchase.containsKey(key))
                customersWithPurchase.put(key, new TreeMap<>());

            Map<String, Integer> tmpMap = customersWithPurchase.get(key);
            if (!tmpMap.containsKey(goodKey))
                tmpMap.put(goodKey, count);
            else
                tmpMap.merge(goodKey, count, Integer::sum);

        }
        return customersWithPurchase;
    }
}