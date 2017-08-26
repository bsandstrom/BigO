package findwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * A very bad way to find the number of times each word in a file is used. This implentation is used as a baseline to compare
 * the faster version using a hashmap against. The hashmap is indeed much faster. This implementation is slow, running at O(n^2).
 */
public class FindWordsList {
	public static void main(String[] args) throws IOException{
		Long startTime = System.nanoTime();
		
		FileReader fr = new FileReader("C:/Users/Brent/workspace/Hashing/TheHungerGames.txt");
		BufferedReader reader = new BufferedReader(fr);
		ArrayList<WordCount> words = new ArrayList<WordCount>();
		
		
		String line = reader.readLine();
		while(line!= null){
			
			
			String[] lineWords = line.split(" ");
			for(String lw : lineWords){
				for(WordCount wc : words){
					if(wc.getWord().equals(lw)){
						wc.increment();
						break;
					}
				}
				words.add(new WordCount(lw));
			}
						
			line = reader.readLine();
		}
		
		
		
		Collections.sort(words, new Comparator<WordCount>(){

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return ((Integer)o1.getOccurances()).compareTo(o2.getOccurances());
			}
			
		});
		for(WordCount wc : words){
			System.out.println(wc);
		}
		
		System.out.println("Total time : " + ((double)(System.nanoTime() - startTime)) / 1000000000l + " seconds");
	}

}
