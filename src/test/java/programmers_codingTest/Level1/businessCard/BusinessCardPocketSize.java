package programmers_codingTest.Level1.businessCard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class BusinessCardPocketSize {
    public int solution(int[][] sizes) {
        int[][] ints = Arrays.stream(sizes).map(e -> {
            Integer[] integers = Arrays.stream(e).boxed().toArray(Integer[]::new);
            Arrays.sort(integers, Collections.reverseOrder());
            int[] tmp = Arrays.stream(integers).mapToInt(value -> value).toArray();
            System.out.println("Arrays.toString(tmp) = " + Arrays.toString(tmp));
            return tmp;
        }).toArray(int[][]::new);

        int[] ints1 = Arrays.stream(ints).reduce((x, y) -> {
            int x1 = x[0];
            int y1 = y[0];
            return x1 > y1 ? x : y;
        }).get();

        int[] ints2 = Arrays.stream(ints).reduce((x, y) -> {
            int x1 = x[1];
            int y1 = y[1];
            return x1 > y1 ? x : y;
        }).get();

        int answer = ints1[0] * ints2[1];
        return answer;
    }

    public static void main(String[] args) {
        BusinessCardPocketSize businessCardPocketSize = new BusinessCardPocketSize();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30} ,{80, 40}};  //4000 리턴 80 * 50
//       int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; //120 리턴 8 * 15 3번째 명함
//        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}; //133 리턴 그냥 적절히 회 19 * 7
        int answer = businessCardPocketSize.solution(sizes);
        System.out.println("answer = " + answer);
    }
}
