import java.util.Scanner;

public class IfElse {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bitte gib eine Zahl ein");
    int number = scanner.nextInt();

    if(number < 10) {
      System.out.println("Deine Zahl ist kleiner als 10.");
    }
    else {
      System.out.println("Deine Zahl ist größer als 10.");
    }
  }
}
