package programmers_codingTest.Level1.report;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PeekTest {
    @Test
    void test() {
//        List<String> l = Arrays.asList("A", "B", "C", "D");
//        long test = l.stream().peek(e-> System.out.println("element = "+e)).count();
//        System.out.println("test = " + test);

        int[] intArr = {1, 2, 3, 4, 5};
        String[] stringArr = {"A", "B", "C", "D"};


        // 최종처리 메소드가 없으면 동작하지 않음.
//        Arrays.stream(intArr)
//                .filter(a -> a%2 == 0)
//                .peek(System.out::println); // peek은 중간 처리 메소드(intermediate)

        // 최종처리 메소드(Terminal) sum()이 존재하므로 정상 작동한다.
        int sum = Arrays.stream(intArr)
                .peek(System.out::println)
                .sum();
        System.out.println("sum = " + sum);

        long count = Arrays.stream(stringArr)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);
    }

}
