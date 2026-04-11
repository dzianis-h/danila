package edu.java.tasks.loops;

public class DistanceService {
    static {
        System.out.println("i'm static initialization block");
        new DistanceService().calcLength(new double[]{3, 4});
    }

    {
        System.out.println("i'm initialization block");
    }

    // тут нужно посчитать длину вектора, вектор начинается в 0й точке
    // и заканчивается в координате, которая задана массивом vector.
    // Длина вектора это корень квадратный суммы квадратов расстояний
    // от начала до конца вектора по каждой из осей координат.
    // Если массив пустой, то длина вектора равна нулю.
    public double calcLength(double[] vector) {
        // пример для вектора длиной 2 элемента
        return Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);


//        double x = calcDistance(1,1);
//        double y = calcDistance(1,1);
//        double vectorLength = Math.sqrt((x + y)*(x + y));
//        while (vector = 0){
//            vector.length = 0;
//        }
//        return vectorLength;
//        return -1;
    }

    // посчитать расстояние между двумя точками
    // (как и выше, корень от суммы квадратов разностей)
    // если у векторов разная длина, то расстояние равно нулю
    // если оба вектора нулевой длины, то расстояние тоже равно нулю
    public double calcDistance(double[] a, double[] b) {
        // пример для 2х-мерного пространства
        return Math.sqrt(
                (a[0] - b[0]) * (a[0] - b[0]) +
                        (a[1] - b[1]) * (a[1] - b[1])
        );

//        double distance = (a[5]) - (b[2]);
//        if (distance < 0){
//
//        }
//        return -1; // todo
    }
}
