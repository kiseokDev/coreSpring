package programmers_codingTest.Level1.personality;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution2 {
    public String solution(String[] survey, int[] choices) {
        List<Map<String, Integer>> scoreBoard = new ArrayList<>(survey.length);
//        IntStream.range(1,5).forEach(e->{
//            List objects = new ArrayList<>();
//            objects.add(new HashMap<>());
//            scoreBoard.add(objects);
//        });

        System.out.println("scoreBoard.size() = " + scoreBoard.size());


        for (int i = 0; i < survey.length; i++) {
            score(survey[i],scoreBoard,choices[i]);
        }
        return null;
    }
    @Test
    void Test(){
        Solution2 main = new Solution2();
        String[] survey = {"AN","CF","MJ","RT","NA"};
        int[] choices = {5,3,2,7,5};

        String solution = main.solution(survey, choices);
        System.out.println("solution = " + solution);
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


        if(character.contains("R")| character.contains("T")){
            if (character.startsWith("R")){
            }else if (character.startsWith("T")){
//                scoreBoard.put(0, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("T",map));
            }
        } else if (character.contains("C")| character.contains("F")) {
            if(character.startsWith("C")){
//                scoreBoard.put(1, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("C",map));
            }else {
//                scoreBoard.put(1, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("F",map));
            }
        } else if (character.contains("J")| character.contains("M")) {
            if(character.startsWith("J")){
//                scoreBoard.put(2, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("J",map));
            }else {
//                scoreBoard.put(2, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("M",map));
            }
        }else if (character.contains("A")| character.contains("N")){
            Map<String, Integer> tempMap = new HashMap<>();
            if(character.contains("A")){
//                scoreBoard.put(3, (Map<Integer, Map<String, Integer>>) new HashMap<>().put("A",map));
            }else{
//                scoreBoard.put(0,)
            }
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
