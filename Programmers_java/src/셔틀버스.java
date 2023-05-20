import java.util.Arrays;
import java.util.Stack;

public class 셔틀버스 {

    static int hour = 9;
    static int minute = 0;

    public String solution(int n, int t, int m, String[] timetable) {
        Stack<String> bus = new Stack<>();

        Arrays.sort(timetable);
        int takedBus = 0;

        for (int i = 1; i <= n; i++) {

            bus = new Stack<>();
            while (bus.size() < m && takedBus < timetable.length) {

                String[] time = timetable[takedBus].split(":");
                int h = Integer.parseInt(time[0]);
                int mi = Integer.parseInt(time[1]);
                int timeDiff = (hour - h) * 60 + (minute - mi);

                if (timeDiff < 0) {
                    break;
                }

                bus.add(timetable[takedBus]);
                takedBus++;
            }

            if (i == n) {
                continue;
            }

            hour += (minute + t) / 60;
            minute = (minute + t) % 60;
        }

        if (bus.size() < m) {
            return convert(hour) + ":" + convert(minute);
        }

        String[] lastTimes = bus.pop().split(":");
        int lastHour = Integer.parseInt(lastTimes[0]);
        int lastMinute = Integer.parseInt(lastTimes[1]);

        lastMinute--;

        if (lastMinute == -1) {
            lastHour--;
            lastMinute = 59;
        }

        return convert(lastHour) + ":" + convert(lastMinute);
    }

    private String convert(int time) {
        if (time < 10) {
            return "0" + time;
        }
        return String.valueOf(time);
    }
}
