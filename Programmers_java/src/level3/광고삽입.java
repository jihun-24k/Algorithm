package level3;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;

        int play = strToInt(play_time);
        int adv = strToInt(adv_time);
        int[] arr = new int[play + 1];

        for (String log : logs) {
            String[] se = log.split("-");
            int start = strToInt(se[0]);
            int end = strToInt(se[1]);

            for (int i = start; i < end; i++) {
                arr[i]++;
            }
        }

        long max = 0;
        for (int i = 1; i < adv; i++) {
            max += arr[i];
        }

        long now= max;
        for(int i=0, j=adv; j<play; i++, j++){
            now= now - arr[i] + arr[j];
            if(now>max){
                answer=i+1;
                max= now;
            }
        }

        return intToStr(answer);
    }


    public int strToInt(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 3600 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);
    }

    public String intToStr(int time){
        String hh, mm, ss;
        hh= (time/3600)>9? (time/3600)+"":"0"+time/3600;
        time%=3600;
        mm= (time/60)>9? (time/60)+"":"0"+time/60;
        time%=60;
        ss= time>9? time+"":"0"+time;

        return hh+":"+mm+":"+ss;
    }
}
