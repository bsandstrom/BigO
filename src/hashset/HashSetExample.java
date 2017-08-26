package hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("c");
		hashSet.add("d");
		System.out.println(hashSet);
		
		Iterator<String> it = hashSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
