public class Puppy {
    private String name = "Rex";
    private int age = 3;

    public void sayHello() {
        if (age < 2) {
            System.out.println("Hello from tiny " + name);
        } else {
            System.out.println("Hello from old " + name);
        }
    }
}
