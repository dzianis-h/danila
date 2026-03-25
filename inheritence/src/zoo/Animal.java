package zoo;

// abstract класс МОЖЕТ содержать абстрактные методы (но не обязан)
// не абстрактный класс НЕ МОЖЕТ содержать абстрактные методы
// т.е. у абстрактного класса может быть 0 и больше абстрактных методов
// абстрактные классы нельзя создать: new Animal()
public abstract class Animal implements Greetable {
    // abstract метод - это значит что метод не реализован и все кто наследуют это класс будут обязаны его реализовать
//    public abstract String sayHello();


    @Override
    public String sayGreeting() {
        return "This animal said: " + sayHello();
    }
}
