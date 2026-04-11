package edu.java.tasks.loops;
import java.lang.*;
import java.lang.reflect.Array;

public class DistanceService {

    // тут нужно посчитать длину вектора, вектор начинается в 0й точке
    // и заканчивается в координате, которая задана массивом vector.
    // Длина вектора это корень квадратный суммы квадратов расстояний
    // от начала до конца вектора по каждой из осей координат.
    // Если массив пустой, то длина вектора равна нулю.
    public double calcLength(double[] vector) {

        double x = calcDistance(1,1);
        double y = calcDistance(1,1);
        double vectorLength = Math.sqrt((x + y)*(x + y));
        while (vector = 0){
            vector.length = 0;
        }
        return vectorLength;
    }

    // посчитать расстояние между двумя точками
    // (как и выше, корень от суммы квадратов разностей)
    // если у векторов разная длина, то расстояние равно нулю
    // если оба вектора нулевой длины, то расстояние тоже равно нулю
    public double calcDistance(double[] a, double[] b) {
        double distance = (a[5]) - (b[2]);
        if (distance < 0){

        }
        return -1; // todo
    }
}
