package ru.mipt.cs.cluster.nuriyaFrames;

import java.io.IOException;

import javax.swing.JFrame;

import ru.mipt.cs.cluster.io.ClusterisationInput;
import ru.mipt.cs.cluster.io.ClusterisationOutput;
import ru.mipt.cs.cluster.kmeans.KMeans;

//Thread for KMeans clustering
public class ThreadRun extends Thread {
		
	private ClusterisationInput input;
	private String name;
	
	public ThreadRun(ClusterisationInput in) {
		input = in;
	}

	public void setTName(String n) {
		name=n;
	}
	public void run() {
		
		KMeans kmeans = new KMeans();
		try {
			ClusterisationInput in = new ClusterisationInput();
			in.setAlgorithm(input.getAlgorithm());
			in.setInputImage(name);
			in.setConvergence(input.getConvergence());
			in.setNumOfClusters(input.getNumOfClusters());
			
			ClusterisationOutput out = new ClusterisationOutput();
			out = kmeans.calculate(in);
			System.out.println(in.getInputImage());
			
			JFrame frame = new ImageFrame(in, out);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocation(400, 100);

			frame.setVisible(true); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
