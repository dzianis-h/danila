public class Main {
    public static void main(String[] args) {
        String result = printHello("dogs", 2);
        System.out.printf("We've created '%s'\n", result);
        printHello("cats", 5);
        printHello("pappies", 3);
    }


    private static String printHello(String animalName, int count) {
        System.out.printf("Let's create %d %s!\n", count, animalName);

        String result = "";
        for (int i = 0; i < count; i++) {
            result += animalName + " ";
        }
        return result;
    }
}




//        Puppy puppy1;// puppy1 - переменная типа Puppy
//        puppy1 = new Puppy(); // создали объект типа Puppy (new Puppy()) и присвоили его переменной puppy1
//        Puppy puppy2 = new Puppy(); // то же самое что и выше, для Puppy2
////        puppy1.sayHello(); // вызываем метод sayHello у нашего puppy1
//        puppy1.sayHello();