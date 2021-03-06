// Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
//
//Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
//
//A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
//
//For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
//
//Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

import java.util.ArrayList;
import java.util.List;

// Sol 1: ArrayList
// When there is a new event, iterate the arraylist and see if there is an interval has conflict with new interval:
// event[0] < end && event[1] > start
// Insert new event at the end if no conflict
// Time: O(n), Space: O(n)
class MyCalendar {
    List<int []> list;
    public MyCalendar() {
        this.list = new ArrayList();
    }

    public boolean book(int start, int end) {
        for(int [] event : list) {
            if(event[0] < end && event[1] > start) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
