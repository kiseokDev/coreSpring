package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class Temp {
    public static void main(String[] args) {
        int[] test = {1, 1, 3, 3, 0, 1, 1};
        int[] ints = stream(test).distinct().toArray();
        System.out.println("ints = " + ints);
//        stream(test).distinct().collect(Collectors.toList());
//        Arrays.stream(test).distinct().collect(Collectors.toList());

    }
}
