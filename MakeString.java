
import java.util.*;

/**
 Demonstrates Scala-like mkString in Java 8 using JDK8.
*/
public class MakeString {

  public static void main(String[] args) throws Exception {
    List<Person> persons = Arrays.asList(new Person("Joe", "Lauer"), new Person("John", "Doe"));

    // single line closures can omit some syntax
    String firstThenLast = ListUtils.mkString(persons, p -> p.getFirstName() + " " + p.getLastName(), "; ");
    System.out.println("first then last: " + firstThenLast);

    // includes optional syntax
    String lastThenFirst = ListUtils.mkString(persons, (p) -> { return p.getLastName() + ", " + p.getFirstName(); }, "; ");
    System.out.println("last then first: " + lastThenFirst);

  }

  public static interface ToString<E> {
    // functional interface contains only 1 method
    public String toString(E element);
  }

  public static class ListUtils {
    static public <E> String mkString(List<E> list, ToString<E> v, String delimiter) {
      int i = 0;
      StringBuilder s = new StringBuilder();
      for (E e : list) {
        if (i != 0) { s.append(delimiter); }
        s.append(v.toString(e));
	i++;
      }
      return s.toString();
    }
  }

  public static class Person {
    private String firstName;
    private String lastName;

    public Person(String f, String l) {
      this.firstName = f;
      this.lastName = l;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

  }

  

}
