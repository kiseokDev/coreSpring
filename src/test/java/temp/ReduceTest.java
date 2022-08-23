package temp;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = integerStream.reduce((x, y) -> {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            return x + y;
        });

        System.out.println("reduce = " + reduce);

    }
}
