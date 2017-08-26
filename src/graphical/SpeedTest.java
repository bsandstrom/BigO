package graphical;

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

import findwords.WordCount;

import java.util.TreeMap;

public class SpeedTest {
	ArrayList<String> allWords;
	private final int testsToRun = 100;
	private final int incrementSize = 200;
	/*
	 * This function runs the findWords function and tests its speed
	 * for various input sizes. It returns the values as Map<InputSize, Time>
	 */
	public Map<Integer, Double> getFindWordsFastSpeed(){
		Map<Integer, Double> speedResults = new TreeMap<Integer, Double>();
		for(int i = 1; i <= testsToRun; i++){
			int inputSize = i*incrementSize;
			Long startTime = System.nanoTime();
			findWords(getWords(inputSize));
			double time = ((double)(System.nanoTime() - startTime)) / 1000000000l;
			speedResults.put((Integer)inputSize, time);
		}
		
		return speedResults;
	}
	
	public Map<Integer, Double> getFindWordsListSpeed(){
		Map<Integer, Double> speedResults = new TreeMap<Integer, Double>();
		for(int i = 1; i <= testsToRun; i++){
			int inputSize = i*incrementSize;
			Long startTime = System.nanoTime();
			findWordsList(getWords(inputSize));
			double time = ((double)(System.nanoTime() - startTime)) / 1000000000l;
			speedResults.put((Integer)inputSize, time);
		}
		
		return speedResults;
	}
	
	private List<Entry<String,Integer>> findWords(ArrayList<String> allWords) {
		
		Map<String, Integer> words = new HashMap<String, Integer>();
		
			
					
		for(String s : allWords){
			//if words contains s
			if(words.containsKey(s)){
				words.replace(s, words.get(s)+1);
			}
			else{
				words.put(s, 1);
			}
		}
				
		
		List<Entry<String,Integer>> wordsSorted = new ArrayList<Entry<String,Integer>>(words.entrySet());
		Collections.sort(wordsSorted, new Comparator<Entry<String,Integer>>(){

			@Override
			public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
			
		});
		return wordsSorted;
	}
	
	private void findWordsList(ArrayList<String> lineWords){
		ArrayList<WordCount> words = new ArrayList<WordCount>();
					
			
			for(String lw : lineWords){
				for(WordCount wc : words){
					if(wc.getWord().equals(lw)){
						wc.increment();
						break;
					}
				}
				words.add(new WordCount(lw));
			}
		
		Collections.sort(words, new Comparator<WordCount>(){

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return ((Integer)o1.getOccurances()).compareTo(o2.getOccurances());
			}
			
		});

	}
	
	private ArrayList<String> getWords(int inputSize) {
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < inputSize; i ++){
			words.add(allWords.get(i));
		}
		return words;
	}
	
	public SpeedTest(){
		BufferedReader reader = null;
		try {
			this.allWords = new ArrayList<String>();
			
			FileReader fr = new FileReader("C:/Users/Brent/workspace/BigO/TheHungerGames.txt");
			reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			while(line!= null){
				
				String[] lineWords = line.split(" ");
				
				for(String s : lineWords){
					allWords.add(s);
				}
				
				line = reader.readLine();
			}
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Unable to access text file");
		}
		finally{
			try{
				reader.close();
			}
			catch(IOException e){}
		}
	}
}
