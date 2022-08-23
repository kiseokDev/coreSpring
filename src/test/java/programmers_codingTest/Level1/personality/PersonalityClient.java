package programmers_codingTest.Level1.personality;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonalityClient {
    @Test
    void Test(){
        Solution main = new Solution();
        String[] survey = {"AN","CF","MJ","RT","NA"};
        int[] choices = {5,3,2,7,5};

        String solution = main.solution(survey, choices);
        System.out.println("solution = " + solution);
    }
    @Test
    void test2(){
        String test ="09";
        int i = (Integer.parseInt(test)) - 10;
        if(i <= 0){
           test =  test.substring(1);
        }
        Assertions.assertThat(test).isEqualTo("9");

    }

}
