package algorithm;

import org.w3c.dom.ls.LSOutput;

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

    static int maxInterval = 1_000_000;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");

            int flatWeNeed = Integer.parseInt(input[0]);
            int totalFloors = Integer.parseInt(input[1]);
            int flatWeHaveBeenPrevious = Integer.parseInt(input[2]);
            int entranceWeHaveBeenPrevious = Integer.parseInt(input[3]);
            int floorWeHaveBeenPrevious = Integer.parseInt(input[4]);
//            fast(flatWeNeed, totalFloors, flatWeHaveBeenPrevious, entranceWeHaveBeenPrevious, floorWeHaveBeenPrevious);
            slow(flatWeNeed, totalFloors, flatWeHaveBeenPrevious, entranceWeHaveBeenPrevious, floorWeHaveBeenPrevious);
        }
    }

    private static void slow(int flatWeNeed, int totalFloors, int flatWeHaveBeenPrevious, int entranceWeHaveBeenPrevious, int floorWeHaveBeenPrevious) {
        int flatsOnFloor = 1;
        int flatsOnFloorWeSearch = -1;
        while (flatsOnFloor < maxInterval + 1) {
            for (int i = 1; i < totalFloors + 1; i ++) {
                int minFlatOnFloor = i * flatsOnFloor - (flatsOnFloor - 1);
                int maxFlatOnFloor = i * flatsOnFloor;
                if (i == floorWeHaveBeenPrevious && flatWeHaveBeenPrevious >= minFlatOnFloor && flatWeHaveBeenPrevious <= maxFlatOnFloor) {
                    flatsOnFloorWeSearch = flatsOnFloor;
                    System.out.println(i);
                    System.out.println(minFlatOnFloor);
                    System.out.println(maxFlatOnFloor);
                    break;
                }
            }
            for (int i = 1; i < totalFloors + 1; i ++) {
                int minFlatOnFloor = i * flatsOnFloorWeSearch - (flatsOnFloorWeSearch - 1);
                int maxFlatOnFloor = i * flatsOnFloorWeSearch;
                if (flatWeNeed >= minFlatOnFloor && flatWeNeed <= maxFlatOnFloor) {
                    System.out.println("floor we need = " + (i));
                    System.out.println(minFlatOnFloor);
                    System.out.println(maxFlatOnFloor);
                    break;
                }
            }
            flatsOnFloor++;
        }
    }


    private static void fast(int flatWeNeed, int totalFloors, int flatWeHaveBeenPrevious, int entranceWeHaveBeenPrevious, int floorWeHaveBeenPrevious) {
        if (flatWeNeed > 0 && totalFloors > 0 && flatWeHaveBeenPrevious > 0 && entranceWeHaveBeenPrevious > 0 && floorWeHaveBeenPrevious > 0) {
            int flatsAtFloor = (int) Math.ceil((double) flatWeHaveBeenPrevious / (double) floorWeHaveBeenPrevious);
            int flatsInEntrance = totalFloors * flatsAtFloor;
            int currentEntrance = floorWeHaveBeenPrevious == 1 ? 0 : (int) Math.ceil((double) flatWeNeed / (double) flatsInEntrance);
            int currentFloor = totalFloors == 1 ? 1 : (int) Math.ceil((double) (flatWeNeed - (flatsInEntrance * (flatWeNeed / flatsInEntrance))) / (double) flatsAtFloor);
            if (flatWeHaveBeenPrevious <= (entranceWeHaveBeenPrevious - 1) * totalFloors)
                System.out.println(-1 + " " + -1);
            else if (flatWeNeed == 1)
                System.out.println(1 + " " + 1);
            else
                System.out.println(currentEntrance + " " + currentFloor);
        } else {
            System.out.println(-1 + " " + -1);
        }
    }
}
