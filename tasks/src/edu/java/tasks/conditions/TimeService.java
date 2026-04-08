package edu.java.tasks.conditions;


public class TimeService {

    // тут нужно проверить что время now в миллисекундах входит в отрезок [start; end)
    // то есть от start до end, включая start но не включая end
    // если отрезок не валидный (например что start больше end), то возвращаться false


    public boolean isInRange(int start,int now,int end) {
        if (start > end) {
            return false;
        } else if (start == end) {
            return false;
        } else if (start < now) {
            return false;
        }else return true;
    }
}

