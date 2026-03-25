package zoo;

import java.io.Serializable;


// для примера: класс Dog реализует целых 3 интерфейса: Greetable, AutoCloseable и Serializable
public class Dog extends Animal implements AutoCloseable, Serializable {
    public String sayHello() {
        return "woof";
    }

    public String sayGreeting() {
        return "This dog said: " + sayHello();
    }

    @Override
    public void close() throws Exception {

    }
}
