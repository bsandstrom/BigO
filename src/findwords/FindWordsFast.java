package findwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * This main method finds the number of times each word is used in a file. It is much faster than FindWordsList.
 * This process should be of O(n) complexity, since lookup in a hash map should be O(1) on average, and the 
 * final Collections.sort is only O(log(n)) and can be ignored.
 */
public class FindWordsFast {
	public static void main(String[] args) throws IOException{
		Long startTime = System.nanoTime();
		
		FileReader fr = new FileReader("C:/Users/Brent/workspace/Hashing/TheHungerGames.txt");
		BufferedReader reader = new BufferedReader(fr);
		
		Map<String, Integer> words = new HashMap<String, Integer>();
		
		String line = reader.readLine();
		while(line!= null){
			
			
			String[] lineWords = line.split(" ");
			
			for(String s : lineWords){
				//if words contains s
				if(words.containsKey(s)){
					words.replace(s, words.get(s)+1);
				}
				else{
					words.put(s, 1);
				}
			}
			
			
			line = reader.readLine();
		}
		
		
		List<Entry<String,Integer>> wordsSorted = new ArrayList<Entry<String,Integer>>(words.entrySet());
		Collections.sort(wordsSorted, new Comparator<Entry<String,Integer>>(){

			@Override
			public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
			
		});
		for(Entry<String,Integer> e : wordsSorted){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
		System.out.println("Total time : " + ((double)(System.nanoTime() - startTime)) / 1000000000l + " seconds");
	}
}
