package wipro;
import java.util.*;
public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Person>hs = new HashSet<>();
		for(int i=0;i<n;i++) {
			String name = sc.next();
			int age = sc.nextInt();
			Person person = new Person(name,age);
			hs.add(person);
		}
		for(Person person: hs) {
			System.out.println(hs);
		}
	}
}
class Person {
	private String name;
	private int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass()!=obj.getClass()) {
			return false;
		}
		Person p = (Person)obj;
		return age == p.age && name.equals(p.name);
	}
	public int hashCode() {
		return Objects.hash(name,age);
	}
}
