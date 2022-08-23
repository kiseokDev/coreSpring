package programmers_codingTest.Level1.report;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;
public class StreamSolution {
    @Test
    void test(){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        System.out.println("report = " + Arrays.toString(report));
        int[] solution = StreamSolution.solution(id_list, report, k);
        assertThat(solution).isEqualTo(new int[]{2, 1, 1, 0});
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            System.out.println("target = " + target);
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        System.out.println("count = " + count);

        return stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            System.out.println("reportList = " + reportList);
            long count1 = reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
            System.out.println("count1 = " + count1);
            return count1;
        }).mapToInt(x-> x.intValue()).toArray();
    }
}
