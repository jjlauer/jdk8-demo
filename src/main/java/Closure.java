
import java.util.*;

public class Closure {

  public static class Person {
    private String name;
    private int age;
  }

  public static void main(String[] args) throws Exception {

	Map<String,String> t = new TreeMap<String,String>( (s1, s2) -> s1.length() - s2.length() );

	t.put("hello", "world");

	t.forEach((k, v) -> {
		System.out.println(k + ": " + v);
	});

	/**
  	List<> ints = new ArrayList<>();
	ints.add(1);
	ints.add(2);
	ints.add(3);
	*/

	// does not compile
	/**		
	int sum = 0;
	ints.forEach(i -> { sum += i; });
	*/

	//int sum = ints.map(e -> e.size()).reduce(0, (a, b) -> a+b);

	//System.out.println("sum: " + sum);

	//ints.forEach(i -> { System.out.println(""+i); });
  }

	/**
  public static (int,int) a() {
  	return (1, 2);
  }
	*/

}
