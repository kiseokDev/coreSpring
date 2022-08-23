package programmers_codingTest.Level1.report;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

class summitTest {

    public Map<String, Integer> reportedCount = new HashMap<>();
    public Map<String, ArrayList> reportedNames = new HashMap<>();
    Map<String, ArrayList> suspendedId;

    @Test
    void test() {
        Solution util = new Solution();
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] solution = util.solution(id_list, report, k);
//        Assertions.assertThat(solution).isNotEqualTo(new int[] {2,1,1,0});
    }
    //신고 당한 횟수 맵에 담기 로직.
    private void insertReportedCount(String x) {

        String[] s = x.split(" ");
        boolean countChk = reportedCount.containsKey(s[1]);
        boolean b = reportedNames.containsKey(s[0]);
        if (countChk) {
            //같은 사람을 신고한 적이 있는지 체크하는 로직
//            ArrayList arrayList = reportedNames.get(s[0]);
//            boolean contains = arrayList.contains(s[1]);
            ArrayList arrayList = reportedNames.get(s[0]);
            //신고한 적이 없다? 첫 신고자다 그럼 신고올려.
            if (arrayList == null) {
                Integer integer = reportedCount.get(s[1]);
                reportedCount.put(s[1],++integer);
            }else { // 아니다 신고한 이력이 있다. 그러면 같은 신고자가 있는지 체크
                boolean contains = arrayList.contains(s[1]);
                if (!contains){
                    Integer integer = reportedCount.get(s[1]);
                    reportedCount.put(s[1],++integer);
                }
            }
        } else {
            reportedCount.put(s[1],1);
        }

        //처음 아니면 신고 목록 이어서 저장
        if (b) {
            ArrayList valueArr = reportedNames.get(s[0]);
            if (!valueArr.contains(s[1])) {
                valueArr.add(s[1]);
            }
            //처음이면 키밸류 저장
        } else {
            reportedNames.put(s[0],new ArrayList<>(asList(s[1])));
        }


    }
    public int[] solution(String[] id_list, String[] reports, int k) {
        stream(reports).forEach(x->insertReportedCount(x));
        Map<String, ArrayList> suspendedId = getSuspendedId(k, id_list, reportedNames);
        return getResult(id_list, suspendedId);
    }
    //유저가 신고한 목록 맵으로 저장하는 로직
    // 정지된 id 구하는 로직
    private Map<String, ArrayList> getSuspendedId(int k, String[] id_list, Map<String,ArrayList> reportedNamesParam){
        suspendedId = new HashMap<>();
        //1.포문돌면서 유저가 키에 접근해서 유저가 신고한 아이디에 접근한다 (ArrayList);
        for (int i = 0; i < id_list.length ; i++) {
            String temp = id_list[i];
            ArrayList<String> arrayList = reportedNamesParam.get(temp);
            if (arrayList ==null) continue;
            //2. 1번의 ArrayList를 포문을 돌면서 한요소에 접근하여 reportedCount 키로 사용하여 value를 구한다 (int)
            for (String s :arrayList) {
                Integer count = reportedCount.get(s);
                //3. value가 k 보다 같거나 높을시 suspendId에 1 번의 유저를 키로 2번의 요소를 value로 추가한다.
                if (count != null && count >=k){
                    ArrayList arrayList1 = suspendedId.get(temp);
                    if (arrayList1 == null) { // 없으면 새로
                        suspendedId.put(temp, new ArrayList<>(asList(s)));
                    } else { //있으면 추가
                        arrayList1.add(s);
                    }
                }
            }

        }
        return suspendedId;
    }


    private int[] getResult(String[] id_list, Map<String,ArrayList> suspendedId){
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String temp = id_list[i];
            ArrayList arrayList = suspendedId.get(temp);
            if (arrayList != null && arrayList.size() >= 0 ) {
                result[i] = arrayList.size();
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

}
