class Person(f: String, l: String) {
  var firstName: String = f
  var lastName: String = l
}

object MakeString {
  def main(args: Array[String]) {
    //println("Hello, world!")

    val persons = List(new Person("Joe", "Lauer"), new Person("John", "Doe"), new Person("George", "Washington"))

    val firstThenLast = persons
	.map(p => p.firstName + " " + p.lastName)
	.mkString("; ")
    println("first then last: " + firstThenLast)

    val lastThenFirst = persons
	.map(p => p.lastName + " " + p.firstName)
	.mkString("; ")
    println("last then first: " + lastThenFirst)

    val noJohns = persons
	.filter(p => p.firstName != "John")
	.map(p => p.firstName + " " + p.lastName)
	.mkString("; ")
    println("no johns: " + noJohns)
  }
}
