package zoo;

public class Human implements Greetable {
    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String sayGreeting() {
        return "Good day";
    }
}
