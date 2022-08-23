package temp;


import java.util.*;

public class Tester {

    public static void main(String[] args) {

        List<Map<String, Object>> tempResultList = new ArrayList<Map<String,Object>>();

        Map<String, Object> tempMap01 = new HashMap<String, Object>();
        Map<String, Object> tempMap02 = new HashMap<String, Object>();


        tempMap01.put("PRJT_CODE", "P22038");
        tempMap01.put("PROGRS_STTUS_CD_NM", "제안단계");
        tempMap01.put("CTMNY_NM", "한국임업진흥원");
        tempMap01.put("BSNS_YEAR", "2022");
        tempMap01.put("EMP_NM", "김종범");
        tempMap01.put("costVal", "2022-12 / 잔금 (30) 94500000Y,2022-08 / 선금 (30) 94500000Y");
        tempMap01.put("costVal", "2022-12 / 잔금 (30) 94500000Y,2022-08 / 선금 (30) 94500000Y");
        tempMap01.put("EXPECT_PRJT_NM", "아무테스트");

        tempResultList.add(tempMap01);

        tempMap02.put("PRJT_CODE", "P220234123438");
        tempMap02.put("PROGRS_STTUS_CD_NM", "완료단계");
        tempMap02.put("CTMNY_NM", "미소정보기술");
        tempMap02.put("BSNS_YEAR", "2022");
        tempMap02.put("EMP_NM", "김민호");
        tempMap02.put("costVal", "2023-11 / 잔금 (30) 94500000Y,2022-11 / 선금 (30) 94500000Y,2022-9 / 잔금 (30) 94500000Y,2023-10 / 선금 (30) 94500000Y");
        tempMap02.put("EXPECT_PRJT_NM", "김민호의 작업일기");

        tempResultList.add(tempMap02);

        //[{PRJT_CODE=P22038, PROGRS_STTUS_CD_NM=제안단계, CTMNY_NM=한국임업진흥원, BSNS_YEAR=2022, EMP_NM=김종범, costVal=2022-12 | 잔금 (30) 94500000Y,2022-08 | 선금 (30) 94500000Y, EXPECT_PRJT_NM=아무테스트}, {PRJT_CODE=P220234123438, PROGRS_STTUS_CD_NM=완료단계, CTMNY_NM=미소정보기술, BSNS_YEAR=2022, EMP_NM=김민호, costVal=2023-11 | 잔금 (30) 94500000Y,2022-11 | 선금 (30) 94500000Y,2022-9 | 잔금 (30) 94500000Y,2023-10 | 선금 (30) 94500000Y, EXPECT_PRJT_NM=김민호의 작업일기}]
        System.out.println("tempResultList"+tempResultList);

        String section = "2022";
        String section3 = "2023";

        // 원본의 데이터를 파싱해서 저장할 List
        List<Map<String, String>> resultList = new ArrayList<>();

        for(int i = 0; i < tempResultList.size(); i++) {
            String sourceStr = (String) tempResultList.get(i).get("costVal");


            // sourceStr ->  "2022-12 | 잔금 (30) 94500000Y, 2022-08 | 선금 (30) 94500000Y"

            String[] tempStr = sourceStr.split(",");
            //"2022-12 | 잔금 (30) 94500000Y,
            // 2022-08 | 선금 (30) 94500000Y"

            for (int j = 0; j < tempStr.length; j++) {

                // List안에 들어갈 Map
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("id", String.valueOf(i));

                String str = tempStr[j];

                System.out.println(str);

                String[] targetStr = str.split(" / ");

                String yearMonth = targetStr[0];
                String targetValue = targetStr[1];

                System.out.println("yearMonth : " + yearMonth);
                System.out.println("targetValue : " + targetValue);


                String[] tempYearMonth = yearMonth.split("-");

                String year = tempYearMonth[0];
                String month = tempYearMonth[1];

                System.out.println("year : " + year);
                System.out.println("month : " + month);

                // 2002 = 2022
                if(section.equals(year)) {
                    // 1= one, 2= two
                    // month 12 -> twel = ""
                    if(month.equals("01")) {
                        resultMap.put("ONE", targetValue);
                    }else if(month.equals("02")) {
                        resultMap.put("TWO", targetValue);
                    }else if(month.equals("03")) {
                        resultMap.put("THREE", targetValue);
                    }else if(month.equals("04")) {
                        resultMap.put("FOUR", targetValue);
                    }else if(month.equals("05")) {
                        resultMap.put("FIVE", targetValue);
                    }else if(month.equals("06")) {
                        resultMap.put("SIX", targetValue);
                    }else if(month.equals("07")) {
                        resultMap.put("SEVEN", targetValue);
                    }else if(month.equals("08")) {
                        resultMap.put("EIGHT", targetValue);
                    }else if(month.equals("09")) {
                        resultMap.put("NINE", targetValue);
                    }else if(month.equals("10")) {
                        resultMap.put("TEN", targetValue);
                    }else if(month.equals("11")) {
                        resultMap.put("ELEVEN", targetValue);
                    }else if(month.equals("12")) {
                        resultMap.put("TWELVE", targetValue);
                    }

                }else if(section3.equals(year)) {
                    if(month.equals("01")) {
                        resultMap.put("ONE", targetValue);
                    }else if(month.equals("02")) {
                        resultMap.put("TWO", targetValue);
                    }else if(month.equals("03")) {
                        resultMap.put("THREE", targetValue);
                    }else if(month.equals("04")) {
                        resultMap.put("FOUR", targetValue);
                    }else if(month.equals("05")) {
                        resultMap.put("FIVE", targetValue);
                    }else if(month.equals("06")) {
                        resultMap.put("SIX", targetValue);
                    }else if(month.equals("07")) {
                        resultMap.put("SEVEN", targetValue);
                    }else if(month.equals("08")) {
                        resultMap.put("EIGHT", targetValue);
                    }else if(month.equals("09")) {
                        resultMap.put("NINE", targetValue);
                    }else if(month.equals("10")) {
                        resultMap.put("TEN", targetValue);
                    }else if(month.equals("11")) {
                        resultMap.put("ELEVEN", targetValue);
                    }else if(month.equals("12")) {
                        resultMap.put("TWELVE", targetValue);
                    }
                }
                resultList.add(resultMap);

                System.out.println("resultMap");
                System.out.println(resultMap);
            }

        }
        System.out.println("resultList");
        System.out.println(resultList);
        System.out.println("resultList.size() = " + resultList.size());
        System.out.println("tempResultList.size() = " + tempResultList.size());
        System.out.println("tempResultList = " + tempResultList);

        for (int i = 0; i <resultList.size(); i++) {
            Map<String, String> stringObjectMap = resultList.get(i);
            String id = stringObjectMap.get("id");
            Map<String, Object> stringObjectMap1 = tempResultList.get(Integer.parseInt(id));
            stringObjectMap.remove("id");
            stringObjectMap1.putAll(stringObjectMap);
        }
        for (Map<String, Object> temp : tempResultList) {
            temp.remove("costVal");
        }
        System.out.println("tempResultList = " + tempResultList);


    }



}


