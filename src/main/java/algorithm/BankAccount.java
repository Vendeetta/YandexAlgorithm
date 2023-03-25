package algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*


Некоторый банк хочет внедрить систему управления счетами клиентов, поддерживающую следующие операции:

Пополнение счета клиента. Снятие денег со счета. Запрос остатка средств на счете. Перевод денег между счетами клиентов.
Начисление процентов всем клиентам.

Вам необходимо реализовать такую систему. Клиенты банка идентифицируются именами (уникальная строка, не содержащая пробелов).
Первоначально у банка нет ни одного клиента. Как только для клиента проводится операция пололнения,
снятия или перевода денег, ему заводится счет с нулевым балансом. Все дальнейшие операции проводятся только с этим счетом.
Сумма на счету может быть как положительной, так и отрицательной, при этом всегда является целым числом.
Формат ввода

Входной файл содержит последовательность операций. Возможны следующие операции:
DEPOSIT name sum - зачислить сумму sum на счет клиента name. Если у клиента нет счета, то счет создается.
WITHDRAW name sum - снять сумму sum со счета клиента name. Если у клиента нет счета, то счет создается.
BALANCE name - узнать остаток средств на счету клиента name.
TRANSFER name1 name2 sum - перевести сумму sum со счета клиента name1 на счет клиента name2.
Если у какого-либо клиента нет счета, то ему создается счет.
INCOME p - начислить всем клиентам, у которых открыты счета, p% от суммы счета.
Проценты начисляются только клиентам с положительным остатком на счету, если у клиента остаток отрицательный,
то его счет не меняется. После начисления процентов сумма на счету остается целой,
то есть начисляется только целое число денежных единиц. Дробная часть начисленных процентов отбрасывается.
Формат вывода

Для каждого запроса BALANCE программа должна вывести остаток на счету данного клиента.
Если же у клиента с запрашиваемым именем не открыт счет в банке, выведите ERROR.
DEPOSIT Ivanov 100
INCOME 5
BALANCE Ivanov
TRANSFER Ivanov Petrov 50
WITHDRAW Petrov 100
BALANCE Petrov
BALANCE Sidorov
 */
public class BankAccount {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("/home/spaikk/Рабочий стол/Java/test.txt"));
        Map<String, Integer> result = new TreeMap<>();
        strings.forEach(str -> {
            String[] strs = str.split(" ");
            if (strs[0].equalsIgnoreCase("deposit")) {
                result.putIfAbsent(strs[1], 0);
                result.computeIfPresent(strs[1], (a, b) -> b + Integer.parseInt(strs[2]));
            } else if (strs[0].equalsIgnoreCase("WITHDRAW")) {
                result.putIfAbsent(strs[1], 0);
                result.computeIfPresent(strs[1], (a, b) -> b - Integer.parseInt(strs[2]));
            } else if (strs[0].equalsIgnoreCase("BALANCE")) {
                if (result.containsKey(strs[1]))
                    System.out.println(result.get(strs[1]));
                else
                    System.out.println("ERROR");
            } else if (strs[0].equalsIgnoreCase("TRANSFER")) {
                result.putIfAbsent(strs[1], 0);
                result.putIfAbsent(strs[2], 0);
                result.computeIfPresent(strs[1], (a, b) -> b - Integer.parseInt(strs[3]));
                result.computeIfPresent(strs[2], (a, b) -> b + Integer.parseInt(strs[3]));
            } else if (strs[0].equalsIgnoreCase("INCOME")) {
                result.forEach((a, b) -> {
                    if (b > 0) {
                        double percent = Double.parseDouble(strs[1]) / 100;
                        double newB = b * percent;
                        b += (int) newB;
                        result.put(a, b);
                    }
                });
            }
        });
    }
}
