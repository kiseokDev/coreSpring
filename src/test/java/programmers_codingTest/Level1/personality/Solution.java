package programmers_codingTest.Level1.personality;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public String solution(String[] survey, int[] choices) {
        List<Map<String, Integer>> scoreBoard = new ArrayList<>(survey.length);
        initializeScoreBoard(scoreBoard);
        for (int i = 0; i < survey.length; i++) {
            score(survey[i],scoreBoard,choices[i]);
        }
        String answer = getAnswer(scoreBoard);
        return answer;
    }

    private String getAnswer(List<Map<String, Integer>> scoreBoard) {

        List<String> collect = scoreBoard.stream().map(e -> {
            Set<Map.Entry<String, Integer>> entries = e.entrySet();
            Optional<Map.Entry<String, Integer>> max = entries.stream().max(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) return 0;
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            Map.Entry<String, Integer> entry = max.get();
            String key = entry.getKey();
            return key;
        }).collect(Collectors.toList());
        String answer = collect.stream().reduce("", (x, y) -> x + y);
        return answer;
    }

    @Test
    void Test222(){
        Solution main = new Solution();
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7,1,3};

        String solution = main.solution(survey, choices);
        System.out.println("solution = " + solution);
    }
    private void initializeScoreBoard(List<Map<String, Integer>> scoreBoard) {
        IntStream.range(1,5).forEach(e->{
            Map objectObjectHashMap = new LinkedHashMap();
            if (e == 1){
                objectObjectHashMap.put("R", 0);
                objectObjectHashMap.put("T", 0);
                scoreBoard.add(objectObjectHashMap);
            } else if (e == 2) {
                objectObjectHashMap.put("C", 0);
                objectObjectHashMap.put("F", 0);
                scoreBoard.add(objectObjectHashMap);
            } else if (e == 3) {
                objectObjectHashMap.put("J", 0);
                objectObjectHashMap.put("M", 0);
                scoreBoard.add(objectObjectHashMap);
            }else {
                objectObjectHashMap.put("A", 0);
                objectObjectHashMap.put("N", 0);
                scoreBoard.add(objectObjectHashMap);
            }
        });
    }


    // 점수 구하는 로직
    void score(String s, List<Map<String, Integer>> scoreBoard, int i){
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Object> characterAndScore = getCharacterAndScore(s, i);
        Integer score = (Integer) characterAndScore.get("score");
        String character = String.valueOf((Character) characterAndScore.get("character"));
        scoreMap.put(character,scoreMap.getOrDefault(character, 0)+score);

        putMap(scoreBoard, scoreMap, character);
    }
    // 이전 점수에 더하는 로직
    private void putMap(List<Map<String, Integer>> scoreBoard, Map<String, Integer> scoreMap, String character) {
        Integer score = scoreMap.get(character);
        if(character.contains("R")| character.contains("T")){
            scoreBoard.get(0).put(character,scoreBoard.get(0).getOrDefault(character, 0)+score);
        } else if (character.contains("C")| character.contains("F")) {
            scoreBoard.get(1).put(character,scoreBoard.get(1).getOrDefault(character, 0)+score);
        } else if (character.contains("J")| character.contains("M")) {
            scoreBoard.get(2).put(character,scoreBoard.get(2).getOrDefault(character, 0)+score);
        }else if (character.contains("A")| character.contains("N")){
            scoreBoard.get(3).put(character,scoreBoard.get(3).getOrDefault(character, 0)+score);
        }
    }

    int getScore(int i) {
        if (i == 1 || i == 7){
            return 3;
        } else  if (i == 2 || i == 6){
            return 2;
        }else if (i ==3 || i == 5 ){
            return 1;
        }
        else return 0;
    }

    Map<String, Object> getCharacterAndScore(String s, int i) {
        Map<String, Object> map = new HashMap<>();
        if (i > 4) {
            map.put("character", s.charAt(1));
            map.put("score", getScore(i));
        } else if (i < 4){
            map.put("character", s.charAt(0));
            map.put("score", getScore(i));
        }else {
            map.put("character", s.charAt(0));
            map.put("score", 0);
        }
        return map;
    }
}
