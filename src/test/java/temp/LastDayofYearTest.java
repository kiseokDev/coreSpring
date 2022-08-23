package temp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LastDayofYearTest {
    @Test
    @DisplayName("마지막날짜 구하기")
    void 마지막날짜(){
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        calendar.set(Calendar.MONTH,12);
        int i = calendar.get(Calendar.MONTH);
        System.out.println("i = " + i);

//        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        Date time = calendar.getTime();

//        System.out.println("time = " + time);
//        System.out.println("actualMaximum = " + actualMaximum);
    }
    private String toString(Calendar calendar, String pattern, TimeZone zone) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(zone);
        return format.format(calendar.getTime());
    }



}
