package edu.java.tasks.conditions;


public class TimeService {

    // тут нужно проверить что время t1 в миллисекундах входит в отрезок [start; end)
    // то есть от start до end, включая start но не включая end
    // если отрезок не валидный (например что start больше end), то возвращаться false


    // t1 - 9
    // start - 10
    // end - 15
    // t1 - 14.9999999
    public boolean isInRange(int start, int t1, int end) {
        if (start >= end) {
            return false;
        }

        //        return start <= t1 && t1 < end;
        if (start > t1) {
            return false;
        }

        if (end <= t1) {
            return false;
        }

        return true;
    }
}

