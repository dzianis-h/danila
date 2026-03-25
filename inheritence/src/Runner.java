import zoo.Cat;
import zoo.Dog;
import zoo.Greetable;
import zoo.Human;

import java.security.SecureRandom;

// public - видно вообще везде
//  - видно только внутри текущего пакета
// protected - видно только самому классу и наследниками
// private - видно только внутри класса
//fyi: https://www.tutorialspoint.com/java/java_access_modifiers.html

// классы (абстрактные и нет) могут содержать "конкретные" методы (не абстрактные). А интерфейсы - только абстрактные методы.
// но наследоваться можно ровно от 1 класса, зато реализовывать можно много интерфейсов

public class Runner {
    private static SecureRandom random = new SecureRandom();

    static void main() {
        var greetable = createGreetableObject();
        String helloFromAnimal = greetable.sayGreeting();
        System.out.println(helloFromAnimal);
    }

    private static Greetable createGreetableObject() {
        return switch (random.nextInt(3)) {
            case 0 -> new Cat();
            case 1 -> new Dog();
            case 2 -> new Human();
            default -> null; // null это как пустое множество, ничего. не ноль :)
        };
    }
}
