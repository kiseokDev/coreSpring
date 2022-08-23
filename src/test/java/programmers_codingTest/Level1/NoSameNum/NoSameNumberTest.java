package programmers_codingTest.Level1.NoSameNum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class NoSameNumberTest {
    
    public int[] solution(int[] arr) {
        List<Integer> integers = new ArrayList<>();
        integers.add(arr[0]);
        Arrays.stream(arr).reduce((x, y) -> {
            if (x != y){
                integers.add(y);
            }
            return y;
        });

        int[] answer = integers.stream().mapToInt(Integer::intValue).toArray();
        return  answer;
    }

   @Test
    void Test() {
        int[] arr = {1, 12 , 3, 3, 0, 0, 1,1,0,0,3,2};
        LinkedListTest main = new LinkedListTest();
        int[] arr2 = main.solution(arr);
        System.out.println("arr2 = " + Arrays.toString(arr2));


    }
}
