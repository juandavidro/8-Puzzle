package search.qsearch;

import java.util.HashSet;
import java.util.Set;

public class Comparar {
	public static void main(String[] args) {
		Set<Celular> cels = new HashSet<>();
		Celular p1 = new Celular("1214", 5);
		Celular p2 = new Celular("1214", 5);
		
		cels.add(p1);
		
		String a = "8374635264";
		String b = "475869"; 
		String c = "8374635264";
		String d = "475869";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		
		System.out.println(p1.equals(p2));
		
		if(cels.contains(p2))
			System.out.println("Ya esta");
		else {
			System.out.println("No esta");
		}
		
	}
}
