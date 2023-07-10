import java.util.Calendar;

import static java.lang.System.out;

public class EnumWeekTest01 {
    public static void main(String[] args) {
        Week today = null;

        Calendar c = Calendar.getInstance();

        int week = c.get(Calendar.DAY_OF_WEEK); //일요일1~토요일7로 반환

        switch(week){
            case 1: today = Week.SUNDAY; break;
            case 2: today = Week.MONDAY; break;
            case 3: today = Week.TUESDAY; break;
            case 4: today = Week.WEDNESDAY; break;
            case 5: today = Week.THURSDAY; break;
            case 6: today = Week.FRIDAY; break;
            case 7: today = Week.SATURDAY; break;
            default: System.exit(1);
        }

        out.println("TODAY: " + today);
    }
}
