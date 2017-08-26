package graphical;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public ApplicationFrame(SpeedChart fastChart, SpeedChart slowChart){
		setLayout(new FlowLayout());

		add(fastChart.getChartPanel());
		add(slowChart.getChartPanel());
		setSize(1500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Big O Notation Visualized");
	}
}
