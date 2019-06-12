public class Person {

  String name;
  int age;

  public void greet() {
    System.out.println("Hallo, mein Name ist " + name);
  }

  public static void main(String[] args) {
    Person person = new Person();
    person.name = "Tobias";
    person.greet();

    person.age = 22;
    System.out.println(person.name  + " ist " + person.age + " Jahre alt.");
  }
}
