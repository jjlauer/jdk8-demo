
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 Demonstrates various Scala-like mkString in Java 8 using JDK8.
*/
public class MakeString {

  public static void main(String[] args) throws Exception {
    List<Person> persons = Arrays.asList(new Person("Joe", "Lauer"), new Person("John", "Doe"), new Person("George", "Washington"));

    // single line closures can omit some syntax
    String firstThenLast = ListUtils.mkString(persons, p -> p.getFirstName() + " " + p.getLastName(), "; ");
    System.out.println("first then last: " + firstThenLast);

    // includes optional syntax
    String lastThenFirst = ListUtils.mkString(persons, (p) -> { return p.getLastName() + ", " + p.getFirstName(); }, "; ");
    System.out.println("last then first: " + lastThenFirst);

    // same result but using only java 8 std libs
    String firstThenLast2 = persons
	.stream()
	.map(p -> p.getFirstName() + " " + p.getLastName())
	.collect(Collectors.toStringJoiner("; "))
        .toString();
    System.out.println("first then last v2: " + firstThenLast2);

    // filter out first names of "John"
    String noJohns = persons
	.stream()
	.filter(p -> !p.getFirstName().equalsIgnoreCase("John"))
	.map(p -> p.getFirstName() + " " + p.getLastName())
	.collect(Collectors.toStringJoiner("; "))
        .toString();
    System.out.println("no johns: " + noJohns);
  }

  public static class ListUtils {
    static public <E> String mkString(List<E> list, Function<E,String> stringify, String delimiter) {
      int i = 0;
      StringBuilder s = new StringBuilder();
      for (E e : list) {
        if (i != 0) { s.append(delimiter); }
	s.append(stringify.apply(e));
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

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }
  }
}
