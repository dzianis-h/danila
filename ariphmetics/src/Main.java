
public class Main {

    static void main() {
        double salary = 10000;
        final double maxUntaxableSalary = 5000;
        final double veryVeryLargeSalary = 7500;
        System.out.printf("Let's assess the salary %.2f$\n", salary);

        if (salary > maxUntaxableSalary) {
            System.out.printf("We should take taxes, because it grater then %.2f\n", maxUntaxableSalary);
            if (salary > veryVeryLargeSalary) {
                System.out.println("This salary is very-very large");
            }
        } else {
            System.out.println("We should not take taxes");
        }

    }


    public static void oldStuff(String[] args) {
//        int val1 = 5;
//        double val2 = 6;
//        double val3 = val1 / val2;
//
//        System.out.println(3.1 % 2);
//

        // Cmd+Win+L -- autoformatting in Idea

//        System.out.println("Before if");
//        if (1 < 1) {
//            System.out.println("we are in the if");
//            if (1 < 1) {
//                System.out.println("we are in the if");
//                if (1 < 1) {
//                    System.out.println("we are in the if");
//                    if (1 < 1) {
//                        System.out.println("we are in the if");
//                    }
//                }
//            }
//        }

        System.out.println("After if");
//        else {
//            System.out.println(val2);
//        }

    }
}
