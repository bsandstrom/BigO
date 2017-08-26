package graphical;

import java.util.Map;

public class Main {
	public static void main(String[] args){
		SpeedTest tester = new SpeedTest();
		
		Map<Integer, Double> findWordsFastSpeed = tester.getFindWordsFastSpeed();
		Map<Integer, Double> findWordsSlowSpeed = tester.getFindWordsListSpeed();

		SpeedChart fastChart = new SpeedChart(findWordsFastSpeed, "O(N)");
		SpeedChart slowChart = new SpeedChart(findWordsSlowSpeed, "O(N^2)");
		
		ApplicationFrame frame = new ApplicationFrame(fastChart, slowChart);
	}

}
