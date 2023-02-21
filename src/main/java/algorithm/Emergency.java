package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Бригада скорой помощи выехала по вызову в один из отделенных районов. К сожалению, когда диспетчер получил вызов,
он успел записать только адрес дома и номер квартиры K1, а затем связь прервалась. Однако он вспомнил,
что по этому же адресу дома некоторое время назад скорая помощь выезжала в квартиру K2, которая расположена в подъезда P2
 на этаже N2. Известно, что в доме M этажей и количество квартир на каждой лестничной площадке одинаково.
 Напишите программу, которая вычилсяет номер подъезда P1 и номер этажа N1 квартиры K1.
 */
public class Emergency {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");

            int currentFlat = Integer.parseInt(input[0]);
            int floorsCount = Integer.parseInt(input[1]);
            int previousFlat = Integer.parseInt(input[2]);
            int previousEntrance = Integer.parseInt(input[3]);
            int previousFloor = Integer.parseInt(input[4]);
            if (currentFlat > 0 && floorsCount > 0 && previousFlat > 0 && previousEntrance > 0 && previousFloor > 0) {
                int flatsAtFloor = (int) Math.ceil((double) previousFlat / (double) previousFloor);
                int flatsInEntrance = floorsCount * flatsAtFloor;
                int currentEntrance = previousFloor == 1 ? 0 : (int) Math.ceil((double) currentFlat / (double) flatsInEntrance);
                int currentFloor = floorsCount == 1 ? 1 : (int) Math.ceil((double) (currentFlat - (flatsInEntrance * (currentFlat / flatsInEntrance))) / (double) flatsAtFloor);
                if (previousFlat <= (previousEntrance - 1) * floorsCount)
                    System.out.println(-1 + " " + -1);
                else if (currentFlat == 1)
                    System.out.println(1 + " " + 1);
                else
                    System.out.println(currentEntrance + " " + currentFloor);
            } else {
                System.out.println(-1 + " " + -1);
            }
        }
    }
}
