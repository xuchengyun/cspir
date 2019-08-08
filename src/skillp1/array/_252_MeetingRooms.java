package skillp1.array;

import java.util.Arrays;

public class _252_MeetingRooms {

    public boolean canAttendMeeting(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
