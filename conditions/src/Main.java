//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    var x = sc.nextDouble();
    System.out.println(x);


    String myString = "my string";

//    if (myString.length() == 0) {
//        System.out.println("Empty string");
//    } else if (myString.length() == 1) {
//        System.out.println("My string has 1 symbol");
//    } else if (myString.length() == 2) {
//        System.out.println("My string has " + myString.length() + " symbols");
//    } else if (myString.length() == 3) {
//        System.out.println("My string has " + myString.length() + " symbols");
//    }


//    new Scanner(System.in).nextLine();

    List<String> list = Arrays.asList("value1", "value2", "value3");
    list.contains("karamba");


    String myString2 = "my string2";
    // 1. если строка Danila или Denis, то вывести что в строке записано имя
    // 2. если строка Berlin или Kyiv, то написать в косноль что в строке написан город
    // 3. во всех остальных случаях написать что в строке какая-то фигня


    OrderStatus status = OrderStatus.PENDING_APPROVAL;

    System.out.println("====== if-else example ======");
    if (status == OrderStatus.OPEN) {
        System.out.println("The new order has been created.");
    } else if (status == OrderStatus.IN_PROGRESS || status == OrderStatus.PENDING_APPROVAL) {
        System.out.println("The order is in progress.");
    } else if (status == OrderStatus.COMPLETED || status == OrderStatus.CANCELED) {
        System.out.println("The order has  been completed");
    } else {
        System.out.println("Unknown status " + status);
    }

    System.out.println("All order statuses has been processed using if-else tree.\n");

    System.out.println("====== switch statement example ======");
    boolean wasDefault = false;
    int value = 0;
    switch (status) { // switch statement
        case OPEN:
            System.out.println("The new order has been created.");
            break;
        case IN_PROGRESS, WAITING_FOR_PAYMENT:
            System.out.println("The order is in progress.");
            break;
        case COMPLETED, CANCELED:
            System.out.println("The order has  been completed");
            break;
        default:
            wasDefault = true;
            System.out.println("Unknown status " + status);
    }

    if (wasDefault) {
        System.out.println("The default: was executed");
    }

    System.out.println("All order statuses has been processed using switch statement tree.\n");



    System.out.println("====== switch expression example ======");
    boolean wasDefault2 = false;
    switch (status) {
        case OPEN -> System.out.println("The new order has been created.");
        case IN_PROGRESS, WAITING_FOR_PAYMENT -> System.out.println("The order is in progress.");
        case COMPLETED, CANCELED -> System.out.println("The order has  been completed");
        default -> {
            wasDefault2 = true;
            System.out.println("Unknown status " + status);
        }
    }

    if (wasDefault2) {
        System.out.println("The default: was executed");
    }

    System.out.println("All order statuses has been processed using switch expression tree.\n");

}
